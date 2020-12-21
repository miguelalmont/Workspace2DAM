package com.everis.hibernate.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @author malcanmo
 *
 */
@Component
public interface EverisContractDaoI {

	/**
	 * Inserta un nuevo contrato en la base de datos.
	 * 
	 * @param newContract
	 * @return Boolean
	 */
	public Boolean insertContract(final EverisContract newContract);

	/**
	 * Retorna todos los contratos de la base de datos.
	 * 
	 * @return List<EverisContract>
	 */
	public List<EverisContract> selectAllContracts();

	/**
	 * Retorna un contrato de la base de datos localizado por la ID del cliente
	 * asociado.
	 * 
	 * @param contractID
	 * @return EverisContract
	 */
	public EverisContract selectContractByID(final Integer contractID);

	/**
	 * Retorna un contrato de la base de datos localizado por la ID del cliente
	 * asociado.
	 * 
	 * @param clientID
	 * @return EverisContract
	 */
	public EverisContract selectContractByClientID(final Integer clientID);

	/**
	 * Elimina un contrato.
	 * 
	 * @param contract
	 * @return Boolean
	 */
	public Boolean deleteContract(final EverisContract contract);

	/**
	 * Modifica un contrato.
	 * 
	 * @param mofiedContract
	 * @return Boolean
	 */
	public Boolean updateContract(final EverisContract mofiedContract);
}
