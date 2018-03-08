package com.ipartek.pruebaSpringMVC.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.pruebaSpringMVC.service.AlumnoService;
import com.ipartek.pruebaSpringMVC.vo.Alumno;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	
	@Autowired
	AlumnoService alumnoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String inicio(ModelMap model){
		
		List<Alumno> alumnos = alumnoService.getAlumnos();
		
		model.addAttribute("alumnos", alumnos);
		
		return "alumnos";
	}
	
}
