package com.ipartek.colegioHibernate.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="profesores")
public class profesor {

	@Id
	@GeneratedValue
	@Column(name="idprofesores")
	private int id;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellidos")
	private String apellido;
	
	@OneToMany ( mappedBy = "p")
	List<asignatura> asignaturas;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
	
	
	
	
}
