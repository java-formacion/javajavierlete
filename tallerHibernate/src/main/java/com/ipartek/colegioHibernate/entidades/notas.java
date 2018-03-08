package com.ipartek.colegioHibernate.entidades;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="notas")
public class notas {
	

@EmbeddedId 
private id_notas id;

@Column(name = "Alumnos_idAlumnos")
private int idAlumno;

@Column(name="Nota")
private String notas;

@ManyToOne
@JoinColumn(name="Asignaturas_idAsignaturas")
private asignatura a;

public id_notas getId() {
	return id;
}

public void setId(id_notas id) {
	this.id = id;
}

public String getNotas() {
	return notas;
}

public void setNotas(String notas) {
	this.notas = notas;
}

public asignatura getA() {
	return a;
}

public void setA(asignatura a) {
	this.a = a;
}
	



}
