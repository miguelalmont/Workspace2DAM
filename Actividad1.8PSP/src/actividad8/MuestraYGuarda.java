package actividad8;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class MuestraYGuarda {

	public static void main(String[] args) {
		
		File entrada = new File("entrada.txt");
		File error = new File("error.txt");
		
		ProcessBuilder pb = new ProcessBuilder("java", "actividad8.EjemploLectura").directory(new File(".\\bin"));
		try {
			
			// Redireccionamos la entrada de datos del proceso a un archivo
			pb.redirectInput(Redirect.from(entrada));
			
			// Redireccionamos la salida del proceso a este
			// mismo proceso (en este caso se mostrara el resultado por consola)
			pb.redirectOutput(Redirect.INHERIT);
			
			// Redireccionamos la salida de error del proceso a otro archivo
			pb.redirectError(Redirect.to(error));
			
			// Iniciamos el programa
			pb.start();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
