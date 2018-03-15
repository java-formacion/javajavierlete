package com.ipartek.pruebaSpringMVC.model;

import java.util.List;

import com.ipartek.pruebaSpringMVC.vo.Alumno;

public interface AlumnoDAO {

	
	public List<Alumno> getAlumnos();
	
	public void addAlumno(Alumno al);
}
