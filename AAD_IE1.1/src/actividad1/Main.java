package actividad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
/**
 * 
 * @author Miguel Alcantara Montero
 *
 */
public class Main {
	
	/**
	 * Inicia la aplicacion
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Crud crud = new Crud();
		
		// Se crea el fichero con la ruta
		File fichero = new File("./empleados.dat");
		RandomAccessFile archivo = null;
		
		// Se pasa el fichero al objeto RandomAccessFile con opcion de lectura-escrito
		try {
			archivo = new RandomAccessFile(fichero, "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Creamos el menu que nos permite trabajar con el fichero
		int key;

		do {
			System.out.println("MENÚ EMPLEADOS");
			System.out.println("Elige una opción:");
			System.out.println("1. Consulta");
			System.out.println("2. Inserción");
			System.out.println("3. Modificación");
			System.out.println("4. Borrado");
			System.out.println("0. Salir del programa");

			key = sc.nextInt();

			switch (key) {
			case 1:
				try {
					
					// Llama al metodo que lee un registro guardado
					crud.consulta(archivo);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					
					// Llama al metodo que guarda un registro en el archivo
					crud.insercion(archivo);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					
					// Llama al metodo que permite modificar el campo salario de un registro guardado
					crud.modificacion(archivo);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					
					// Llama al metodo que realiza un borrado logico de un registro guardado
					crud.borrado(archivo);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
		} while (key != 0);
		
		try {
			archivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
