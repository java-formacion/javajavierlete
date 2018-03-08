package com.ipartek.colegioHibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="asignaturas")
public class asignatura {

	
	@Id
	@GeneratedValue
	@Column(name="idAsignaturas")
	private int id;
	
	@Column(name="Nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "Profesores_idProfesores")
	private profesor p;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public profesor getP() {
		return p;
	}

	public void setP(profesor p) {
		this.p = p;
	}

	
	
	
	
}
