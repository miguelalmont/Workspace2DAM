package com.everis.hibernate.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author malcanmo
 *
 */
@Entity(name = "t_client")
@Table(name = "t_client")
public class EverisClient implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** ID del cliente */
	private Integer clientID;

	/** Nombre del cliente */
	private String clientName;

	/** Primer apellido del cliente */
	private String clientFirstLastName;

	/** Segundo apellido del cliente */
	private String clientSecondLastName;

	/** Numero de documento de identidad del cliente */
	private Integer nif;
	
	/** Lista de contratos asociados al cliente */
	private List<EverisContract> clientContractsList;

	/**
	 * Constructor vacío
	 */
	public EverisClient() {
	};

	/**
	 * @return the clientID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	public Integer getClientID() {
		return clientID;
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	/**
	 * @return the clientName
	 */
	@Column(name = "client_name")
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the clientFirstLastName
	 */
	@Column(name = "client_firstlastname")
	public String getClientFirstLastName() {
		return clientFirstLastName;
	}

	/**
	 * @param clientFirstLastName the clientFirstLastName to set
	 */
	public void setClientFirstLastName(String clientFirstLastName) {
		this.clientFirstLastName = clientFirstLastName;
	}

	/**
	 * @return the clientSecondLastName
	 */
	@Column(name = "client_secondlastname")
	public String getClientSecondLastName() {
		return clientSecondLastName;
	}

	/**
	 * @param clientSecondLastName the clientSecondLastName to set
	 */
	public void setClientSecondLastName(String clientSecondLastName) {
		this.clientSecondLastName = clientSecondLastName;
	}

	/**
	 * @return the nif
	 */
	@Column(name = "client_nif", length = 9, nullable = false, unique = true)
	public Integer getNif() {
		return nif;
	}

	/**
	 * @param nif the nif to set
	 */
	public void setNif(Integer nif) {
		this.nif = nif;
	}

	/**
	 * @return the clientContractsList
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contractClient")
	public List<EverisContract> getClientContractsList() {
		return clientContractsList;
	}

	/**
	 * @param clientContractsList the clientContractsList to set
	 */
	public void setClientContractsList(List<EverisContract> clientContractsList) {
		this.clientContractsList = clientContractsList;
	}
	
}
