import java.io.File;
import java.io.IOException;

public class ComprobarSalida {

	public static void main(String[] args) throws IOException {
		
		// Creamos el array con el comando a ejecutar
		String[] comando = {"java", "LeerNombre", "PAKITO"};
		
		// Creamos el objeto ProcessBuilder que ejecutará LeerNombre
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		// Le decimos al objeto la carpeta que contiene el fichero .class
		pb.directory(new File(".\\bin"));
		
		// Lanzamos el proceso
		Process proceso = pb.start();
		
		int exitVal;
		try {
			// Almacenamos el valor de salida del proceso en una variable
			exitVal = proceso.waitFor(); 
			// Imprimimos el valor por consola
			// Si en el comando añadimos argumentos, este valor será 1
			// Si ejecutamos la clase sin argumentos, el valor será -1
			System.out.println("Valor de salida: "+exitVal);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
