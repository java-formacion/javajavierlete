package com.ipartek.pruebaSpringMVC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.pruebaSpringMVC.model.AlumnoDAO;
import com.ipartek.pruebaSpringMVC.service.AlumnoService;
import com.ipartek.pruebaSpringMVC.vo.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	AlumnoDAO alumnoDao;
	
	
	@Override
	public List<Alumno> getAlumnos() {
		
		return alumnoDao.getAlumnos();
	}

}
