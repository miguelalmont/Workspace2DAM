package ejercicio2;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class SendFTPLogs {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws UnrecoverableKeyException, InvalidKeyException,
			NoSuchAlgorithmException, KeyStoreException, InvalidKeySpecException {

		FTPClient client = new FTPClient();
		String server = "localhost";
		String username;
		String pass;
		int numeroConexiones = 0;

		do {
			System.out.println("Introduce nombre de usuario: ");
			username = sc.nextLine();

			System.out.println("Introduce password: ");
			pass = sc.nextLine();

			try {
				connectFTP(client, server, username, pass);
				numeroConexiones++;

			} catch (IOException e) {
				System.err.println("ERROR AL CONECTAR CON EL SERVIDOR FTP.");
				e.printStackTrace();
			}

		} while (!username.contains("*"));

		connectSMTP(String.valueOf(numeroConexiones));
	}

	public static void connectFTP(FTPClient cliente, String servidor, String user, String pass) throws IOException {
		System.out.println("Conectandose a: " + servidor);
		cliente.connect(servidor);
		cliente.enterLocalPassiveMode();
		boolean login = cliente.login(user, pass);

		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		String direct = "/log";

		if (login) {
			System.out.println("Login correcto.");

			if (!cliente.changeWorkingDirectory(direct)) {
				String directorio = "log";
				if (cliente.makeDirectory(directorio)) {
					System.out.println("Directorio LOG creado.");
					cliente.changeWorkingDirectory(directorio);
				} else {
					System.out.println("No se ha podido crear el directorio");
					System.out.println("Desconectado...");
					System.exit(1);
				}
			}

			System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
			String currentUsersHomeDir = System.getProperty("user.home");
			String filezillaPath = currentUsersHomeDir + File.separator + "filezilla";

			String dateHourInfo = "Hora de conexion: " + LocalDateTime.now().toString();
			String archivo = "log.txt";

			String ruta = filezillaPath + File.separator + user + File.separator + cliente.printWorkingDirectory()
					+ File.separator + archivo;

			File logFile = new File(ruta);
			String logData = "";

			@SuppressWarnings("resource")
			Scanner myReader = new Scanner(logFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				logData = logData + "\n" + data;
			}

			logData = logData + "\n" + dateHourInfo;

			InputStream in = new ByteArrayInputStream(logData.getBytes());
			cliente.storeFile(archivo, in);
			in.close();
			cliente.logout();
			cliente.disconnect();

		} else
			System.out.println("Login incorrecto.");

		System.out.println("Desconectado...");
	}

	public static void connectSMTP(String contenido) throws NoSuchAlgorithmException, UnrecoverableKeyException,
			KeyStoreException, InvalidKeyException, InvalidKeySpecException {

		AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();

		System.out.println("Introduce servidor SMTP: ");
		String server = sc.nextLine();

		System.out.println("Introduce usuario del correo: ");
		String username = sc.nextLine();

		System.out.println("Introduce password: ");
		String password = sc.nextLine();

		System.out.println("Introduce puerto SMTP: ");
		int puerto = sc.nextInt();

		String remitente = username;
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

			if (client.execTLS()) {
				sendMail(client, username, password, remitente, contenido);
			} else {
				System.out.println("FALLO AL EJECUTAR STARTTLS.");
			}
		} catch (IOException f) {
			f.printStackTrace();
		}

		System.out.println("Fin de envio.");
		System.exit(0);

	}

	public static void sendMail(AuthenticatingSMTPClient client, String username, String password, String remitente,
			String contenido)
			throws IOException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {

		System.out.println("3 - " + client.getReplyString());

		if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, username, password)) {
			System.out.println("4 - " + client.getReplyString());

			System.out.println("Introduce correo destinatario: ");
			String destino1 = sc.nextLine();

			System.out.println("Introduce asunto: ");
			String asunto = sc.nextLine();

			String mensaje = "Número de usuarios conectados al servidor FTP: " + contenido;

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
