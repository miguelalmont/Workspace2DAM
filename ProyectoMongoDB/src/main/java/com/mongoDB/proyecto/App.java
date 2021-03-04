package com.mongoDB.proyecto;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class App {

	private static Connection connection = new Connection();
	private static MongoCollection<Document> collection;
	private static Excepciones ex = new Excepciones();

	public static void main(String[] args) {

		// Establece la conexion con la base de datos.
		MongoDatabase db = connection.connect("localhost", 27017, "modulos");
		
		// Almacena la coleccion y la crea si no existe.
		collection = db.getCollection("modulos");
		
		// Si la coleccion esta vacia, la rellena.
		if (!collection.find().iterator().hasNext())
			connection.fillBD(collection);
		
		// Muestra el menu principal
		showMenu();
	}
	
	public static void showMenu() {
		int key = 0;
		do {
			System.out.println("MENU DE GESTION MODULOS FP");
			System.out.println("--------------------------");
			System.out.println("1. Listar todos los modulos FP.");
			System.out.println("2. Agregar modulo FP.");
			System.out.println("3. Modificar modulo FP.");
			System.out.println("4. Eliminar modulo FP.");
			System.out.println("5. Ejecución de pipelines.");
			System.out.println("0. Salir.");
			
			key = ex.controlInt();
			
			switch (key) {
				case 1:
					showListar();
					break;
				case 2:
					showInsertar();
					break;
				case 3:
					showModificar();
					break;
				case 4:
					showEliminar();
					break;
				case 5:
					showPipelines();
					break;
				case 0:
					connection.disconnect();
					System.out.println("SALIENDO DEL PROGRAMA....");
					System.exit(0);
					break;
				default:
					break;
			}
		} while (key != 0);
	}
	
	public static void showInsertar() {
		System.out.println("MENU DE INSERCION DE MODULO");
		System.out.println("---------------------------");
		System.out.println("Introduce la ID del modulo:");
		String id = ex.controlString();
		System.out.println("Introduce el nombre del modulo:");
		String nombre = ex.controlString();
		System.out.println("Introduce el curso del modulo:");
		String curso = ex.controlString();
		System.out.println("Introduce el numero de horas semanales:");
		double horasSemanales = ex.controlDouble();
		System.out.println("Introduce el ciclo al que pertenece el modulo:");
		String ciclo = ex.controlString();
		
		connection.insertFPModule(id, nombre, curso, horasSemanales, ciclo, collection);
	}
	
	public static void showListar() {
		System.out.println("LISTA DE MODULOS FP");
		System.out.println("-------------------");
		
		MongoCursor<Document> cursor = connection.findAll(collection);
		
		if (cursor.hasNext()) {
			while (cursor.hasNext()) {
				Document document = cursor.next();
				System.out.println("ID: " + document.getString("id") +
						", Nombre: " + document.getString("nombre") +
						", Horas Semanales: " + document.getDouble("horasSemanales") +
						", Ciclo: " + document.get("ciclo"));
			}
		} else {
			System.out.println("Lista vacia.");
		}
	}
	
	public static void showModificar() {
		System.out.println("MENU DE MODIFICACION DE MODULO");
		System.out.println("---------------------------");
		System.out.println("Introduce la ID del modulo a modificar:");
		String id = ex.controlString();
		System.out.println("Introduce el nuevo nombre del modulo:");
		String nombre = ex.controlString();
		System.out.println("Introduce el nuevo curso del modulo:");
		String curso = ex.controlString();
		System.out.println("Introduce el nuevo numero de horas semanales:");
		double horasSemanales = ex.controlDouble();
		System.out.println("Introduce el nuevo ciclo al que pertenece el modulo:");
		String ciclo = ex.controlString();
		
		connection.updateFPModule(id, nombre, curso, horasSemanales, ciclo, collection);
	}
	
	public static void showEliminar() {
		System.out.println("MENU DE ELIMINACION DE MODULO");
		System.out.println("---------------------------");
		System.out.println("Introduce la ID del modulo a eliminar:");
		String id = ex.controlString();
		
		connection.removeDocument(id, collection);
	}
	
	public static void showPipelines() {
		int key = 0;
		do {
			System.out.println("MENU DE PIPELINES PROPUESTAS EN EL EJERCICIO");
			System.out.println("--------------------------------------------");
			System.out.println("1. Nombre de los modulos del ciclo ASIR");
			System.out.println("2. Nombre de los modulos que se imparten en el segundo curso de cualquier ciclo.");
			System.out.println("3. Nombre de los modulos de menos de 5 horas semanales.");
			System.out.println("4. Nombre de los modulos que se imparten en el primer curso de ASIR y de DAW.");
			System.out.println("5. Media de horas de los modulos de todos los cursos.");
			System.out.println("6. Id, nombre de los modulos y numero de horas de los modulos que tienen más de 3 horas semanales.");
			System.out.println("0. Volver.");
			
			key = ex.controlInt();
			
			
			switch (key) {
				case 1:
					System.out.println("Nombre de los modulos del ciclo ASIR:");
					MongoCursor<Document> cursor1 = connection.searchNombresByCiclo("ASIR", collection);
					while (cursor1.hasNext()) {
						Document document = cursor1.next();
						System.out.println(" " + document.getString("nombre"));
					}
					break;
				case 2:
					System.out.println("Nombre de los modulos que se imparten en el segundo curso de cualquier ciclo:");
					MongoCursor<Document> cursor2 = connection.searchNombresByCurso("2", collection);
					while (cursor2.hasNext()) {
						Document document = cursor2.next();
						System.out.println(" " + document.getString("nombre"));
					}
					break;
				case 3:
					System.out.println("Nombre de los modulos de menos de 5 horas semanales:");
					MongoCursor<Document> cursor3 = connection.searchNombresByMaxHoras(5, collection);
					while (cursor3.hasNext()) {
						Document document = cursor3.next();
						System.out.println(" " + document.getString("nombre"));
					}
					break;
				case 4:
					System.out.println("Nombre de los modulos que se imparten en el primer curso de ASIR y de DAW:");
					List<String> ciclos = new ArrayList<String>();
					ciclos.add("ASIR");
					ciclos.add("DAW");
					MongoCursor<Document> cursor4 = connection.searchNombresByCursoAndCiclos("1", ciclos, collection);
					while (cursor4.hasNext()) {
						Document document = cursor4.next();
						System.out.println(" " + document.getString("nombre"));
					}
					break;
				case 5:
					System.out.println("Media de horas de los modulos de todos los cursos:");
					MongoCursor<Document> cursor5 = connection.getAverageOfHoras(collection);
					if (cursor5.hasNext()) {
						Document document = cursor5.next();
						System.out.println(" " + document.getDouble("mediaHoras"));
					}
					break;
				case 6:
					System.out.println("Id, nombre de los modulos y numero de horas de los modulos que tienen más de 3 horas semanales:");
					MongoCursor<Document> cursor6 = connection.searchModulosDataByMinHoras(3, collection);
					if (cursor6.hasNext()) {
						Document document = cursor6.next();
						System.out.println(" ID: " + document.get("id") +
								", Nombre: " + document.get("nombres") +
								", Numero de Horas: " + document.get("horas"));
					}
					break;
				case 0:
					break;
				default:
					break;
			}
		} while (key != 0);

	}
}
