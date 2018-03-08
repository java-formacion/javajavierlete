package com.ipartek.tallerHibernate.clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="mecanico")
public class Mecanico {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	private String nombre, apellido, experiencia, telefono;
	
	
	
}
