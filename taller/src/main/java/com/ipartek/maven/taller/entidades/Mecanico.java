package com.ipartek.maven.taller.entidades;

import java.util.ArrayList;

public class Mecanico {

	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String Telefono;
	private ArrayList<Coche> coches;
	
	public Mecanico() {}

	public Mecanico(int id, String nombre, String apellidos, String dni, String telefono, ArrayList<Coche> coches) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		Telefono = telefono;
		this.coches = coches;
	}

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public ArrayList<Coche> getCoches() {
		return coches;
	}

	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}
	
	

	
	
}
