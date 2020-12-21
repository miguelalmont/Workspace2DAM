package com.everis.springMVC.repositories;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Entidad cliente
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
	private String nif;

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
	@NotNull
	@NotEmpty(message = "El nombre no puede estar vacío.")
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
	@NotNull
	@NotEmpty(message = "El primer apellido no puede estar vacío.")
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
	@NotNull
	@NotEmpty(message = "EL segundo apellido no puede estar vacío.")
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
	@NotNull
	@NotEmpty(message = "El NIF no puede estar vacío.")
	@Pattern(regexp = "\\d{8}[A-HJ-NP-TV-Z]", message = "El NIF debe contener 8 cifras y una letra.")
	@Column(name = "client_nif", length = 9, nullable = false, unique = true)
	public String getNif() {
		return nif;
	}

	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

}
