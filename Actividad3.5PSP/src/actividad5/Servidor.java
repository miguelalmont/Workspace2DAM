package actividad5;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int puerto = 6000;
		ServerSocket servidor = new ServerSocket(puerto);
		
		System.out.println("Introduce el número de clientes: ");
		int nCli = sc.nextInt();
		System.out.println("Servidor escuchando en " + servidor.getLocalPort());
		
		Socket[] clientes = new Socket[nCli];
		
		for (int i = 0; i < nCli; i++) {
			clientes[i] = servidor.accept();
			DataOutputStream flujoSalida = new DataOutputStream(clientes[i].getOutputStream());
			flujoSalida.writeUTF("Cliente " + (i + 1));
		}
		
		servidor.close();
	}

}
