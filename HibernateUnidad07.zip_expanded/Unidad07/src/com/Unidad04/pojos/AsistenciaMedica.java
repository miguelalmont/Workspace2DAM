package com.Unidad04.pojos;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="asistenciamedica")
public class AsistenciaMedica {
	
	@Id
	@Column(name="IdAsistenciaMedica")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int idAsistenciaMedica;
	
	@ManyToOne
	@JoinColumn(name="IdSeguro")
	Seguro seguro;
	
	@Column(name="breveDescripcion")
	String breveDescripcion;
	
	@Column(name="lugar")
	String lugar;
	
	@Column(name="explicacion")
	String explicacion;
	
	@Enumerated(EnumType.STRING)
	TipoAsistencia tipoAsistencia;
	
	@Column(name="fecha")
	Date fecha;
	
	@Column(name="hora")
	Date hora;
	
	@Column(name="importe")
	BigDecimal importe;
	
	public AsistenciaMedica() {
		
	}
	
	public AsistenciaMedica(Seguro seguro, String breveDescripcion, String lugar,
			String explicacion, TipoAsistencia tipoAsistencia, Date fecha, Date hora, BigDecimal importe) {
		this.seguro = seguro;
		this.breveDescripcion = breveDescripcion;
		this.lugar = lugar;
		this.explicacion = explicacion;
		this.tipoAsistencia = tipoAsistencia;
		this.fecha = fecha;
		this.hora = hora;
		this.importe = importe;
	}

	public int getIdAsistenciaMedica() {
		return idAsistenciaMedica;
	}

	public void setIdAsistenciaMedica(int idAsistenciaMedica) {
		this.idAsistenciaMedica = idAsistenciaMedica;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public String getBreveDescripcion() {
		return breveDescripcion;
	}

	public void setBreveDescripcion(String breveDescripcion) {
		this.breveDescripcion = breveDescripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public TipoAsistencia getTipoAsistencia() {
		return tipoAsistencia;
	}

	public void setTipoAsistencia(TipoAsistencia tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	
}
