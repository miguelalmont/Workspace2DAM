package actividad6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		DatagramSocket clientSocket = new DatagramSocket();
		
		InetAddress IPServidor = InetAddress.getLocalHost();
		int puerto = 12345;
		
		System.out.print("Introduce mensaje: ");
		String cadena = sc.nextLine();
		
		byte[] enviados = new byte[1024];
		enviados = cadena.getBytes();
		
		DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
		
		clientSocket.send(envio);
		
		byte[] recibidos = new byte[1024];
		DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
		System.out.println("Esperando datagrama....");
		
		clientSocket.setSoTimeout(5000);
		
		try {
			clientSocket.receive(recibo);
		} catch(Exception ex) {
			System.out.println("El paquete se ha perdido.");
		}
		
		String respuesta = new String(recibo.getData());
		
		System.out.println(respuesta);
		
		clientSocket.close();
		
	}

}
