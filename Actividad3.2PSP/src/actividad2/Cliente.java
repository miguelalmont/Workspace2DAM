package actividad2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		int puerto = 6000;
		
		Socket cliente = new Socket(host, puerto);
		
		InetAddress i = cliente.getInetAddress();
		System.out.println("Puerto local: " + cliente.getLocalPort());
		System.out.println("Puerto remoto: " + cliente.getPort());
		System.out.println("Nombre Host/IP: " + cliente.getInetAddress());
		System.out.println("Host Remoto: " + i.getHostName().toString());
		System.out.println("IP Host Remoto: " + i.getHostAddress().toString());
		
		cliente.close();
	}

}
