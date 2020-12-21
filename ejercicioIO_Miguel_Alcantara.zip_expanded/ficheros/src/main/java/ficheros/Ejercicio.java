package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio {

	private static final String rutaCarpeta = "C:\\Users\\malcanmo\\Documents\\FP Dual\\Ficheros\\pruebas";
	private static final String separador = ",";
	private static final String nombreCsv = "listado-elementos.csv";
	private static Map<String, Long> listaElementos = new HashMap<String, Long>();
	
	
	public static void main(String[] args) {
		
		//Rellenamos el hasmap con la lista de ficheros de la carpeta
		cargarLista();
		
		//Generamos un fichero csv con los valores separados por comas
		generarCsv();
		
		//Leemos el fichero y mostramos por pantalla los elementos
		leerCsv();

	}
	
	/**
	 * Método que debe recorrer todos los elementos que exista en la carpeta
	 * "rutaCarpeta" y añadir sus nombres y tamaños (en KB) a la lista
	 * "listaElementos"
	 */
	private static void cargarLista() {	
		
		String[] contenido = new File(rutaCarpeta).list();
		File j;
		
		for (String i : contenido) {
			j = new File(rutaCarpeta+"//"+i);
			if (j.isDirectory())
				listaElementos.put(i, (long) 0);
			else
				listaElementos.put(i, (j.length()/1024));
		}
	}
	
	/**
	 * Método que genera un fichero csv a partir de los datos existentes en el
	 * HashMap
	 */
	private static void generarCsv() {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(rutaCarpeta+"\\"+nombreCsv);
			bw = new BufferedWriter(fw);

			for (String i : listaElementos.keySet()) {
				bw.write(i  + separador + listaElementos.get(i));
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != bw) {
					bw.close();
				}
				if (null != fw) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que lee el csv y muestra por pantalla el nombre y el tamaño de cada
	 * elemento
	 */
	private static void leerCsv() {
		
		File file = new File(rutaCarpeta+"\\"+nombreCsv);
		
		if (file.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				String line;
				String[] parts;
				String print = "";
				while ((line = br.readLine()) != null) {
					parts = line.split(separador);
					parts[1] = parts[1].toString();
					print += parts[0]+" ("+parts[1]+"KB)\n";
				}
				System.out.print(print);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					System.out.println("Cerrando fichero...");
					if (null != fr)
						fr.close();
					if (null != br)
						br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
