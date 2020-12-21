package actividad4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		int puerto = 6000;
		ServerSocket servidor = new ServerSocket(puerto);
		Socket cliente = null;
		System.out.println("Esperando al cliente....");
		cliente = servidor.accept();
		
		OutputStream salida = null;
		salida = cliente.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);
		
		System.out.print("Introduce un número entero: ");
		int numero = sc.nextInt();
		
		flujoSalida.writeInt(numero);
		
		InputStream entrada = null;
		entrada = cliente.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		
		System.out.println("Recibiendo del CLIENTE: \n\t" + flujoEntrada.readInt());
		
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		cliente.close();
		servidor.close();
	}
}
