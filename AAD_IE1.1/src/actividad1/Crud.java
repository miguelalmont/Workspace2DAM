package actividad1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
/**
 * 
 * @author Miguel Alcantara Montero
 *
 */
public class Crud {

	Scanner sc = new Scanner(System.in);
	
	/**
	 * Metodo que permite consultar un empleado guardado en el archivo
	 * @param archivo
	 * @throws IOException
	 */
	public void consulta(RandomAccessFile archivo) throws IOException {
		int posicion = 0;
		boolean existe = false;
		char apellido[] = new char[10];
		
		//Pedimos la ID del registro que queremos consultar
		System.out.println("Introduce el ID del empleado a consultar:");
		int id = sc.nextInt();
		
		// Comprobamos que la ID que se consulta exista en la lista y si es asi, guardamos la posicion
		if (archivo.length() != 0) {
			for (int i = 0; i < archivo.length(); i += 36) {
				archivo.seek(i);
				if (archivo.readInt() == id) {
					posicion = i;
					existe = true;
					break;
				}
			}
		}
		
		// Si existe la ID, ponemos el puntero al inicio de ese registro
		// y leemos cada tipo de dato, para luego imprimirlos por consola
		if (existe) {
			archivo.seek(posicion);

			id = archivo.readInt();

			for (int i = 0; i < 10; i++) {
				char aux = archivo.readChar();
				apellido[i] = aux;
			}

			String apellidos = new String(apellido);

			int departamento = archivo.readInt();
			double salario = archivo.readDouble();

			System.out.println("ID: " + id);
			System.out.println("Apellido: " + apellidos);
			System.out.println("Departamento: " + departamento);
			System.out.println("Salario: " + salario);
			
		// Si no existe el registro buscado, se comunica por consola
		} else {
			System.out.println("ID: " + id + ", NO EXISTE EMPLEADO...");
		}
	}
	
	/**
	 * Metodo que permite guardar un empleado nuevo en el archivo
	 * @param archivo
	 * @throws IOException
	 */
	public void insercion(RandomAccessFile archivo) throws IOException {
		boolean existe = false;
		
		// Se pide la ID del registro que queremos insertar
		System.out.println("Inserta el ID del nuevo empleado:");
		int id = sc.nextInt();
		
		// Comprobamos si el registro ya existe en el archivo
		if (archivo.length() != 0) {
			for (int i = 0; i < archivo.length(); i += 36) {
				archivo.seek(i);
				if (archivo.readInt() == id) {
					existe = true;
					break;
				}
			}
		}
		
		// Si existe se comunica por consola
		if (existe) {
			System.out.println("EL ID YA EXISTE...");
			
		// Si no existe ponemos el puntero en el inicio del archivo en caso de que sea un archivo vacio,
		// o al final del archivo si este ya contiene otros registros
		} else {
			
			// Comprueba la longitud del archivo, si es 0, se pone el puntero al inicio,
			// y si no, se coloca al final del contenido del archivo
			if (archivo.length() != 0) {
				archivo.seek(archivo.length());

			} else {
				archivo.seek(0);
			}
			
			// Pedimos por teclado el resto de datos y los vamos escribiendo en el archivo
			archivo.writeInt(id);

			System.out.println("Inserta el nombre:");
			String nombre = sc.next();

			StringBuffer buffer = new StringBuffer(nombre);
			buffer.setLength(10);
			archivo.writeChars(buffer.toString());

			System.out.println("Inserta el departamento:");
			int departamento = sc.nextInt();
			archivo.writeInt(departamento);

			System.out.println("Inserta el salario:");
			double salario = sc.nextDouble();
			archivo.writeDouble(salario);

			System.out.println("Empleado insertado correctamente");
		}
	}
	
	/**
	 * Metodo que permite hacer un incremento en el salario de un empleado
	 * @param archivo
	 * @throws IOException
	 */
	public void modificacion(RandomAccessFile archivo) throws IOException {
		int posicion = 0;
		boolean existe = false;
		char apellido[] = new char[10];
		
		// Se pide la ID del registro que queremos modificar
		System.out.println("Introduce el ID del empleado a consultar:");
		int id = sc.nextInt();
		
		// Comprueba si la ID existe entre los registros del archivo
		if (archivo.length() != 0) {
			for (int i = 0; i < archivo.length(); i += 36) {
				archivo.seek(i);
				if (archivo.readInt() == id) {
					posicion = i;
					existe = true;
					break;
				}
			}
		}
		
		// Si existe, leemos los datos "apellido" y "salario", y este ultimo lo incrementamos
		// la cantidad que se ha introducido por teclado
		if (existe) {
			
			// Se pide la cantidad a incrementar
			System.out.println("Introduce el incremento de sueldo:");
			double incremento = sc.nextDouble();
			
			// Colocamos el puntero al inicio del dato "apellido"
			archivo.seek(posicion + 4);
			
			// Leemos el apellido caracter por caracter
			for (int i = 0; i < 10; i++) {
				char aux = archivo.readChar();
				apellido[i] = aux;
			}
			
			// Lo almacenamos en una variable
			String apellidos = new String(apellido);
			
			// Ponemos el puntero al inicio del dato "salario"
			archivo.seek(archivo.getFilePointer() + 4);
			
			// Lo leemos
			double salario = archivo.readDouble();
			
			// Volvemos a poner el puntero al inicio de "salario"
			archivo.seek(archivo.getFilePointer() - 8);
			
			// Sobreescribimos el dato con la suma del incremento
			archivo.writeDouble(salario + incremento);
			
			System.out.println("Apellido: " + apellidos + ", Salario antiguo: " + salario + "€, Salario nuevo: "
					+ (salario + incremento) + "€");

		} else {
			System.out.println("ID: " + id + ", NO EXISTE EMPLEADO...");
		}
	}
	
	/**
	 * Metodo que permite hacer un borrado logico de un registro guardado
	 * @param archivo
	 * @throws IOException
	 */
	public void borrado(RandomAccessFile archivo) throws IOException {
		int posicion = 0;
		boolean existe = false;
		
		// Pedimos por teclado la ID del registro a eliminar
		System.out.println("Introduce el ID del empleado para eliminarlo:");
		int id = sc.nextInt();
		
		// Comprobamos si el registro existe en el archivo
		if (archivo.length() != 0) {
			for (int i = 0; i < archivo.length(); i += 36) {
				archivo.seek(i);
				if (archivo.readInt() == id) {
					posicion = i;
					existe = true;
					break;
				}
			}
		}
		
		// Si existe, colocamos el puntero al inicio del registro y vamos sobreescribiendo los datos
		// conforme se pide en la actividad
		if (existe) {
			archivo.seek(posicion);

			archivo.writeInt(-1);
			String apellidos = Integer.valueOf(id).toString();

			StringBuffer buffer = new StringBuffer(apellidos);
			buffer.setLength(10);
			archivo.writeChars(buffer.toString());

			archivo.writeInt(0);
			archivo.writeDouble(0);

			System.out.println("Empleado ID: " + id + " ha sido borrado");
		} else {
			System.out.println("ID: " + id + ", NO EXISTE EMPLEADO...");
		}
	}
}
