package actividad11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloServidor extends Thread {
	DataInputStream fentrada;
	Socket socket = null;
	ComunHilos comun;
	
	public HiloServidor(Socket s, ComunHilos comun) {
		this.socket = s;
		this.comun = comun;
		try {
			fentrada = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("NÚMERO DE CONEXIONES ACTUALES: " + comun.getActuales());
		String texto = comun.getMensajes();
		enviarMensajesaTodos(texto);
		
		while (true) {
			String cadena = "";
			try {
				cadena = fentrada.readUTF();
				if (cadena.trim().equals("*")) {
					comun.setActuales(comun.getActuales() - 1);
					System.out.println("NÚMERO DE CONEXIONES ACTUALES: " + comun.getActuales());
					break;
				}
				comun.setMensajes(comun.getMensajes() + cadena + "\n");
				enviarMensajesaTodos(comun.getMensajes());
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		try {
			socket.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void enviarMensajesaTodos(String texto) {
		int i;
		
		for (i = 0; i < comun.getConexiones(); i++) {
			Socket s1 = comun.getElementoTabla(i);
			if (!s1.isClosed()) {
				try {
					DataOutputStream fsalida2 = new DataOutputStream(s1.getOutputStream());
					fsalida2.writeUTF(texto);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
