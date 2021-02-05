package actividad5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

public class ClienteSMTPconPOP3 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String server = "pop.gmail.com";
		int puerto = 995;
		
		System.out.println("Introduce usuario de gmail: ");
		String username = sc.nextLine();
		
		System.out.println("Introduce password: ");
		String password = sc.nextLine();
		
		POP3SClient pop3 = new POP3SClient(true);
		
		try {
			pop3.connect(server, puerto);
			System.out.println("Conexión realizada al servidor POP3 " + server);
			
			if (!pop3.login(username, password)) {
				System.err.println("Error al hacer login.");
			} else {
				POP3MessageInfo[] men = pop3.listMessages();
				recuperarMensajes(men, pop3);
				recuperarCabeceras(men, pop3);
				recuperarContenidos(men, pop3);
				
				pop3.logout();
				
			}
			pop3.disconnect();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		System.exit(0);
	}
	
	private static void recuperarMensajes(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {
		
		for (int i = 0; i < men.length; i++) {
			System.out.println("Mensaje: " + (i + 1));
			POP3MessageInfo msginfo = men[i];
			System.out.println("Identificador: " + msginfo.identifier + ", Numero: " + msginfo.number + ", Tamaño: " + msginfo.size);
			
			System.out.println("Prueba de listUniqueIdentifier: ");
			POP3MessageInfo pmi = pop3.listUniqueIdentifier(i + 1);
			System.out.println("\tIdentificador: " + pmi.identifier + ", Numero: " + pmi.number + ", Tamaño: " + pmi.size);
		}
	}
	
	private static void recuperarCabeceras(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {
		
		for (int i = 0; i < men.length; i++) {
			System.out.println("Mensaje: " + (i + 1));
			POP3MessageInfo msginfo = men[i];
			
			System.out.println("Cabecera del mensaje: ");
			BufferedReader reader = (BufferedReader) pop3.retrieveMessageTop(msginfo.number, 0);
			
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea.toString());
			}
			reader.close();
		}
	}
	
	private static void recuperarContenidos(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {
		
		for (int i = 0; i < men.length; i++) {
			System.out.println("Mensaje: " + (i + 1));
			POP3MessageInfo msginfo = men[i];
			
			System.out.println("Contenido del mensaje: ");
			BufferedReader reader = (BufferedReader) pop3.retrieveMessage(msginfo.number);
			
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea.toString());
			}
			reader.close();
		}
	}

}
