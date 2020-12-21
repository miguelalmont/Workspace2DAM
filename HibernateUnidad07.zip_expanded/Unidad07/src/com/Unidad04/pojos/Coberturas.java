package com.Unidad04.pojos;

import javax.persistence.*;

@Embeddable
public class Coberturas {
	
	@Column(name="oftalmologia")
	private boolean oftalmologia;
	
	@Column(name="dental")
	private boolean dental;
	
	@Column(name="fecundacionInVitro")
	private boolean fecundacionInVitro;
	
	public Coberturas() {
		
	}
	
	public Coberturas(boolean oftalmologia, boolean dental, boolean fecundacionInVitro) {
		super();
		this.oftalmologia = oftalmologia;
		this.dental = dental;
		this.fecundacionInVitro = fecundacionInVitro;
	}
	
	public boolean isOftalmologia() {
		return oftalmologia;
	}
	public void setOftalmologia(boolean oftalmologia) {
		this.oftalmologia = oftalmologia;
	}
	public boolean isDental() {
		return dental;
	}
	public void setDental(boolean dental) {
		this.dental = dental;
	}
	public boolean isFecundacionInVitro() {
		return fecundacionInVitro;
	}
	public void setFecundacionInVitro(boolean fecundacionInVitro) {
		this.fecundacionInVitro = fecundacionInVitro;
	}
	
	
}
