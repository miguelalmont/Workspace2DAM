package actividad3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String host = "localhost";
		int puerto = 6000;
		System.out.println("Programa cliente iniciado....");
		Socket cliente = new Socket(host, puerto);
		
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		
		String textoEntrada = flujoEntrada.readUTF();
		
		System.out.println("Recibiendo del servidor: \n\t" + textoEntrada);
		
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		
		flujoSalida.writeUTF(textoEntrada.toLowerCase());
		
		flujoEntrada.close();
		flujoSalida.close();
		cliente.close();
	}

}
