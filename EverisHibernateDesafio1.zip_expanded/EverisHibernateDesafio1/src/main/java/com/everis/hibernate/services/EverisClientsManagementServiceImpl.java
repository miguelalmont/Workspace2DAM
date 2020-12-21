package com.everis.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.everis.hibernate.repositories.EverisClient;
import com.everis.hibernate.repositories.EverisClientDaoImpl;

/**
 * 
 * @author malcanmo
 *
 */
@Service
public class EverisClientsManagementServiceImpl implements EverisClientsManagementServiceI {

	@Autowired
	EverisClientDaoImpl clientDAO;

	@Override
	public void addClient(final EverisClient newClient) {

		// Inserción del cliente.
		if (clientDAO.insertClient(newClient)) {
			System.out.println("El cliente ha sido insertado correctamente.");
		} else {
			System.out.println("No se ha insertado al cliente correctamente.");
		}

	}

	@Override
	public void getAllClients() {

		// Lista de clientes.
		List<EverisClient> clientsList = new ArrayList<>();

		// Recuperación de todos los clientes de la base de datos.
		clientsList = clientDAO.selectAllClients();

		// Verificación de lista vacía.
		if (!CollectionUtils.isEmpty(clientsList)) {

			// Iteración por la lista.
			for (EverisClient client : clientsList) {

				System.out.println("ID: " + client.getClientID() + " | Nombre: " + client.getClientName() + " "
						+ client.getClientFirstLastName() + " " + client.getClientSecondLastName() + " | DNI: "
						+ client.getNif());
			}

		} else {
			System.out.println("La lista de clientes está vacía.");
		}

	}

	@Override
	public void getClientByID(final Integer clientID) {

		// Cliente buscado.
		EverisClient client = null;

		// Recuperación del cliente de la base de datos.
		client = clientDAO.selectClientByclientID(clientID);

		// Verificación de nulidad.
		if (client != null) {

			System.out.println("ID: " + client.getClientID() + " | Nombre: " + client.getClientName() + " "
					+ client.getClientFirstLastName() + " " + client.getClientSecondLastName() + " | DNI: "
					+ client.getNif());
		} else {
			System.out.println("No se ha encontrado el cliente.");
		}

	}

	@Override
	public void removeClient(final EverisClient client) {

		// Borrado del cliente.
		if (clientDAO.deleteClient(client)) {
			System.out.println("El cliente se ha borrado correctamente.");
		} else {
			System.out.println("No se ha borrado el cliente correctamente.");
		}

	}

	@Override
	public void modifyClient(final EverisClient modifiedclient) {

		// Modificación del cliente.
		if (clientDAO.updateClient(modifiedclient)) {
			System.out.println("El cliente se ha modificado correctamente.");
		} else {
			System.out.println("No se ha modificado el cliente correctamente.");
		}

	}

}
