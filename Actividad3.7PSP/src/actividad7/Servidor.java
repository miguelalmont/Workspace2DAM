package actividad7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket; 

public class Servidor {
	
	public static void main(String[] args) {
		
		System.out.println("Programa servidor iniciado....");
		int puerto = 6000;
		ServerSocket servidor;
		try {
			servidor = new ServerSocket(puerto);
			
			
			System.out.println("Esperando al cliente....");
			Socket cliente = servidor.accept();
			
			Numeros numeroEnt;
			ObjectOutputStream objSal;
			ObjectInputStream objEnt;
			do {
				objEnt = new ObjectInputStream(cliente.getInputStream());
				numeroEnt = (Numeros) objEnt.readObject();
				System.out.println("Recibido => N�mero: " + numeroEnt.getNumero());
				
				numeroEnt.setCuadrado((long)Math.pow(numeroEnt.getNumero(), 2));
				numeroEnt.setCubo((long)Math.pow(numeroEnt.getNumero(), 3));
				
				
				objSal = new ObjectOutputStream(cliente.getOutputStream());
				objSal.writeObject(numeroEnt);
				
				System.out.println("Enviado => N�mero: " + numeroEnt.getNumero() + ", Cuadrado: " + numeroEnt.getCuadrado() + ", Cubo: " + numeroEnt.getCubo());
				
			} while (numeroEnt.getNumero() > 0);
			
			objSal.close();
			objEnt.close();
			cliente.close();
			servidor.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
