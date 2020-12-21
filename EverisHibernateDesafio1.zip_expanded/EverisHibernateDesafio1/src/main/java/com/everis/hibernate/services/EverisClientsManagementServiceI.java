package com.everis.hibernate.services;

import org.springframework.stereotype.Service;

import com.everis.hibernate.repositories.EverisClient;

/**
 * 
 * @author malcanmo
 *
 */
@Service
public interface EverisClientsManagementServiceI {

	/**
	 * Añade un nuevo cliente a la base de datos.
	 * 
	 * @param newClient
	 */
	public void addClient(final EverisClient newClient);

	/**
	 * Imprime por pantalla datos de todos los clientes de la base de datos.
	 */
	public void getAllClients();

	/**
	 * Imprime por pantalla datos de un cliente localizado por ID.
	 */
	public void getClientByID(final Integer clientID);

	/**
	 * Elimina un cliente de la base de datos.
	 * 
	 * @param client
	 */
	public void removeClient(final EverisClient client);

	/**
	 * Modifica un cliente de la base de datos.
	 * 
	 * @param modifiedClient
	 */
	public void modifyClient(final EverisClient modifiedClient);

}
