package com.everis.springMVC.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.springMVC.repositories.EverisClient;
import com.everis.springMVC.repositories.EverisClientsRepositoryI;

/**
 * Implementación del servicio de gestión de clientes.
 * 
 * @author malcanmo
 *
 */
@Service
public class EverisClientsManagementServiceImpl implements EverisClientsManagementServiceI {

	@Autowired
	EverisClientsRepositoryI clientRepositoryI;

	@Override
	public void addClient(EverisClient newClient) {
		// Inserción del cliente.
		clientRepositoryI.save(newClient);
	}

	@Override
	public List<EverisClient> getAllClients() {

		// Lista de clientes.
		List<EverisClient> clientsList = new ArrayList<>();

		// Recuperación de todos los clientes de la base de datos.
		clientsList = clientRepositoryI.findAll();
		
		return clientsList;

	}

	@Override
	public EverisClient getClientByID(Integer clientID) {

		// Cliente buscado.
		EverisClient client = null;

		// Recuperación del cliente de la base de datos.
		client = clientRepositoryI.findEverisClientByClientID(clientID);

		return client;

	}

	@Override
	public void removeClient(EverisClient client) {

		// Borrado del cliente.		
		clientRepositoryI.delete(client);

	}

	@Override
	public void modifyClient(EverisClient client) {

		// Modificación del cliente.
		EverisClient clientToUpdate = clientRepositoryI.findEverisClientByClientID(client.getClientID());
		if (clientToUpdate != null) {	
			clientToUpdate.setClientName(client.getClientName());
			clientToUpdate.setClientFirstLastName(client.getClientFirstLastName());
			clientToUpdate.setClientSecondLastName(client.getClientSecondLastName());
			clientToUpdate.setNif(client.getNif());
			clientRepositoryI.save(clientToUpdate);
		}
		
	}
	
	@Override
	public List<EverisClient> getClientByName(EverisClient searchedClient) {

		// Cliente buscado.
		List<EverisClient> client = null;

		// Recuperación del cliente de la base de datos.
		client = clientRepositoryI.findEverisClientByClientName(searchedClient.getClientName());

		return client;
	}

	@Override
	public void removeClientByID(Integer clientID) {
		clientRepositoryI.deleteById(clientID);
	}

}
