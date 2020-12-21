package com.everis.spring.services;

import com.everis.spring.repository.EverisOrder;
import com.everis.spring.repository.EverisProduct;

/**
 * Servicio de gestión de pedidos de la tienda Everis.
 * 
 * @author malcamo
 *
 */
public interface EverisOrdersManagementServiceI {

	/**
	 * Instancia un nuevo pedido.
	 */
	public EverisOrder createOrder(String orderId, String orderDestinationName, String orderAddress);

	/**
	 * Añade un producto al pedido.
	 */
	public void addProduct(final Integer productId, final String productName, final double productPrice);

	/**
	 * Modifica un producto del pedido localizado por ID.
	 */
	public void modifyProductByID(final Integer productId, final String newProductName, final double newProductPrice);

	/**
	 * Elimina un producto del pedido localizado por ID.
	 */
	public void removeProductByID(final Integer productId);

	/**
	 * Muestra un producto del pedido localizado por ID.
	 */
	public void showProductByID(final Integer productId);

	/**
	 * Muestra todos los productos del pedido.
	 */
	public void showAllProducts();

	/**
	 * Muestra el precio total del pedido.
	 */
	public void showTotalOrderPrice();

	/**
	 * Calcula el PVP de un producto del pedido localizado por ID.
	 * 
	 * @param order
	 * @param productId
	 * @return EverisProduct
	 */
	public EverisProduct calculatePvpProductByID(final Integer productId);

	/**
	 * Desglosa la información del pedido.
	 */
	public void breakDownOrder();

}
