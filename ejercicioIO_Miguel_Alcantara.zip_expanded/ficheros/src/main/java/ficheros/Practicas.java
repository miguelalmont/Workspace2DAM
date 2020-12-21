package ficheros;

import java.io.File;
import java.io.IOException;

public class Practicas {

	private static final String ruta = "C:\\Users\\malcanmo\\Documents\\FP Dual\\Ficheros\\pruebas\\";

	public static void main(String[] args) throws IOException {
		//Creamos una carpeta
		System.out.println(crearCarpeta("carpeta1"));
		
		//Creamos un fichero
		System.out.println(crearFichero("fichero1.txt"));
		
		//Eliminamos el fichero
		System.out.println(eliminar("fichero1.txt"));
		
		listarCarpeta("C:\\Users\\malcanmo\\Downloads");
	}

	/**
	 * Método que crea una nueva carpeta en la ruta con el nombre indicado
	 * 
	 * @param nombre Nombre de la nueva carpeta
	 * @return true si se crea, false si no
	 */
	private static boolean crearCarpeta(String nombre) {
		File carpeta = new File(ruta+nombre);
		
		return carpeta.mkdir();
	}

	/**
	 * Método que crea un nuevo fichero en la ruta con el nombre indicado
	 * 
	 * @param nombre Nombre del nuevo fichero
	 * @return true si se crea, false si no
	 * @throws IOException
	 */
	private static boolean crearFichero(String nombre) throws IOException {
		File fichero = new File(ruta+nombre);
		
		return fichero.createNewFile();
	}

	/**
	 * Método que elimina un fichero o un directorio vacío en la ruta
	 * 
	 * @param nombre Nombre del fichero o directorio a eliminar
	 * @return true si se elimina, false si no
	 */
	private static boolean eliminar(String nombre) {
		File fichero = new File(ruta+nombre);
		
		return fichero.delete();
	}

	/**
	 * Método que lista los ficheros y directorios que existen en la carpeta
	 * indicada
	 * 
	 * @param ruta Ruta de la carpeta a listar
	 */
	private static void listarCarpeta(String ruta) {
		File objetivo = new File(ruta);
		String[] lista = objetivo.list();
		File j;
		
		for (String i :lista) {
			j = new File(ruta+"//"+i);
			if (j.isDirectory())
				System.out.println("+"+j.getName());
			else
				System.out.println("-"+j.getName()+" "+(j.length()/1024)+"Kb");
		}
	}

}
