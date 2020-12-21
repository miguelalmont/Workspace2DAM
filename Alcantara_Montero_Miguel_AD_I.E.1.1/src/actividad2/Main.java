package actividad2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import controlExcepciones.Excepciones;
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
		File fichero = new File("./departamentos.dat");
		FileInputStream fis;
		ObjectInputStream ois;
		FileOutputStream fos;
		ObjectOutputStream oos;
		Excepciones ex = new Excepciones();
		ArrayList<Departamento> departamentos = new ArrayList<>();
		ArrayList<Departamento> lista = new ArrayList<>();
		Crud crud = new Crud();
		
		// Si el archivo esta vacio, lo leemos y añadimos al array "departamentos" cada uno de los
		// objetos guardados para empezar a trabajar con ellos, una vez leidos cerramos el flujo de entrada
		if (fichero.length() != 0) {
			try {
				// Pasamos el contenido del fichero al flujo de entrada
				fis = new FileInputStream(fichero);
				ois = new ObjectInputStream(fis);
				
				Departamento departamento = new Departamento();
				
				// Leemos cada objeto del fichero y lo añadimos al array "departamentos" ordenado
				try {
					while(true) {
						departamento = (Departamento) ois.readObject();
						departamentos.add(departamento);
					}
				}
				// Una vez se llegue al final del fichero, controlamos la excepcion y
				// cerramos el flujo de entrada
				catch(EOFException | ClassNotFoundException eof){
					ois.close();
					fis.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Iniciamos el menu con las opciones que permitiran el CRUD con el archivo
		int key;

		do {
			System.out.println("MENÚ DEPARTAMENTOS");
			System.out.println("Elige una opción:");
			System.out.println("1. Consultar departamento");
			System.out.println("2. Insertar departamento");
			System.out.println("3. Modificar departamento");
			System.out.println("4. Borrar departamento");
			System.out.println("0. Salir del programa");

			key = ex.controlInt();

			switch (key) {
			case 1:
				// LLama al metodo que consulta el array que cargamos al inicio del programa
				crud.consultar(departamentos);
				break;
			case 2:
				
				// Llama al metodo que inserta un objeto en el array
				lista = crud.insertar(departamentos);
				break;
			case 3:
				// Llama al metodo que modifica los valores de unos de los objetos del array
				lista = crud.modificar(departamentos);
				break;
			case 4:
				// Llama al metodo que elimina uno de los objetos del array
				lista = crud.borrar(departamentos);
				break;
			default:
				break;
			}
		} while (key != 0);
		
		// Por ultimo, antes de salir de la aplicacion, se sobreescribe el archivo con
		// los objetos del array
		try {
			//Abrimos el flujo de salida
			fos = new FileOutputStream(fichero);
			oos = new ObjectOutputStream(fos);
			
			//Recorremos el array escribiendo cada objeto por orden
			for(int i = 0; i < lista.size(); i++) {
				oos.writeObject(lista.get(i));
			}
			
			//Cerramos el flujo de salida
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
