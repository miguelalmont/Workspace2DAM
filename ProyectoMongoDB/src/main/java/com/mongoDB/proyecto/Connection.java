package com.mongoDB.proyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Connection {

	private MongoClient mongoClient;

	public MongoDatabase connect(String host, int port, String database) {

		// Instancia la direccion del servidor.
		ServerAddress serverAddress = new ServerAddress(host, port);

		// Conecta con la base de datos.
		mongoClient = new MongoClient(serverAddress);

		// Selecciona la base de datos.
		MongoDatabase db = mongoClient.getDatabase(database);

		return db;

	}

	public void disconnect() {

		// Cierra la conexion.
		mongoClient.close();
	}

	public void insertFPModule(String id, String nombre, String curso, double horasSemanales, String ciclo,
			MongoCollection<Document> collection) {

		// Crea el documento a insertar.
		Document document = new Document("id", id).append("nombre", nombre).append("curso", curso)
				.append("horasSemanales", horasSemanales).append("ciclo", ciclo);

		// Inserta el documento en la coleccion.
		collection.insertOne(document);
	}

	public MongoCursor<Document> findDocument(String key, String value, MongoCollection<Document> collection) {

		// Crea el documento que especifica la clave y el valor a buscar.
		Document findDocument = new Document(key, value);

		// Crea el documento que guarda el resultado de la busqueda.
		MongoCursor<Document> resultDocument = collection.find(findDocument).iterator();

		return resultDocument;

	}

	public MongoCursor<Document> findAll(MongoCollection<Document> collection) {

		// Crea el documento que guarda el resultado de la busqueda.
		MongoCursor<Document> resultDocument = collection.find().iterator();

		return resultDocument;

	}
	
	public void removeDocument(String id, MongoCollection<Document> collection) {

		// Crea el documento que especifica el criterio de busqueda.
		Document findDocument = new Document("id", id);

		// Busca un documento y lo borra.
		collection.findOneAndDelete(findDocument);
	}

	public void updateFPModule(String id, String newNombre, String newCurso, double newHorasSemanales,
			String newCiclo, MongoCollection<Document> collection) {

		// Crea el documento que especifica el criterio de busqueda.
		Document findDocument = new Document("id", id);

		// Crea el documento que especifica los datos actualizados.
		Document updateDocument = new Document("$set", new Document("nombre", newNombre).append("curso", newCurso)
				.append("horasSemanales", newHorasSemanales).append("ciclo", newCiclo));

		// Busca un documento y lo actualiza.
		collection.findOneAndUpdate(findDocument, updateDocument);
	}

	public MongoCursor<Document> searchNombresByCiclo(String ciclo, MongoCollection<Document> collection) {

		// Crea el documento que contiene el pipeline "$match".
		Document match = new Document("$match", new Document("ciclo", ciclo));

		// Crea el documento que contiene el pipeline "$project".
		Document project = new Document("$project", new Document("nombre", 1));

		// Crea el pipeline.
		List<Document> pipeline = Arrays.asList(match, project);
		
		// Agrega el pipeline a la colección, lo ejecuta y almacena el resultado.
		MongoCursor<Document> output = collection.aggregate(pipeline).iterator();

		return output;
	}

	public MongoCursor<Document> searchNombresByCurso(String curso, MongoCollection<Document> collection) {

		// Crea el documento que contiene el pipeline "$match".
		Document match = new Document("$match", new Document("curso", curso));

		// Crea el documento que contiene el pipeline "$project".
		Document project = new Document("$project", new Document("nombre", 1));

		// Crea el pipeline.
		List<Document> pipeline = Arrays.asList(match, project);
		
		// Agrega el pipeline a la colección, lo ejecuta y almacena el resultado.
		MongoCursor<Document> output = collection.aggregate(pipeline).iterator();

		return output;
	}

	public MongoCursor<Document> searchNombresByMaxHoras(double maximoHoras,
			MongoCollection<Document> collection) {

		// Crea el documento que contiene el pipeline "$project".
		Document project = new Document("$project", new Document("nombre", 1));

		// Crea el documento que contiene los pipeline "$match" y "$lt".
		Document match = new Document("$match", new Document("horasSemanales", new Document("$lt", maximoHoras)));

		// Crea el pipeline.
		List<Document> pipeline = Arrays.asList(match, project);
		
		// Agrega el pipeline a la colección, lo ejecuta y almacena el resultado.
		MongoCursor<Document> output = collection.aggregate(pipeline).iterator();

		return output;
	}

	public MongoCursor<Document> searchNombresByCursoAndCiclos(String curso, List<String> ciclos,
			MongoCollection<Document> collection) {

		// Crea el documento que contiene el pipeline "$project".
		Document project = new Document("$project", new Document("nombre", 1));

		// Crea el documento que contiene el primer pipeline "$match".
		Document match1 = new Document("$match", new Document("curso", curso));

		// Crea una lista de documentos por cada ciclo a buscar.
		List<Document> matchs = new ArrayList<Document>(ciclos.size());
		for (String ciclo : ciclos) {
			Document matchCiclo = new Document("ciclo", ciclo);
			matchs.add(matchCiclo);
		}

		// Crea el documento que contiene el segundo pipeline "$match".
		Document match2 = new Document("$match", new Document("$or", matchs));

		// Crea el pipeline.
		List<Document> pipeline = Arrays.asList(match1, match2, project);

		// Agrega el pipeline a la colección, lo ejecuta y almacena el resultado.
		MongoCursor<Document> output = collection.aggregate(pipeline).iterator();

		return output;
	}

	public MongoCursor<Document> getAverageOfHoras(MongoCollection<Document> collection) {

		// Crea el documento con el pipeline "$avg".
		Document avg = new Document("$avg", new Document("$sum", "$horasSemanales"));

		// Crea el documento con los campos que contendrá el "$group".
		Document groupFields = new Document("_id", "$curso").append("mediaHoras", avg);

		// Crea el documento con el pipeline "$group".
		Document group = new Document("$group", groupFields);

		// Crea el pipeline.
		List<Document> pipeline = Arrays.asList(group);

		// Agrega el pipeline a la colección, lo ejecuta y almacena el resultado.
		MongoCursor<Document> output = collection.aggregate(pipeline).iterator();

		return output;
	}

	public MongoCursor<Document> searchModulosDataByMinHoras(double minHoras, MongoCollection<Document> collection) {

		// Crea el documento con los pipeline "$match" y "$gt".
		Document match = new Document("$match", new Document("horasSemanales", new Document("$gt", minHoras)));

		// Crea el documento con los campos que contendra el "$group".
		Document groupFields = new Document("_id", "").append("numModulos", new Document("$sum", 1))
				.append("id", new Document("$push", "$id"))
				.append("nombres", new Document("$push", "$nombre"))
				.append("horas", new Document("$push", "$horasSemanales"));

		// Crea el documento con el pipeline "$group".
		Document group = new Document("$group", groupFields);

		// Crea el pipeline.
		List<Document> pipeline = Arrays.asList(match, group);

		// Agrega el pipeline a la colección, lo ejecuta y almacena el resultado.
		MongoCursor<Document> output = collection.aggregate(pipeline).iterator();

		return output;

	}
	
	public void fillBD(MongoCollection<Document> collection) {

		// Crea los documentos con el contenido de la base de datos
		Document document1 = new Document().append("id", "0228").append("nombre", "Aplicaciones web").append("curso", "2").append("horasSemanales", 4.0).append("ciclo", "SMR");
		Document document2 = new Document().append("id", "0372").append("nombre", "Gestión de Bases de Datos").append("curso", "1").append("horasSemanales", 5.0).append("ciclo", "ASIR");
		List<String> cursos = new ArrayList<String>();
		cursos.add("ASIR");
		cursos.add("DAW");
		Document document3 = new Document().append("id", "0373").append("nombre", "Lenguajes de marcas y sistemas de gestión de información").append("curso", "1").append("horasSemanales", 3.0).append("ciclo", cursos);
		Document document4 = new Document().append("id", "0376").append("nombre", "Implantación de aplicaciones web").append("curso", "2").append("horasSemanales", 5.0).append("ciclo", "ASIR");
		
		// Inserta los documento en una lista
		List<Document> documentos = new ArrayList<Document>();
		documentos.add(document1);
		documentos.add(document2);
		documentos.add(document3);
		documentos.add(document4);
		
		collection.insertMany(documentos);
		
	}

}
