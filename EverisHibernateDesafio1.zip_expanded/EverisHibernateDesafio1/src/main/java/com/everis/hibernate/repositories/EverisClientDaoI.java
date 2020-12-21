package com.everis.hibernate.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @author malcanmo
 *
 */
@Component
public interface EverisClientDaoI {

	/**
	 * Inserta un nuevo cliente en la base de datos.
	 * 
	 * @param clientName
	 * @param clientLastName1
	 * @param clientLastName2
	 * @param clientNif
	 */
	public Boolean insertClient(final EverisClient newClient);

	/**
	 * Retorna todos los clientes de la base de datos.
	 * 
	 * @return List<EverisClient>
	 */
	public List<EverisClient> selectAllClients();

	/**
	 * Retorna un cliente de la base de datos localizado por ID.
	 * 
	 * @param clientID
	 * @return EverisClient
	 */
	public EverisClient selectClientByclientID(final Integer clientID);

	/**
	 * Elimina un cliente de la base de datos localizado por ID.
	 * 
	 * @param clientID
	 */
	public Boolean deleteClient(final EverisClient client);

	/**
	 * Actualiza un cliente de la base de datos localizado por ID.
	 * 
	 * @param clientID
	 * @param newClientName
	 * @param newClientLastName1
	 * @param newClientLastName2
	 * @param newClientNif
	 */
	public Boolean updateClient(final EverisClient modifiedClient);
}
