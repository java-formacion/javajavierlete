package com.ipartek.bootColegio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="alumnos")
public class Alumno {


		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="idalumnos")
		private int id;
		
		@Column(name="Nombre")
		private String nombre;
		
		@Column(name="Apellidos")
		private String apellido;
		
		@Column(name="Correo")
		private String email;
		
		@OneToMany
		@JoinColumn(name="alumnos_idalumnos")
		private List<Notas> notas;


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

		public List<Notas> getNotas() {
			return notas;
		}

		public void setNotas(List<Notas> notas) {
			this.notas = notas;
		}
		
		
		
		
		
	}
	
	

