package actividad7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Programa cliente iniciado....");
		String host = "localhost";
		int puerto = 6000;
		Socket cliente;
		try {
			cliente = new Socket(host, puerto);
			
			int num;
			ObjectOutputStream objSal;
			ObjectInputStream objEnt;
			do {
				System.out.println("Introduce un n�mero:");
				num = sc.nextInt();
				
				Numeros numeroSal = new Numeros();
				numeroSal.setNumero(num);
				
				objSal = new ObjectOutputStream(cliente.getOutputStream());
				objSal.writeObject(numeroSal);
				System.out.println("Enviado => N�mero: " + numeroSal.getNumero());
				
				objEnt = new ObjectInputStream(cliente.getInputStream());
				Numeros numeroEnt = (Numeros) objEnt.readObject();
				
				System.out.println("Recibido => N�mero: " + numeroEnt.getNumero() + ", Cuadrado: " + numeroEnt.getCuadrado() + ", Cubo: " + numeroEnt.getCubo());
				
			} while (num > 0);
			
			objSal.close();
			objEnt.close();
			cliente.close();
		
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}

}
