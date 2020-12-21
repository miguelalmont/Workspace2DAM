package com.everis.spring.services;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.everis.spring.repository.EverisOrder;
import com.everis.spring.repository.EverisProduct;

/**
 * Servicio de gestión de pedidos fuera de la península de la tienda Everis.
 * 
 * @author malcanmo
 *
 */
@Service("outPeninsula")
public class EverisOutPeninsulaOrderManagementServiceImpl implements EverisOrdersManagementServiceI {

	// Declaración del pedido para fuera de la península.
	private EverisOrder order;

	// Instaciación del formateador de decimales para los precios.
	private final DecimalFormat df = new DecimalFormat("0.00");

	@Override
	public EverisOrder createOrder(String orderId, String orderDestinationName, String orderAddress) {

		order = new EverisOrder(orderId, orderDestinationName, orderAddress, Boolean.TRUE);

		return order;
	}

	@Override
	public void addProduct(final Integer productId, final String productName, final double productPrice) {

		// Adición de un producto al envío.
		if (order.insertProduct(productId, productName, productPrice)) {
			System.out.println("El producto " + productId + " se ha añadido correctamente.");
		} else {
			System.out.println("No se ha añadido correctamente el producto.");
		}
	}

	@Override
	public void modifyProductByID(final Integer productId, final String newProductName, final double newProductPrice) {

		// Modifica un producto del envío localizado por ID.
		if (order.updateProductByID(productId, newProductName, newProductPrice)) {
			System.out.println("El producto " + productId + " se ha modificado correctamente.");
		} else {
			System.out.println("No se ha modificado correctamente el producto.");
		}
	}

	@Override
	public void removeProductByID(final Integer productId) {

		// Elimina un producto del envío localizado por ID.
		if (order.deleteProductByID(productId)) {
			System.out.println("El producto " + productId + " se ha eliminado correctamente.");
		} else {
			System.out.println("No se ha eliminado correctamente el producto.");
		}
	}

	@Override
	public void showProductByID(final Integer productId) {

		// Recupera el producto buscado.
		EverisProduct searchedProduct = order.searchProducByID(productId);

		// Comprobación de que el producto buscado exista.
		if (searchedProduct != null) {

			// Calcula el PVP del producto.
			calculatePvpProductByID(searchedProduct.getProductId());

			// Imprime por pantalla la información del producto buscado
			System.out.println("ID Producto :" + searchedProduct.getProductId() + " Nombre: "
					+ searchedProduct.getProductName() + " Precio: " + df.format(searchedProduct.getProductPrice())
					+ "€ PVP: " + df.format(searchedProduct.getProductPVP()) + "€.");
		} else {
			System.out.println("No se ha encontrado el producto en la lista del envío.");
		}
	}

	@Override
	public void showAllProducts() {

		// Recupera la lista de productos completa.
		List<EverisProduct> productsList = order.getProductsList();

		// Comprobación de que la lista no esté vacía.
		if (!CollectionUtils.isEmpty(productsList)) {

			// Itera por la lista, calcula el PVP e imprime por pantalla la información de
			// cada producto.
			for (EverisProduct product : productsList) {

				calculatePvpProductByID(product.getProductId());

				System.out.println("IDProd: " + product.getProductId() + " | Nombre: " + product.getProductName()
						+ " | Precio: " + df.format(product.getProductPrice()) + "€ | PVP: "
						+ df.format(product.getProductPVP()) + "€.");
			}
		} else {
			System.out.println("El envío no contiene ningún producto.");
		}
	}

	@Override
	public void showTotalOrderPrice() {

		// Recupera la lista de productos completa.
		List<EverisProduct> productsList = order.getProductsList();

		// Comprobación de que la lista no esté vacía.
		if (!CollectionUtils.isEmpty(productsList)) {

			// Instancia del precio total.
			double totalPrice = 0;

			// Itera por la lista y suma el PVP de todos los productos.
			for (EverisProduct product : productsList) {
				totalPrice += product.getProductPVP();
			}

			System.out.println("Precio total del envío: " + df.format(totalPrice) + "€.");

		}
	}

	@Override
	public EverisProduct calculatePvpProductByID(final Integer productId) {

		// Instancia del producto a retornar.
		EverisProduct searchedProduct = null;

		// Comprueba que el envío sea nacional fuera de la península.
		if (order.getOrderOutOfPeninsula()) {

			// Recupera el producto buscado.
			searchedProduct = order.searchProducByID(productId);

			// Aplicamos el IPSI (impuesto del 4% sobre el precio)
			searchedProduct
					.setProductPVP(searchedProduct.getProductPrice() + (searchedProduct.getProductPrice() * 0.04));
		}

		return searchedProduct;
	}

	@Override
	public void breakDownOrder() {

		System.out.println("-------------------------------------------------------------");
		System.out.println("ID Pedido: " + order.getOrderId() + "\nCliente: " + order.getOrderDestinationName()
				+ "\nDirección: " + order.getOrderAddress());
		System.out.println("-------------------------------------------------------------");
		showAllProducts();
		System.out.println("-------------------------------------------------------------");
		showTotalOrderPrice();
		System.out.println("-------------------------------------------------------------");
	}

}
