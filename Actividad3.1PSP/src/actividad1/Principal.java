package actividad1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Principal {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress dir = null;
		System.out.print("Introduce una URL, host o IP: ");
		String respuesta = sc.nextLine();
		try {
			dir = InetAddress.getByName(respuesta);
			muestraInfo(dir);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void muestraInfo(InetAddress dir) throws UnknownHostException {
		System.out.println("Name: " + dir);
		System.out.println("Local Host: " + InetAddress.getLocalHost());
		System.out.println("Host Name: " + dir);
		System.out.println("Host Name: " + dir.getHostName());
		System.out.println("Host Address: " + dir.getHostAddress());
		System.out.println("Canonical Host Name: " + dir.getCanonicalHostName());
	}

}
