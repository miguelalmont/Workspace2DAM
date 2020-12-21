package actividad2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int puerto = 6000;
		ServerSocket servidor = new ServerSocket(puerto);
		System.out.println("Escuchando en " + servidor.getLocalPort());
		
		Socket cliente1 = servidor.accept();
		
		Socket cliente2 = servidor.accept();
		
		servidor.close();
	}

}
