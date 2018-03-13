package com.ipartek.bootColegio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="asignaturas")
public class Asignatura {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idasignaturas")
	private Integer id;
	
	@Column
	private String nombre;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="profesores_idprofesores")
	private Profesor profesor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
	
}
