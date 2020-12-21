package actividad5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MuestraError {

	public static void main(String[] args) {
		
		Process proceso;
		try {
			// Creamos e iniciamos el proceso que ejecutará un programa que no existe
			proceso = new ProcessBuilder("java", "NoExiste").start();
			
			// Transformamos el flujo de entrada del error a BufferedReader para poder
			// leerlo como una cadena
			InputStream error = proceso.getErrorStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(error));
			String linea = null;
			while ((linea = br.readLine()) != null)
				System.err.println(linea);
			
			
			// Almacenamos el valor de salida del proceso y lo imprimimos
			int exitVal;
			exitVal = proceso.waitFor();
			System.out.println("Valor de salida: "+exitVal);
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
