package com.ipartek.bootColegio.model.pks;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ipartek.bootColegio.model.Asignatura;

@Embeddable
public class AlumnosAsignaturaspk implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	@Column(name="alumnos_idalumnos")
	private Integer idAlumno;
	
	@ManyToOne
	@JoinColumn(name="asignaturas_idasignaturas")
	private Asignatura asignatura;

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	
	

	
}
