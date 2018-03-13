package com.ipartek.bootColegio.alumnoService;

import java.util.List;

import com.ipartek.bootColegio.model.Alumno;



public interface AlumnoService {

	
	public List<Alumno> getAlumnos();
	public Alumno getAlumnoByID(int id);
	
}
