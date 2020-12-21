package com.Unidad04.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Enfermedades {
	
	@Column(name="corazon")
	private boolean corazon;
	
	@Column(name="estomacal")
	private boolean estomacal;
	
	@Column(name="rinyones")
	private boolean rinyones;
	
	@Column(name="alergia")
	private boolean alergia;
	
	@Column(name="nombreAlergia")
	private String nombreAlregia;
	
	public Enfermedades() {
		
	}
	
	public Enfermedades(boolean corazon, boolean estomacal, boolean rinyones, boolean alergia, String nombreAlregia) {
		super();
		this.corazon = corazon;
		this.estomacal = estomacal;
		this.rinyones = rinyones;
		this.alergia = alergia;
		this.nombreAlregia = nombreAlregia;
	}
	public boolean isCorazon() {
		return corazon;
	}
	public void setCorazon(boolean corazon) {
		this.corazon = corazon;
	}
	public boolean isEstomacal() {
		return estomacal;
	}
	public void setEstomacal(boolean estomacal) {
		this.estomacal = estomacal;
	}
	public boolean isRinyones() {
		return rinyones;
	}
	public void setRinyones(boolean rinyones) {
		this.rinyones = rinyones;
	}
	public boolean isAlergia() {
		return alergia;
	}
	public void setAlergia(boolean alergia) {
		this.alergia = alergia;
	}
	public String getNombreAlregia() {
		return nombreAlregia;
	}
	public void setNombreAlregia(String nombreAlregia) {
		this.nombreAlregia = nombreAlregia;
	}
	
	
}
