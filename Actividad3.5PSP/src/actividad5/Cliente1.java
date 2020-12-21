package actividad5;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String host = "localhost";
		int puerto = 6000;
		Socket cliente = new Socket(host, puerto);
		
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		
		String respuesta = flujoEntrada.readUTF();
		
		System.out.println("Recibiendo del servidor: \n\t" + respuesta);
	}

}
