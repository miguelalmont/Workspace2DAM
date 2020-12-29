package actividad9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket servidor;
		servidor = new ServerSocket(44444);
		System.out.println("Servidor iniciado...");

		while (true) {
			Socket cliente = new Socket();
			cliente = servidor.accept();
			HiloServer hilo = new HiloServer(cliente);
			hilo.start();
		}
	}

}
