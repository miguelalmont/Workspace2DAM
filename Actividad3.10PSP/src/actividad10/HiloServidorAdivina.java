package actividad10;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidorAdivina extends Thread {

	ObjectInputStream fentrada;
	ObjectOutputStream fsalida;
	Socket socket = null;
	ObjetoCompartido objeto;
	int identificador;
	int intentos = 0;

	public HiloServidorAdivina(Socket s, ObjetoCompartido objeto, int id) {

		this.socket = s;
		this.objeto = objeto;
		this.identificador = id;
		try {
			fsalida = new ObjectOutputStream(socket.getOutputStream());
			fentrada = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.err.println("ERROR DE E/S en HiloServidor");
		}
	}

	@Override
	public void run() {
		System.out.println("=>Cliente conectado: " + identificador);

		Datos datos = new Datos("Adivina un NUMERO ENTRE 1 y 25", intentos, identificador);

		if (objeto.seAcabo()) {
			datos.setCadena("LO SENTIMOS, EL JUEGO HA TERMINADO, ALGUIEN HA ADIVINADO EL Nº");
			datos.setJuega(false);
		}
		try {
			fsalida.reset();
			fsalida.writeObject(datos);
		} catch (IOException e) {
			System.err.println("Error en el Hilo al realizar el primer envio al jugador: " + identificador);
			return;
		}

		while (!objeto.seAcabo() || !(datos.getIntentos() == 5)) {
			int numecli = 0;
			try {
				Datos d = (Datos) fentrada.readObject();
				numecli = Integer.parseInt(d.getCadena());

			} catch (IOException e) {
				System.err.println("Error en el Hilo al leer del jugador: " + identificador);
				break;
			} catch (NumberFormatException n) {
				System.err.println("El jugador " + identificador + " se ha desconectado");
				break;
			} catch (ClassNotFoundException e) {
				break;
			}

			String cad = objeto.nuevaJugada(identificador, numecli);
			intentos++;

			datos = new Datos(cad, intentos, identificador);

			if (objeto.seAcabo()) {
				datos.setJuega(false);
				if (identificador == objeto.getGanador()) {
					datos.setGana(true);
				}
			}
			try {
				fsalida.reset();
				fsalida.writeObject(datos);
			} catch (IOException n1) {
				System.err.println(
						"Error escribiendo en flujo de salida del jugador: " + identificador + " * " + n1.getMessage());
				break;
			} catch (NullPointerException n) {
				System.err.println("El jugador " + identificador + " ha desconectado");
				break;
			}
		}

		if (objeto.seAcabo()) {
			System.out.println("EL JUEGO SE HA ACABADO.....");
			System.out.println("\t==>Desconecta: " + identificador);
		}
		try {
			fsalida.close();
			fentrada.close();
			socket.close();
		} catch (IOException e) {
			System.err.println("Error en Hilo al cerrar cliente: " + identificador);
		}
	}
}
