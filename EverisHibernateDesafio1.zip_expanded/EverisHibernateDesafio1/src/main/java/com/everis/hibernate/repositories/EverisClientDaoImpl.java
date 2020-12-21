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
public class EverisClientDaoImpl implements EverisClientDaoI {

	@PersistenceContext
	private EntityManager entityManager;

	/** Retorna la sesión iniciada por entityManager */
	public Session getSession() {

		Session session = entityManager.unwrap(Session.class);
		return session;
	}

	@Override
	@Transactional
	public Boolean insertClient(final EverisClient newClient) {

		// Resultado
		Boolean result = Boolean.FALSE;

		// Verificación de nulidad.
		if (newClient != null) {

			// Inserción del cliente en la tabla.
			getSession().save(newClient);
			result = Boolean.TRUE;
		}

		return result;
	}

	@Override
	@Transactional
	public List<EverisClient> selectAllClients() {

		// Lista de clientes
		List<EverisClient> clientsList = new ArrayList<>();

		// Recuperación de todos los clientes de la base de datos.
		clientsList = getSession().createQuery("SELECT tc FROM t_client tc", EverisClient.class).getResultList();

		return clientsList;
	}

	@Override
	@Transactional
	public EverisClient selectClientByclientID(final Integer clientID) {

		// Cliente buscado
		EverisClient searchedClient = null;

		// Recuperación del cliente buscado de la base de datos.
		searchedClient = getSession()
				.createQuery("SELECT tc FROM t_client tc WHERE client_id = " + clientID, EverisClient.class)
				.getSingleResult();

		return searchedClient;
	}

	@Override
	@Transactional
	public Boolean deleteClient(final EverisClient client) {

		// Resultado
		Boolean result = Boolean.FALSE;

		// Verificación de nulidad
		if (client != null) {

			// Eliminación del cliente de la base de datos.
			getSession().remove(client);
			result = Boolean.TRUE;
		}

		return result;
	}

	@Override
	@Transactional
	public Boolean updateClient(final EverisClient modifiedClient) {

		// Resultado
		Boolean result = Boolean.FALSE;

		// Verificaicón de nuliad
		if (modifiedClient != null) {

			// Actualización del cliente de la base de datos
			getSession().update(modifiedClient);
			result = Boolean.TRUE;
		}

		return result;
	}

}
