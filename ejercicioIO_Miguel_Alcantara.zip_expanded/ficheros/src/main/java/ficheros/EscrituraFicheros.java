package ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFicheros {

	private static final String path = "C:\\Users\\malcanmo\\Documents\\FP Dual\\Ficheros\\pruebas\\ficheroTexto.txt";

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		File f = new File(path);
		// Eliminamos el fichero si existe
		deleteIfExists(f);

		// Creamos el fichero
		createFile(f);

		// Escribimos en el fichero
		writeContentFW(f);

		System.out.println("Finalizado en " + (System.currentTimeMillis() - inicio) + " ms");
	}

	/**
	 * Método para escribir el contenido de un fichero de texto utilizando
	 * FileWriter
	 * 
	 * @param textFile Fichero a escribir
	 */
	private static void writeContentFW(File textFile) {
		FileWriter fw = null;
		try {
			System.out.println("Abriendo el fichero...");
			fw = new FileWriter(textFile);

			System.out.println("Escribiendo contenido...");
			for (int i = 0; i < 1000000; i++)
				fw.write("Línea " + i + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fw) {
					System.out.println("Cerrando el fichero...");
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método para escribir el contenido de un fichero de texto utilizando
	 * BufferedWriter
	 * 
	 * @param textFile Fichero a escribir
	 */
	private static void writeContentBW(File textFile) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			System.out.println("Abriendo el fichero...");
			fw = new FileWriter(textFile);
			bw = new BufferedWriter(fw);

			System.out.println("Escribiendo contenido...");
			for (int i = 0; i < 1000000; i++) {
				bw.write("Línea " + i);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != bw) {
					System.out.println("Cerrando el fichero...");
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
	 * Método para crear un fichero
	 * 
	 * @param textFile Fichero a crear
	 * @return
	 */
	private static boolean createFile(File textFile) {
		boolean create = false;
		try {
			if (!textFile.exists()) {
				textFile.createNewFile();
				create = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return create;
	}

	/**
	 * Método para eliminar un fichero (si existe)
	 * 
	 * @param textFile Fichero a eliminar
	 * @return
	 */
	private static boolean deleteIfExists(File textFile) {
		boolean delete = false;
		if (textFile.exists()) {
			textFile.delete();
			delete = true;
		}
		return delete;
	}

}
