package com.everis.hibernate.repositories;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author malcanmo
 *
 */
@Entity(name = "t_contract")
@Table(name = "t_contract")
public class EverisContract implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** ID del contrato */
	Integer contractID;

	/** Fecha de vigencia del contrato */
	private Date contractEffectiveDate;

	/** Fecha de caducidad del contrato */
	private Date contractExpirationDate;

	/** Precio mensual del contrato */
	private Double contractMonthlyPrice;

	/** Cliente asociado al contrato */
	private EverisClient contractClient;

	/**
	 * Constructor vacío.
	 */
	public EverisContract() {
	}

	/**
	 * @return the contractID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_id")
	public Integer getContractID() {
		return contractID;
	}

	/**
	 * @param contractID the contractID to set
	 */
	public void setContractID(Integer contractID) {
		this.contractID = contractID;
	}

	/**
	 * @return the contractEffectiveDate
	 */
	@Column(name = "contract_effective_date")
	public Date getContractEffectiveDate() {
		return contractEffectiveDate;
	}

	/**
	 * @param contractEffectiveDate the contractEffectiveDate to set
	 */
	public void setContractEffectiveDate(Date contractEffectiveDate) {
		this.contractEffectiveDate = contractEffectiveDate;
	}

	/**
	 * @return the contractExpirationDate
	 */
	@Column(name = "contract_expiration_date")
	public Date getContractExpirationDate() {
		return contractExpirationDate;
	}

	/**
	 * @param contractExpirationDate the contractExpirationDate to set
	 */
	public void setContractExpirationDate(Date contractExpirationDate) {
		this.contractExpirationDate = contractExpirationDate;
	}

	/**
	 * @return the contractMonthlyPrice
	 */
	@Column(name = "contract_monthly_price")
	public Double getContractMonthlyPrice() {
		return contractMonthlyPrice;
	}

	/**
	 * @param contractMonthlyPrice the contractMonthlyPrice to set
	 */
	public void setContractMonthlyPrice(Double contractMonthlyPrice) {
		this.contractMonthlyPrice = contractMonthlyPrice;
	}

	/**
	 * @return the contractClient
	 */
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	public EverisClient getContractClient() {
		return contractClient;
	}

	/**
	 * @param contractClient the contractClient to set
	 */
	public void setContractClient(EverisClient contractClient) {
		this.contractClient = contractClient;
	}

}
