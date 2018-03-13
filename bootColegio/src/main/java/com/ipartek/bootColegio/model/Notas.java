package com.ipartek.bootColegio.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ipartek.bootColegio.model.pks.AlumnosAsignaturaspk;

@Entity
@Table(name = "notas")
public class Notas {

	@EmbeddedId
	private AlumnosAsignaturaspk pk;
	
	@Column(name="Nota")
	private double nota;

	public AlumnosAsignaturaspk getPk() {
		return pk;
	}

	public void setPk(AlumnosAsignaturaspk pk) {
		this.pk = pk;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	
	
	
}
