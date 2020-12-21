package actividad2;

import java.util.ArrayList;
import java.util.Scanner;
import controlExcepciones.Excepciones;

/**
 * Clase que contiene metodos para trabajar con una lista de Departamentos
 * @author migue
 *
 */
public class Crud {
	
	Excepciones ex = new Excepciones();
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Metodo que inserta un departamento en la lista
	 * @param departamentos
	 * @return
	 */
	public ArrayList<Departamento> insertar(ArrayList<Departamento> departamentos) {
		boolean existe = false;
		
		//Pedimos el Número de departamento a insertar
		System.out.println("Introduce el Número de departamento a introducir:");
		int num = ex.controlInt();
		
		// Comprobamos si el Número ya existe
		if (!departamentos.isEmpty()) {
			for (int i = 0; i < departamentos.size(); i++) {
				if (departamentos.get(i).getNumero() == num) {
					existe = true;
				}
			}
		}
		
		// Si existe, lo comunicamos y nada mas
		if (existe) {
			System.out.println("Ya existe un departamento con ese Número.");
		}
		
		// Si no, pedimos los datos con los que creamos un Departamento y lo aniadimos a la lista
		else {
			System.out.println("Introduce el nombre:");
			String nombre = sc.next();
			System.out.println("Introduce la localidad:");
			String localidad = sc.next();
			
			Departamento departamento = new Departamento(num,nombre,localidad);
			
			departamentos.add(departamento);
			
			System.out.println("Departamento añadido.");
		}
		
		return departamentos;
	}
	
	/**
	 * Metodo que permite consultar un Departamento en la lista
	 * @param departamentos
	 * @return
	 */
	public ArrayList<Departamento> consultar(ArrayList<Departamento> departamentos) {
		boolean existe = false;
		int objetivo = 0;
		
		// Pedimos el numero de Departamento
		System.out.println("Introduce el Número de departamento a consultar:");
		int num = ex.controlInt();
		
		// Comprobamos si existe en la lista
		if (!departamentos.isEmpty()) {
			for (int i = 0; i < departamentos.size(); i++) {
				if (departamentos.get(i).getNumero() == num) {
					objetivo = i;
					existe = true;
				}
			}
		}
		
		// Si existe, imprimimos por consola los datos
		if(existe) {
			System.out.println("Departamento número: "+departamentos.get(objetivo).getNumero()+", nombre: "+departamentos.get(objetivo).getNombre()+", localidad: "+departamentos.get(objetivo).getLocalidad());
		
		// Si no existe, se comunica
		} else {
			System.out.println("No existe el número de departamento introducido.");
		}
		
		return departamentos;
	}
	
	/**
	 * Metodo que permite hacer una modificacion a un Departamento de la lista
	 * @param departamentos
	 * @return
	 */
	public ArrayList<Departamento> modificar(ArrayList<Departamento> departamentos) {
		boolean existe = false;
		int objetivo = 0;
		
		// Pedimos el numero de departamento
		System.out.println("Introduce el Número de departamento a modificar:");
		int num = ex.controlInt();
		
		// Comprobamos si el numero existe en la lista
		if (!departamentos.isEmpty()) {
			for (int i = 0; i < departamentos.size(); i++) {
				if (departamentos.get(i).getNumero() == num) {
					objetivo = i;
					existe = true;
				}
			}
		}
		
		// Si existe, pedimos los nuevos datos y los cambiamos por los antiguos
		if(existe) {
			System.out.println("Introduce el nuevo nombre:");
			String nombre = sc.next();
			System.out.println("Introduce la nueva localidad:");
			String localidad = sc.next();
			
			System.out.println("Departamento número "+objetivo+", nombre "+departamentos.get(objetivo).getNombre()+", localidad "+departamentos.get(objetivo).getLocalidad());
			departamentos.get(objetivo).setNombre(nombre);
			System.out.println("Nuevo nombre: "+nombre);
			departamentos.get(objetivo).setLocalidad(localidad);
			System.out.println("Nueva localidad: "+localidad);
		}
		
		// Si no existe, se comunica
		else {
			System.out.println("El departamento introducido no existe.");
		}
		return departamentos;
	}
	
	/**
	 * Metodo que permite borrar un Departamento de la lista
	 * @param departamentos
	 * @return
	 */
	public ArrayList<Departamento> borrar(ArrayList<Departamento> departamentos) {
		boolean existe = false;
		int objetivo = 0;
		
		// Pedimos el numero de departamento a borrar
		System.out.println("Introduce el Número de departamento a eliminar:");
		int num = ex.controlInt();
		
		//Comprobamos si el numero existe en el array
		if (!departamentos.isEmpty()) {
			for (int i = 0; i < departamentos.size(); i++) {
				if (departamentos.get(i).getNumero() == num) {
					objetivo = i;
					existe = true;
				}
			}
		}
		
		// Si existe, lo borramos del array y lo comunicamos
		if (existe) {
			departamentos.remove(objetivo);
			System.out.println("El departamento número "+objetivo+" ha sido eliminado.");
			System.out.println("El total de apartamentos registrados es: "+departamentos.size());
		}
		// Si no existe, lo comunicamos
		else {
			System.out.println("El departamento introducido no existe.");
		}
		return departamentos;
	}
}
