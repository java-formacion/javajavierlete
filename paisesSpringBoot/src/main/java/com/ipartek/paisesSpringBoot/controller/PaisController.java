package com.ipartek.paisesSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.paisesSpringBoot.domain.Pais;
import com.ipartek.paisesSpringBoot.service.PaisService;

//@CrossOrigin(origins = { "http://localhost:5500", "127.0.0.1:5500" })
@RestController
@RequestMapping(value="/paises")
public class PaisController {

	@Autowired
	PaisService paisService;

	@GetMapping(produces = "application/json")
	public List<Pais> getPaises() {
		return paisService.getPaises();
	}

	@GetMapping(path = "/{nombre}", produces = "application/json")
	public Pais getPaisByNombre(@PathVariable String nombre) {
		return paisService.getPaisByNombre(nombre);
	}

	@PostMapping("/add")
	public void addPais(@RequestBody Pais pais) {
		paisService.addPais(pais);
	}
	
	@PutMapping("/update")
	public void updatePais(@RequestBody Pais pais) {
		paisService.updatePais(pais);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePais(@PathVariable Integer id) {
		paisService.deletePaisById(id);
	}
	
}
