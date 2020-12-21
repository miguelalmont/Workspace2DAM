package com.everis.hibernate.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

/**
 * 
 * @author malcanmo
 *
 */
@Component
public class EverisContractDaoImpl implements EverisContractDaoI {

	@PersistenceContext
	private EntityManager entityManager;

	/** Retorna la sesión iniciada por entityManager */
	public Session getSession() {

		Session session = entityManager.unwrap(Session.class);
		return session;
	}

	@Override
	@Transactional
	public Boolean insertContract(EverisContract newContract) {
		// Resultado
		Boolean result = Boolean.FALSE;

		// Verificación de nulidad.
		if (newContract != null) {

			// Inserción del contrato en la tabla.
			getSession().save(newContract);
			result = Boolean.TRUE;
		}

		return result;
	}

	@Override
	@Transactional
	public List<EverisContract> selectAllContracts() {

		// Lista de contratos
		List<EverisContract> contractList = new ArrayList<>();

		// Recuperación de todos los contratos de la base de datos.
		contractList = getSession().createQuery("SELECT tcon FROM t_contract tcon", EverisContract.class)
				.getResultList();

		return contractList;
	}

	@Override
	@Transactional
	public EverisContract selectContractByID(Integer contractID) {

		// Contrato buscado
		EverisContract searchedContract = null;

		// Recuperación del contrato buscado en la base de datos por ID contrato.
		searchedContract = getSession()
				.createQuery("SELECT tcon FROM t_contract tcon WHERE contract_id = " + contractID, EverisContract.class)
				.getSingleResult();

		return searchedContract;
	}

	@Override
	@Transactional
	public EverisContract selectContractByClientID(Integer clientID) {

		// Contrato buscado
		EverisContract searchedContract = null;

		// Recuperación del contrato buscado en la base de datos por ID cliente.
		searchedContract = getSession()
				.createQuery("SELECT tcon FROM t_contract tcon WHERE client_id = " + clientID, EverisContract.class)
				.getSingleResult();

		return searchedContract;
	}

	@Override
	@Transactional
	public Boolean deleteContract(EverisContract contract) {

		// Resultado
		Boolean result = Boolean.FALSE;

		// Verificación de nulidad
		if (contract != null) {

			// Eliminación del contrato de la base de datos.
			getSession().remove(contract);
			result = Boolean.TRUE;
		}

		return result;
	}

	@Override
	@Transactional
	public Boolean updateContract(EverisContract mofiedContract) {

		// Resultado
		Boolean result = Boolean.FALSE;

		// Verificaicón de nulidad.
		if (mofiedContract != null) {

			// Actualización del contrato de la base de datos
			getSession().update(mofiedContract);
			result = Boolean.TRUE;
		}

		return result;
	}

}
