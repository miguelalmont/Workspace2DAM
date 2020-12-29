package actividad9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServer extends Thread {
	BufferedReader fentrada;
	PrintWriter fsalida;
	Socket socket = null;

	public HiloServer(Socket s) throws IOException {
		socket = s;
		fsalida = new PrintWriter(socket.getOutputStream(), true);
		fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		String cadena = "";
		System.out.println("Conexion: " + socket.toString());

		while (!cadena.trim().equals("*")) {
			try {
				cadena = fentrada.readLine();
			} catch (IOException e) {
			}
			fsalida.println(cadena.trim().toUpperCase());
			System.out.println("=> " + cadena.trim().toUpperCase());
		}

		System.out.println("Proceso finalizado: " + socket.toString());

		fsalida.close();
		try {
			fentrada.close();
			socket.close();
		} catch (IOException e) {}
	}
}
