package com.ipartek.pruebaSpringMVC.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.pruebaSpringMVC.service.AlumnoService;
import com.ipartek.pruebaSpringMVC.validator.ValidarAlumno;
import com.ipartek.pruebaSpringMVC.vo.Alumno;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	
	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	ValidarAlumno validarAlumno;
	
	 @InitBinder
	   protected void initBinder(WebDataBinder binder) {
	      binder.addValidators(validarAlumno);
	   }
	
	@RequestMapping(method=RequestMethod.GET)
	public String inicio(ModelMap model){
		
		List<Alumno> alumnos = alumnoService.getAlumnos();
		
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("alumno", new Alumno());
		
		return "alumnos";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addCd (ModelMap model,@ModelAttribute("alumno") @Validated Alumno al, BindingResult result) {
		
		if(result.hasErrors())
		{
			return "alumnos";
		}
		alumnoService.addAlumno(al);
		
		List<Alumno> alumnos = alumnoService.getAlumnos();
		
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("alumno", new Alumno());
		
		return "alumnos";
}
	
}
