package com.everis.springMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.everis.springMVC.repositories.EverisClient;
import com.everis.springMVC.services.EverisClientsManagementServiceImpl;

/**
 * 
 * @author malcanmo
 *
 */
@SpringBootApplication
public class EverisClientsDataApplication implements CommandLineRunner {

	@Autowired
	EverisClientsManagementServiceImpl clientManagement;

	public static void main(String[] args) {
		SpringApplication.run(EverisClientsDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Creación de clientes
		EverisClient c1 = createClient(null, "Pepe", "Rodríguez", "Facundo", "28232323B");
		EverisClient c2 = createClient(null, "María", "Núñez", "Zanahoria", "30123123C");
		EverisClient c3 = createClient(null, "Sandra", "Pérez", "Guijuelo", "29292929P");
		EverisClient c4 = createClient(null, "María", "Montero", "Pérez", "30303030Z");
		EverisClient c5 = createClient(null, "Miguel", "Alcántara", "Montero", "23123456M");
		
		// Inserción de clientes en la tabla
		clientManagement.addClient(c1);
		clientManagement.addClient(c2);
		clientManagement.addClient(c3);
		clientManagement.addClient(c4);
		clientManagement.addClient(c5);
	}

	/**
	 * Crea y retorna un nuevo cliente por parámetros.
	 * 
	 * @param iD
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @param nif
	 * @return EverisClient
	 */
	private EverisClient createClient(final Integer iD, final String name, final String surname1, final String surname2,
			final String nif) {
		EverisClient client = new EverisClient();

		client.setClientID(iD);
		client.setClientName(name);
		client.setClientFirstLastName(surname1);
		client.setClientSecondLastName(surname2);
		client.setNif(nif);

		return client;
	}

}
