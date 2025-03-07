package com.everis.springMVC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springMVC.repositories.EverisClient;
import com.everis.springMVC.services.EverisClientsManagementServiceI;

/**
 * 
 * 
 * @author migue
 *
 */
@RestController
@RequestMapping("/api")
public class EverisClientsAPIRestController {
	
	@Autowired
	EverisClientsManagementServiceI clientService;
	
	/**
	 * Devueve un JSON con todos los clientes
	 * 
	 * @return List<EverisClient>
	 */
	@GetMapping("all")
	public List<EverisClient> getAllClients() {
		
		List<EverisClient> list = clientService.getAllClients();
		
		return list;
	}
	
	/**
	 * Devuelve un JSON con un cliente filtrado por ID.
	 * 
	 * @param clientID
	 * @return EverisClient
	 */
	@GetMapping("search/{clientID}")
	public EverisClient getClientByID(@PathVariable int clientID) {
		
		EverisClient client = clientService.getClientByID(clientID);
		
		return client;
	}
	
	/**
	 * Inserta un nuevo empleado con método POST.
	 * 
	 * @param newClient
	 */
	@PostMapping("insert")
	public void newEmployee(@RequestBody EverisClient newClient) {
	    clientService.addClient(newClient);
	  }
	
	/**
	 * Elimina un empleado por ID con método DELETE.
	 * 
	 * @param clientID
	 */
	@DeleteMapping("delete/{clientID}")
	public void deleteEmployee(@PathVariable int clientID) {
		clientService.removeClientByID(clientID);
	}

}
