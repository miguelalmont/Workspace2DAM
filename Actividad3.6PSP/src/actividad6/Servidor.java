package actividad6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
	
	public static void main(String[] args) throws IOException{
		DatagramSocket socket = new DatagramSocket(12345);
		
		System.out.println("Servidor esperando datagrama....");
		DatagramPacket recibo;
		String mensaje;
		
		
		
		do {
			byte[] buffer = new byte[1024];
			recibo = new DatagramPacket(buffer, buffer.length);
			socket.receive(recibo);
			
			mensaje = new String(recibo.getData());
			
			System.out.println("Servidor recibe: " + mensaje);
			
			byte[] enviados = mensaje.toUpperCase().getBytes();
			
			InetAddress IPOrigen = recibo.getAddress();
			int puerto = recibo.getPort();
			
			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
			
			socket.send(envio);
		} while (!mensaje.contains("*"));
		
		System.out.println("Cerrando servidor....");
		socket.close();
		System.exit(0);
	}
}
