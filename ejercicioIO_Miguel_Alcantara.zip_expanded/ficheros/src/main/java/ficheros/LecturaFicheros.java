package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFicheros {

	private static final String path = "C:\\Windows\\System32\\drivers\\etc\\hosts";

	public static void main(String[] args) {
		File f = new File(path);
		readFileBR(f);
	}

	/**
	 * Método para leer un fichero y mostrar su contenido por pantalla utilizando
	 * FileReader
	 * 
	 * @param textFile Fichero a leer
	 */
	private static void readFileFR(File textFile) {
		if (textFile.exists()) {
			FileReader fr = null;
			try {
				fr = new FileReader(textFile);
				int chr = fr.read();
				while (chr > -1) {
					System.out.print((char) chr);
					chr = fr.read();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != fr)
						fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Método para leer un fichero y mostrar su contenido por pantalla utilizando
	 * FileReader
	 * 
	 * @param textFile Fichero a leer
	 */
	private static void readFileBR(File textFile) {
		if (textFile.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(textFile);
				br = new BufferedReader(fr);

				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
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
