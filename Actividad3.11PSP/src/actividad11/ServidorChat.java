package actividad11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {

	static final int MAXIMO = 10;

	public static void main(String[] args) {
		int puerto = 44444;
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(puerto);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Servidor iniciado....");

		Socket tabla[] = new Socket[MAXIMO];
		ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla);
		Socket socket = null;
		
		while (comun.getConexiones() < MAXIMO) {
			socket = new Socket();
			try {
				socket = servidor.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}

			comun.addTabla(socket, comun.getConexiones());
			comun.setActuales(comun.getActuales() + 1);
			comun.setConexiones(comun.getConexiones() + 1);

			HiloServidor hilo = new HiloServidor(socket, comun);
			hilo.start();
		}

		try {
			socket.close();
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
