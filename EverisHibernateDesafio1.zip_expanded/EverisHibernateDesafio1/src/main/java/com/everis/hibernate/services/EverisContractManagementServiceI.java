package com.everis.hibernate.services;

import org.springframework.stereotype.Service;

import com.everis.hibernate.repositories.EverisContract;

/**
 * 
 * @author malcanmo
 *
 */
@Service
public interface EverisContractManagementServiceI {

	/**
	 * Añade un nuevo contrato a la base de datos.
	 * 
	 * @param newContract
	 */
	public void addContract(final EverisContract newContract);

	/**
	 * Imprime por pantalla datos de todos los contratos de la base de datos.
	 */
	public void getAllContracts();

	/**
	 * Imprime por pantalla datos de un contrato localizado por ID de contrato.
	 */
	public void getContractByContractID(final Integer contractID);

	/**
	 * Imprime por pantalla datos de un contrato localizado por ID de cliente.
	 */
	public void getContractByClientID(final Integer clientID);

	/**
	 * Elimina un contrato de la base de datos por ID.
	 * 
	 * @param contract
	 */
	public void removeContract(final EverisContract contract);

	/**
	 * Modifica un cliente de la base de datos por ID.
	 * 
	 * @param newClient
	 */
	public void modifyContract(final EverisContract modifiedContract);
}
