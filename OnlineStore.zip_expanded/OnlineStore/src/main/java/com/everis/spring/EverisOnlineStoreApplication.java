package com.everis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.everis.spring.services.EverisOrdersManagementServiceI;

/**
 * 
 * @author malcanmo
 *
 */
@SpringBootApplication
public class EverisOnlineStoreApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("inPeninsula")
	EverisOrdersManagementServiceI orderManagementServiceInPeninsula;

	@Autowired
	@Qualifier("outPeninsula")
	EverisOrdersManagementServiceI orderManagementServiceOutPeninsula;

	public static void main(String[] args) {
		SpringApplication.run(EverisOnlineStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creación de un pedido para dentro de la península.
		orderManagementServiceInPeninsula.createOrder("P001", "Homer Simpson", "Calle Invent 123, Sevilla");

		// Inserción de productos.
		orderManagementServiceInPeninsula.addProduct(1, "Monitor PC MSI", 170.30);

		// Creación de un pedido para fuera de la península.
		orderManagementServiceOutPeninsula.createOrder("P002", "Ignatius Farray", "Calle Muyayo 7, Tenerife");

		// Inserción de productos en el pedido fuera de la península.
		orderManagementServiceOutPeninsula.addProduct(1, "Monitor PC MSI", 170.30);
		orderManagementServiceOutPeninsula.addProduct(2, "Teclado Xiaomi", 16.60);
		orderManagementServiceOutPeninsula.addProduct(3, "Mouse Logitech", 12.25);
		orderManagementServiceOutPeninsula.addProduct(4, "Auriculares Corsair", 56);

		// Desglose de ambos pedidos.
		orderManagementServiceInPeninsula.breakDownOrder();
		System.out.println("");
		orderManagementServiceOutPeninsula.breakDownOrder();
		System.out.println("");

		// Eliminación de un producto y nuevo desglose.
		orderManagementServiceInPeninsula.removeProductByID(1);
		System.out.println("");
		orderManagementServiceInPeninsula.breakDownOrder();

	}

}
