package com.Unidad04.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.Unidad04.persistence.hibernate.util.Caption;

@Entity
@Table(name="seguro")
public class Seguro implements Serializable {
	
	@Id
	@Column(name="IdSeguro")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSeguro;
	
	@Embedded
    private NIF nif;
    
	@NotBlank
    @Caption("nombre")
    private String nombre;
    
	@NotBlank
    @Caption("ape1")    
    private String ape1;
    
    @Column(name="ape2")    
    private String ape2;
    
    @Column(name="edad") 
    private int edad;
    
    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo;
    
    @Column(name="casado")
    private boolean casado;
    
    @Column(name="numHijos") 
    private int nHijos;
    
    @Column(name="embarazada")
    private boolean embarazada;
    
    @Embedded
    private Coberturas coberturas;
    
    @Embedded
    private Enfermedades enfermedades;
    
    @Column(name="fechaCreacion") 
    private Date fechaCreacion;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdSeguro")
    @IndexColumn(name="IdAsistenciaMedica")
    private List<AsistenciaMedica> asistenciasMedicas;
    
    public Seguro() {
    	asistenciasMedicas = new ArrayList<>();
    }
    
	public Seguro(NIF nif, String nombre, String ape1, String ape2, int edad, Sexo sexo, boolean casado,
			int nHijos, boolean embarazada, Coberturas coberturas, Enfermedades enfermedades, Date fechaCreacion) {
		this.nif = nif;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.edad = edad;
		this.sexo = sexo;
		this.casado = casado;
		this.nHijos = nHijos;
		this.embarazada = embarazada;
		this.coberturas = coberturas;
		this.enfermedades = enfermedades;
		this.fechaCreacion = fechaCreacion;
		asistenciasMedicas = new ArrayList<>();
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public NIF getNif() {
		return nif;
	}

	public void setNif(NIF nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getnHijos() {
		return nHijos;
	}

	public void setnHijos(int nHijos) {
		this.nHijos = nHijos;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public List<AsistenciaMedica> getAsistenciasMedicas() {
		return asistenciasMedicas;
	}


	public void setAsistenciasMedicas(List<AsistenciaMedica> asistenciasMedicas) {
		this.asistenciasMedicas = asistenciasMedicas;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public boolean isEmbarazada() {
		return embarazada;
	}

	public void setEmbarazada(boolean embarazada) {
		this.embarazada = embarazada;
	}

	public Coberturas getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(Coberturas coberturas) {
		this.coberturas = coberturas;
	}

	public Enfermedades getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(Enfermedades enfermedades) {
		this.enfermedades = enfermedades;
	}
    
	
}
