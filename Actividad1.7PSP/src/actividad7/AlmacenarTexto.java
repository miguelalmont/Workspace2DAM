package actividad7;

import java.io.File;
import java.io.IOException;


public class AlmacenarTexto {

	public static void main(String[] args) {
		
		File entrada = new File("entrada.txt");
		File salida = new File("salida.txt");
		
		ProcessBuilder pb = new ProcessBuilder("java", "actividad7.EjemploLectura").directory(new File(".\\bin"));
		
		try {
			// Redirigimos los datos de entrada y de salida del proceso 
			// a diferentes archivos y lo iniciamos
			pb.redirectInput(entrada);
			pb.redirectOutput(salida);
			pb.start();
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
