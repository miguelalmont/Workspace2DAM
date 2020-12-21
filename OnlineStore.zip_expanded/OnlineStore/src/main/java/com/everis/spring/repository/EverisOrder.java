package com.everis.spring.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Clase "entidad / repositorio" de pedidos de la tienda.
 * 
 * @author malcanmo
 *
 */
public class EverisOrder implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** Identificador del pedido. */
	private String orderId;

	/** Destinatario del pedido. */
	private String orderDestinationName;

	/** Dirección de envío. */
	private String orderAddress;

	/** Indicador de envío fuera de península (Melilla, Ceuta o Canarias). */
	private Boolean orderOutOfPeninsula;

	/** Lista de productos que contiene el pedido. */
	private List<EverisProduct> productsList = new ArrayList<>();

	/**
	 * Constructor parametrizado.
	 * 
	 * @param orderId
	 * @param orderDestinationName
	 * @param orderAddress
	 * @param orderOutOfPeninsula
	 * @param productsList
	 */
	public EverisOrder(String orderId, String orderDestinationName, String orderAddress, Boolean orderOutOfPeninsula) {
		this.orderId = orderId;
		this.orderDestinationName = orderDestinationName;
		this.orderAddress = orderAddress;
		this.orderOutOfPeninsula = orderOutOfPeninsula;
	}

	/**
	 * Añade un producto a la lista de productos. TRUE = OK | FALSE = KO
	 * 
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @return Boolean
	 */
	public Boolean insertProduct(final Integer productId, final String productName, final double productPrice) {

		// Resultado.
		Boolean result = Boolean.TRUE;

		// Verificación de nulidad.
		if (StringUtils.hasText(productName) && productId > 0 && productPrice > 0) {

			// Adición del producto a la lista.
			productsList.add(new EverisProduct(productId, productName, productPrice));

		} else {

			result = Boolean.FALSE;
		}

		return result;
	}

	/**
	 * Actualiza un producto de la lista localizado por ID. TRUE = OK | FALSE = KO
	 * 
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @return Boolean
	 */
	public Boolean updateProductByID(final Integer productId, final String newProductName,
			final double newProductPrice) {

		// Resultado.
		Boolean result = Boolean.TRUE;

		// Verificación de nulidad.
		if (StringUtils.hasText(newProductName) && productId > 0 && newProductPrice > 0) {

			// Comprobación de existencia del producto
			for (EverisProduct everisProduct : productsList) {

				// Si existe producto se actualiza nombre y precio.
				if (everisProduct.getProductId() == productId) {

					everisProduct.setProductName(newProductName);
					everisProduct.setProductPrice(newProductPrice);
				}
			}

		} else {

			result = Boolean.FALSE;
		}

		return result;
	}

	/**
	 * Elimina un producto de la lista localizado por ID. TRUE = OK | FALSE = KO
	 * 
	 * @param productId
	 * @return boolean
	 */
	public Boolean deleteProductByID(final Integer productId) {

		// Resultado.
		Boolean result = Boolean.TRUE;

		// Verificación de contenido en la lista.
		if (!CollectionUtils.isEmpty(productsList)) {
			
			// Variable para guardar el producto si existe.
			EverisProduct productToRemove = null;
			
			// Comprobación de existencia del producto
			for (EverisProduct everisProduct : productsList) {

				if (everisProduct.getProductId() == productId) {
					productToRemove = everisProduct;
				}
			}
			
			if (productToRemove != null) {
				productsList.remove(productToRemove);
			}

		} else {

			result = Boolean.FALSE;
		}

		return result;
	}

	/**
	 * Retorna un producto de la lista localizado por ID.
	 * 
	 * @param productId
	 * @return EverisProduct
	 */
	public EverisProduct searchProducByID(final Integer productId) {

		// Resultado de la búsqueda.
		EverisProduct searchedProduct = null;

		// Iteración para localizar el producto.
		for (EverisProduct everisProduct : productsList) {

			if (everisProduct.getProductId() == productId) {

				searchedProduct = everisProduct;
			}
		}

		return searchedProduct;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderDestinationName
	 */
	public String getOrderDestinationName() {
		return orderDestinationName;
	}

	/**
	 * @param orderDestinationName the orderDestinationName to set
	 */
	public void setOrderDestinationName(String orderDestinationName) {
		this.orderDestinationName = orderDestinationName;
	}

	/**
	 * @return the orderAddress
	 */
	public String getOrderAddress() {
		return orderAddress;
	}

	/**
	 * @param orderAddress the orderAddress to set
	 */
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	/**
	 * @return the orderOutOfPeninsula
	 */
	public Boolean getOrderOutOfPeninsula() {
		return orderOutOfPeninsula;
	}

	/**
	 * @param orderOutOfPeninsula the orderOutOfPeninsula to set
	 */
	public void setOrderOutOfPeninsula(Boolean orderOutOfPeninsula) {
		this.orderOutOfPeninsula = orderOutOfPeninsula;
	}

	/**
	 * @return the productsList
	 */
	public List<EverisProduct> getProductsList() {
		return productsList;
	}

	/**
	 * @param productsList the productsList to set
	 */
	public void setProductsList(List<EverisProduct> productsList) {
		this.productsList = productsList;
	}

}
