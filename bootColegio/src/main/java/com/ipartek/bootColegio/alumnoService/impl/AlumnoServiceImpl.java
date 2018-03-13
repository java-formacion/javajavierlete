package com.ipartek.bootColegio.alumnoService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.bootColegio.alumnoService.AlumnoService;
import com.ipartek.bootColegio.dao.AlumnoRepository;
import com.ipartek.bootColegio.model.Alumno;



@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	public List<Alumno> getAlumnos() {
		
		return alumnoRepository.findAll();
	}

	
	public Alumno getAlumnoByID(int id) {
		
		
		return null;
	}

}
