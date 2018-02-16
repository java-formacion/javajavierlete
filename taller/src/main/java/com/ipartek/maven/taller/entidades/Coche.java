package com.ipartek.maven.taller.entidades;

import java.util.ArrayList;

public class Coche {

	private int id;
	private String marca;
	private String modelo;
	private String matricula;
	private ArrayList<Mecanico> mecanicos;
	
	public Coche() {}
	
	public Coche(int id, String marca, String modelo, String matricula, ArrayList<Mecanico> mecanicos) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.mecanicos = mecanicos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public ArrayList<Mecanico> getMecanicos() {
		return mecanicos;
	}

	public void setMecanicos(ArrayList<Mecanico> mecanicos) {
		this.mecanicos = mecanicos;
	}
	
	
	
}
