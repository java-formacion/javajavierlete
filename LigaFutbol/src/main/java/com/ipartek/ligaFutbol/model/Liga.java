package com.ipartek.ligaFutbol.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="ligas")
public class Liga {

	
	@Id
	@Column(name="Cod")
	private String cod;
	
	
	@Column(name="Nombre")
	private String nombre;
	
	
	@Column(name="Pais")
	private String pais;
	
	@OneToMany(mappedBy="liga")
	@JsonIgnore
	List<Equipo> equipos;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	
	
	
	
}
