package com.Unidad04.pojos;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotBlank;

import com.Unidad04.persistence.hibernate.util.Caption;

@Embeddable
public class NIF {
	
	@NotBlank
	@Caption("nif")
	private String nif;
	
	public NIF () {
		
	}
	
	public NIF(String nif) {
		this.nif = nif;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	
}
