package com.everis.springMVC.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.springMVC.repositories.EverisClient;
import com.everis.springMVC.services.EverisClientsManagementServiceI;

/**
 * Controlador de vistas de la Aplicación de gestión de Clientes
 * 
 * @author malcanmo
 *
 */
@Controller
@RequestMapping("*")
public class EverisClientsController {
	
	@Autowired
	EverisClientsManagementServiceI clientService;
	
	/**
	 * Escucha cualquier ruta y muestra la vista del índice.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping
	public String showIndex(Model model) {
		return "index";
	}
	
	/**
	 * Escucha la ruta "clients-list" y muestra la vista de la lista de clientes.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/clients-list")
	public String showClientsList(Model model) {
		
		model.addAttribute("clientListView",clientService.getAllClients());
		
		return "clients-list";
	}
	
	/**
	 * Escucha la ruta "delete-client", borra el cliente y redirige a la vista de lista de clientes.
	 * 
	 * @param client
	 * @return String
	 */
	@DeleteMapping("/delete-client")
	public String onClickDelete(@ModelAttribute(value="deletedClient") EverisClient client) {
		
		clientService.removeClient(client);
		
		return "redirect:clients-list";
	}
	
	/**
	 * Escucha la ruta "insert-client-form" y muestra la vista del formulario de inserción.
	 * 
	 * @param client
	 * @return String
	 */
	@GetMapping("/insert-client-form")
	public String showInsertClient(@ModelAttribute(value="newClient") EverisClient client) {
		return "insert-client-form";
	}
	
	/**
	 * Escucha la ruta "insert-client", añade el cliente y redirige a la vista de lista de clientes.
	 * 
	 * @param client
	 * @param result
	 * @param model
	 * @return String
	 */
	@PostMapping("/insert-client")
	public String onSubmitInsert(@Valid @ModelAttribute(value="newClient") EverisClient client, BindingResult result, Model model) {
		
		// Valida nulidad y confirma que existan errores.
		if (null != result && result.hasErrors()) {
            return "insert-client-form";
            
		} else {
			
			try {
				clientService.addClient(client);
			}catch(Exception ex) {
				return "error";
			}
			
			return "redirect:clients-list";
		}
		
	}
	
	/**
	 * Escucha la ruta "search-client" y muestra la vista de búsqueda de cliente.
	 * 
	 * @param client
	 * @param model
	 * @return String
	 */
	@GetMapping("/search-client")
	public String showSearchClient(@ModelAttribute(value="searchedClient") EverisClient client, Model model) {
		
		model.addAttribute("searchListView",clientService.getClientByName(client));
		
		return "search-client";
	}
	
}
