package actividad1;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ClienteFTP {

	public static void main(String[] args) {
		FTPClient cliente = new FTPClient();
		String servFTP = "localhost";
		System.out.println("Nos conectamos a: " + servFTP);
		String usuario = "usuario1";
		String clave = "usuario";
		try {
			cliente.connect(servFTP);
			cliente.enterLocalPassiveMode();

			boolean login = cliente.login(usuario, clave);
			if (login)
				System.out.println("Login correcto...");
			else {
				System.out.println("Login incorrecto...");
				cliente.disconnect();
				System.exit(1);
			}
			System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
			FTPFile[] files = cliente.listFiles();
			System.out.println("Ficheros en el directorio actual: " + files.length);

			String tipos[] = { "Fichero", "Directorio", "Enlace simb." };

			for (int i = 0; i < files.length; i++) {
				System.out.println("\t" + files[i].getName() + " => " + tipos[files[i].getType()]);
			}

			boolean logout = cliente.logout();
			if (logout)
				System.out.println("Logout del servidor FTP...");
			else
				System.out.println("Error al hacer Logout...");

			cliente.disconnect();
			System.out.println("Desconectado...");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
