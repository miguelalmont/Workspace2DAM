package com.everis.springMVC.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.springMVC.repositories.EverisClient;

/**
 * Interfaz del servicio de gestión de clientes.
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
	 * Devuelve datos de todos los clientes de la base de datos.
	 * 
	 * @return List<EverisClient>
	 */
	public List<EverisClient> getAllClients();

	/**
	 * Devuelve datos de un cliente localizado por ID.
	 * 
	 * @return EverisClient
	 */
	public EverisClient getClientByID(final Integer clientID);

	/**
	 * Elimina un cliente de la base de datos.
	 * 
	 * @param client
	 */
	public void removeClient(final EverisClient client);
	
	/**
	 * Elimina un cliente localizado por ID.
	 * 
	 * @param clientID
	 */
	public void removeClientByID(final Integer clientID);

	/**
	 * Modifica un cliente de la base de datos.
	 * 
	 * @param newClient
	 */
	public void modifyClient(EverisClient client);
	
	/**
	 * Devuelve datos de todos los clientes filtrados por nombre.
	 * 
	 * @param client
	 * @return
	 */
	public List<EverisClient> getClientByName(EverisClient client);

}
