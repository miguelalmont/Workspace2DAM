package actividad10;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class JugadorAdivina {

	int puerto;
	String host;
	int identificador;
	String cadena;
	Socket cliente;
	Datos datos;
	ObjectOutputStream fsalida;
	ObjectInputStream fentrada;

	public JugadorAdivina() throws IOException {
		this.puerto = 6001;
		this.host = "localhost";
		this.identificador = 0;
		this.cadena = "";
		this.cliente = new Socket(host, puerto);
		this.fsalida = new ObjectOutputStream(cliente.getOutputStream());
		this.fentrada = new ObjectInputStream(cliente.getInputStream());

	}

	public void Conectar() throws IOException, ClassNotFoundException {
		Datos datos = (Datos) fentrada.readObject();
		identificador = datos.getIdentificador();
		System.out.println("Id jugador: " + identificador);
		setIdentificador(identificador);
		System.out.println(datos.getCadena());
		if (!datos.isJuega()) {
			cadena = "*";
		}
	}

	public void EnviarNumero(String cadena2) throws IOException, ClassNotFoundException {
		System.out.println(cadena2);
		Datos d = new Datos();
		d.setCadena(cadena2);

		fsalida.reset();
		fsalida.writeObject(d);

		datos = (Datos) fentrada.readObject();
		System.out.println("\t" + datos.getCadena());
		this.cadena = datos.getCadena();
	}

	public boolean validarCadena(String cadena) {
		boolean valor = false;
		try {
			Integer.parseInt(cadena);
			valor = true;
		} catch (NumberFormatException e) {}
		return valor;
	}

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
}
