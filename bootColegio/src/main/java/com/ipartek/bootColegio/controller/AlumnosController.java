package com.ipartek.bootColegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ipartek.bootColegio.alumnoService.AlumnoService;
import com.ipartek.bootColegio.model.Alumno;





@RestController
@RequestMapping("/alumnos")	
public class AlumnosController {

	@Autowired
	AlumnoService alumnoService;
	
	
@GetMapping(produces = "application/json")
public List<Alumno> getAlumnos() {
	
	return alumnoService.getAlumnos();
	
}


@GetMapping("/{id}")
public Alumno getAlumnosPost(int id) {
	return null;
	
	
}
	
}
