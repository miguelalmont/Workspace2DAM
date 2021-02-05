package actividad4;

import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class ClienteSMTP {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws KeyStoreException, InvalidKeyException, NoSuchAlgorithmException,
			UnrecoverableKeyException, InvalidKeySpecException {
		
		AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();
		
		System.out.println("Introduce servidor SMTP: ");
		String server = sc.nextLine();
		
		System.out.println("Introduce negociación TLS (S, N): ");
		String responseTLS = sc.nextLine();
		boolean tLS;
		if (responseTLS.contains("S") || responseTLS.contains("s")) {
			tLS = true;
		} else {
			tLS = false;
		}
		
		System.out.println("Introduce usuario: ");
		String username = sc.nextLine();
		
		System.out.println("Introduce password: ");
		String password = sc.nextLine();
		
		System.out.println("Introduce puerto: ");
		int puerto = sc.nextInt();
		
		System.out.println("Introduce correo del remitente: ");
		String remitente = sc.nextLine();
		sc.nextLine();

		try {
			int respuesta;
			
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(null, null);
			KeyManager km = kmf.getKeyManagers()[0];
			
			client.connect(server, puerto);
			System.out.println("-1 -" + client.getReplyString());
			
			client.setKeyManager(km);
			
			respuesta = client.getReplyCode();
			if (!SMTPReply.isPositiveCompletion(respuesta)) {
				client.disconnect();
				System.err.println("CONEXION RECHAZADA.");
				System.exit(1);
			}
			
			client.ehlo(server);
			System.out.println("2 - " + client.getReplyString());
			
			if (tLS && client.execTLS()) {
				sendMail(client, username, password, remitente);
			} 
			else if (!tLS) {
				sendMail(client, username, password, remitente);
			}
			else {
				System.out.println("FALLO AL EJECUTAR STARTTLS.");
			}
		} catch (IOException f) { f.printStackTrace(); }
		
		System.out.println("Fin de envio.");
		System.exit(0);
	}
	
	public static void sendMail(AuthenticatingSMTPClient client, String username, String password, String remitente) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException{
		
		System.out.println("3 - " + client.getReplyString());
		
		if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, username, password)) {
			System.out.println("4 - " + client.getReplyString());
			
			System.out.println("Introduce correo destinatario: ");
			String destino1 = sc.nextLine();
			
			System.out.println("Introduce asunto: ");
			String asunto = sc.nextLine();
			
			System.out.println("Introduce el mensaje (finalizara cuando introduzcas un *): ");
			String mensaje = sc.nextLine();
			sc.useDelimiter("[*]");
			
			SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destino1, asunto);
			
			client.setSender(remitente);
			client.addRecipient(destino1);
			System.out.println("5 - " + client.getReplyString());
			
			Writer writer = client.sendMessageData();
			if (writer == null) {
				System.out.println("FALLO AL ENVIAR DATA.");
				System.exit(1);
			}
			
			writer.write(cabecera.toString());
			writer.write(mensaje);
			writer.close();
			System.out.println("6 - " + client.getReplyString());
			
			boolean exito = client.completePendingCommand();
			System.out.println("7 - " + client.getReplyString());
			
			if (!exito) {
				System.out.println("FALLO AL FINALIZAR TRANSACCION....");
				System.exit(1);
			} else {
				System.out.println("MENSAJE ENVIADO CON EXITO....");
			}
		} else {
			System.out.println("USUARIO NO AUTENTICADO.");
		}
	}
}
