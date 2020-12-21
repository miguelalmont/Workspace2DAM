package ficheros;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class CopiarFichero {

	public static void main(String[] args) {

		File origen = new File("C:\\Users\\malcanmo\\Documents\\FP Dual\\Ficheros\\pruebas\\ficheroTexto.txt");
		File destino = new File("C:\\Users\\malcanmo\\Documents\\FP Dual\\Ficheros\\pruebas\\ficheroTexto-copia.txt");

		copiarTexto(origen, destino);

	}

	/**
	 * Método que copia el fichero origen en el destino utilizando InputStream y
	 * OutputStream
	 * 
	 * @param origen  Fichero a copiar
	 * @param destino Destino de la copia
	 */
	private static void copiarBinario(File origen, File destino) {
		InputStream is = null;
		FileOutputStream os = null;

		try {
			is = new FileInputStream(origen);
			os = new FileOutputStream(destino);

			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) > 0)
				os.write(buffer, 0, len);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método que copia el fichero origen en el destino utilizando InputStream y
	 * OutputStream
	 * 
	 * @param origen  Fichero a copiar
	 * @param destino Destino de la copia
	 */
	private static void copiarBinarioBuffer(File origen, File destino) {
		InputStream is = null;
		FileOutputStream os = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			is = new FileInputStream(origen);
			os = new FileOutputStream(destino);
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(os);

			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) > 0)
				os.write(buffer, 0, len);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
				if (is != null)
					is.close();
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método que copia el fichero origen en el destino utilizando InputStream y
	 * OutputStream
	 * 
	 * @param origen  Fichero a copiar
	 * @param destino Destino de la copia
	 */
	private static void copiarTexto(File origen, File destino) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader(origen);
			fw = new FileWriter(destino);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
				if (fr != null)
					fr.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
