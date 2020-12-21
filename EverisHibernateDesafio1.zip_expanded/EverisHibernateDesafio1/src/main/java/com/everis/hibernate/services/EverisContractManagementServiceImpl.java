package com.everis.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.everis.hibernate.repositories.EverisContract;
import com.everis.hibernate.repositories.EverisContractDaoImpl;

/**
 * 
 * @author malcanmo
 *
 */
@Service
public class EverisContractManagementServiceImpl implements EverisContractManagementServiceI {

	@Autowired
	EverisContractDaoImpl contractDAO;

	@Override
	public void addContract(EverisContract newContract) {

		// Inserción del contrato.
		if (contractDAO.insertContract(newContract)) {
			System.out.println("El contrato ha sido insertado correctamente.");
		} else {
			System.out.println("No se ha insertado el contrato correctamente.");
		}

	}

	@Override
	public void getAllContracts() {

		// Lista de contratos.
		List<EverisContract> contractsList = new ArrayList<>();

		// Recuperación de todos los contratos de la base de datos.
		contractsList = contractDAO.selectAllContracts();

		// Verificación de lista vacía.
		if (!CollectionUtils.isEmpty(contractsList)) {

			// Iteración por la lista.
			for (EverisContract contract : contractsList) {

				System.out.println("ID: " + contract.getContractID() + " | Fecha de vigencia: "
						+ contract.getContractEffectiveDate().toString() + " | Fecha de expiración: "
						+ contract.getContractExpirationDate().toString() + " | Precio mensual: "
						+ contract.getContractMonthlyPrice() + " | ID Cliente: "
						+ contract.getContractClient().getClientID());
			}

		} else {
			System.out.println("La lista de contratos está vacía.");
		}

	}

	@Override
	public void getContractByContractID(Integer contractID) {

		// Contrato buscado.
		EverisContract contract = null;

		// Recuperación del contrato de la base de datos.
		contract = contractDAO.selectContractByID(contractID);

		// Verificación de nulidad.
		if (contract != null) {

			System.out.println("ID: " + contract.getContractID() + " | Fecha de vigencia: "
					+ contract.getContractEffectiveDate() + " | Fecha de expiración: "
					+ contract.getContractExpirationDate() + " | Precio mensual: " + contract.getContractMonthlyPrice()
					+ " | ID Cliente: " + contract.getContractClient().getClientID());

		} else {
			System.out.println("No se ha encontrado el contrato.");
		}

	}

	@Override
	public void getContractByClientID(Integer clientID) {

		// Contrato buscado.
		EverisContract contract = null;

		// Recuperación del contrato de la base de datos.
		contract = contractDAO.selectContractByClientID(clientID);

		// Verificación de nulidad.
		if (contract != null) {

			System.out.println("ID: " + contract.getContractID() + " | Fecha de vigencia: "
					+ contract.getContractEffectiveDate() + " | Fecha de expiración: "
					+ contract.getContractExpirationDate() + " | Precio mensual: " + contract.getContractMonthlyPrice()
					+ " | ID Cliente: " + contract.getContractClient().getClientID());

		} else {
			System.out.println("No se ha encontrado el contrato.");
		}

	}

	@Override
	public void removeContract(EverisContract contract) {

		// Borrado del cliente.
		if (contractDAO.deleteContract(contract)) {
			System.out.println("El contrato se ha borrado correctamente.");
		} else {
			System.out.println("No se ha borrado el contrato correctamente.");
		}

	}

	@Override
	public void modifyContract(EverisContract modifiedContract) {

		// Modificación del cliente.
		if (contractDAO.updateContract(modifiedContract)) {
			System.out.println("El contrato se ha modificado correctamente.");
		} else {
			System.out.println("No se ha modificado el contrato correctamente.");
		}

	}

}
