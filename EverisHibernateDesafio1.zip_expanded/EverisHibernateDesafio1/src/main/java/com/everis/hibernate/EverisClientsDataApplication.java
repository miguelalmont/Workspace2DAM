package com.everis.hibernate;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.everis.hibernate.repositories.EverisClient;
import com.everis.hibernate.repositories.EverisContract;
import com.everis.hibernate.services.EverisClientsManagementServiceImpl;
import com.everis.hibernate.services.EverisContractManagementServiceImpl;

/**
 * 
 * @author malcanmo
 *
 */
@SpringBootApplication
public class EverisClientsDataApplication implements CommandLineRunner {

	@Autowired
	EverisClientsManagementServiceImpl clientManagement;

	@Autowired
	EverisContractManagementServiceImpl contractManagement;

	public static void main(String[] args) {
		SpringApplication.run(EverisClientsDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creación de objetos para insertar en las tablas.
		EverisClient cli1 = createClient(null, "Isabel", "Serrano", "Mateo", 28232323);
		EverisContract con1 = createContract(1, Date.valueOf("2010-3-10"), Date.valueOf("2015-6-5"), 24.50, cli1);

		// Inserción y recuperación del cliente.
		clientManagement.addClient(cli1);
		clientManagement.getClientByID(1);

		// Inserción y recuperación del contrato por ID del cliente.
		contractManagement.addContract(con1);
		contractManagement.getContractByClientID(1);

		// Modificaión y recuperación del contrato.
		con1 = createContract(null, Date.valueOf("2019-7-1"), Date.valueOf("2020-7-1"), 299.95, cli1);
		contractManagement.modifyContract(con1);
		contractManagement.getContractByContractID(1);

		// Eliminación del contrato.
//		contractManagement.removeContract(con1);

		System.exit(0);
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
			final Integer nif) {

		EverisClient client = new EverisClient();

		client.setClientID(iD);
		client.setClientName(name);
		client.setClientFirstLastName(surname1);
		client.setClientSecondLastName(surname2);
		client.setNif(nif);

		return client;
	}

	/**
	 * Crea y retorna un nuevo contrato por parámentros.
	 * 
	 * @param contractID
	 * @param effectiveDate
	 * @param expirationDate
	 * @param monthlyPrice
	 * @param contractClient
	 * @return EverisContract
	 */
	private EverisContract createContract(final Integer contractID, final Date effectiveDate, final Date expirationDate,
			final Double monthlyPrice, EverisClient contractClient) {

		EverisContract contract = new EverisContract();

		contract.setContractID(contractID);
		contract.setContractEffectiveDate(effectiveDate);
		contract.setContractExpirationDate(expirationDate);
		contract.setContractMonthlyPrice(monthlyPrice);
		contract.setContractClient(contractClient);

		return contract;
	}

}
