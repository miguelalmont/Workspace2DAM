package com.everis.springMVC.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz del respositorio de clientes
 * 
 * @author malcanmo
 *
 */
public interface EverisClientsRepositoryI extends JpaRepository<EverisClient, Integer> {
	
	/**
	 * Retorna un cliente de la base de datos localizado por ID.
	 * 
	 * @param clientID
	 * @return EverisClient
	 */
	public EverisClient findEverisClientByClientID(final Integer clientId);
	
	/**
	 * Retorna lista de clientes filtrada por nombre y dos apellidos.
	 * 
	 * @param clientName
	 * @param clientFirstLastName
	 * @param clientSecondLastName
	 * @return List<EverisClient>
	 */
	public List<EverisClient> findEverisClientByClientNameAndClientFirstLastNameAndClientSecondLastName(final String clientName, final String clientFirstLastName, final String clientSecondLastName);
	
	/**
	 * Retorna lista de clientes filtrada por nombre.
	 * 
	 * @param clientName
	 * @return
	 */
	public List<EverisClient> findEverisClientByClientName(final String clientName);

}
