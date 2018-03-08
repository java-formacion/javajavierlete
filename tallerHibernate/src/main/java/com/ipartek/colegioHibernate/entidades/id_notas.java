package com.ipartek.colegioHibernate.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class id_notas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "Alumno_idAlumno")
	private int idAlumno;
	
	
	@ManyToOne
	@JoinColumn(name = "Asignaturas_idAsignaturas")
	private asignatura asignatura;
	
	@Column(name = "Nota")
	private String nota;
	
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	
	
	
}
