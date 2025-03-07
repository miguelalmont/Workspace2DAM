package actividad8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		System.out.println("Programa servidor iniciado....");
		int puerto = 6000;
		DatagramSocket servidor = new DatagramSocket(puerto);
		
		System.out.println("Esperando al cliente....");
		
		byte[] recibidos = new byte[1024];
		DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
		servidor.receive(paqRecibido);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
		ObjectInputStream in = new ObjectInputStream(bais);
		Persona persona = (Persona) in.readObject();
		in.close();
		
		System.out.println("Recibido => Persona: " + persona.getNombre() + " " + persona.getEdad());
		
		persona.setNombre("Mario");
		persona.setEdad(53);
		
		
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bs);
		
		out.writeObject(persona);
		out.close();
		
		System.out.println("Enviado => Persona: " + persona.getNombre() + " " + persona.getEdad());
		
		out.writeObject(persona);
		out.close();
		byte[] bytes = bs.toByteArray();
		
		DatagramPacket peticion = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6000);
		servidor.send(peticion);
		
		servidor.close();
		
	}

}
