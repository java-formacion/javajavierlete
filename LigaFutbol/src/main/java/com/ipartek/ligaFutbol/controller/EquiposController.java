package com.ipartek.ligaFutbol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.ligaFutbol.model.Equipo;
import com.ipartek.ligaFutbol.services.EquipoService;

@RestController
@RequestMapping("/equipos")	
public class EquiposController {

	@Autowired
	EquipoService equipoService;
	
	
	@GetMapping(produces = "application/json")
	public List<Equipo> getequipos() {
		
		return equipoService.getEquipos();
		
	}
}
