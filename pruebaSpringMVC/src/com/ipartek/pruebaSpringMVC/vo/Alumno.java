package com.ipartek.pruebaSpringMVC.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity 
@Table(name="alumnos")
public class Alumno {

	@Id
	@GeneratedValue
	@Column(name="idAlumnos")
	private int id;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellidos")
	private String apellido;
	
	@Column(name="Correo")
	private String email;
	
	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
