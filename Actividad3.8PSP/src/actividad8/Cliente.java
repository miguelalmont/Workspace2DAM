package actividad8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		System.out.println("Programa cliente iniciado....");
		DatagramSocket cliente = new DatagramSocket();

		Persona persona = new Persona("Maria", 35);
		
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bs);
		
		out.writeObject(persona);
		out.close();
		byte[] bytes = bs.toByteArray();
		
		DatagramPacket peticion = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6000);
		cliente.send(peticion);
		System.out.println("Enviado => Persona: " + persona.getNombre() + " " + persona.getEdad());

		
		byte[] recibidos = new byte[1024];
		DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
		cliente.receive(paqRecibido);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
		ObjectInputStream in = new ObjectInputStream(bais);
		Persona personaRecibido = (Persona) in.readObject();
		in.close();
		
		System.out.println("Recibido => Persona: " + personaRecibido.getNombre() + " " + personaRecibido.getEdad());
		
		in.close();
		cliente.close();
		
	}

}
