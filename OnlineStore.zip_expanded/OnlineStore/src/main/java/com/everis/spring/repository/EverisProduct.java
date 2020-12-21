package com.everis.spring.repository;

import java.io.Serializable;

/**
 * Clase "entidad / repositorio" de productos de la tienda.
 * 
 * @author malcamo
 *
 */
public class EverisProduct implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** Identificador del producto */
	private Integer productId;

	/** Nombre del producto */
	private String productName;

	/** PVP del producto */
	private double productPVP;

	/** Precio sin impuestos */
	private double productPrice;

	/**
	 * Constructor vacío.
	 */
	public EverisProduct() {
	}

	/**
	 * Constructor parametrizado.
	 * 
	 * @param productId
	 * @param productName
	 * @param productPrice
	 */
	public EverisProduct(Integer productId, String productName, double productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;

	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productPVP
	 */
	public double getProductPVP() {
		return productPVP;
	}

	/**
	 * @param productPVP the productPVP to set
	 */
	public void setProductPVP(double productPVP) {
		this.productPVP = productPVP;
	}

	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
