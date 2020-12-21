package actividad7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EjemploLectura {

	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		String texto;
		try {
			// Solicitamos una cadena
			System.out.println("Introduce una cadena...");
			// Leemos la entrada por teclado
			texto = br.readLine();
			// Mostramos por consola la cadena
			System.out.println("Cadena escrita : "+texto);
			// Cerramos la entrada
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
