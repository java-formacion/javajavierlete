package com.ipartek.pruebaSpringMVC.service;

import java.util.List;

import com.ipartek.pruebaSpringMVC.vo.Alumno;

public interface AlumnoService {

	
	public List<Alumno> getAlumnos();
	public void addAlumno(Alumno al);
	
}
