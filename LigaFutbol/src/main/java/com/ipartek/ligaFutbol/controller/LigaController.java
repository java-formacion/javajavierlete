package com.ipartek.ligaFutbol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.ligaFutbol.model.Liga;
import com.ipartek.ligaFutbol.services.LigaService;

@RestController
@RequestMapping("/ligas")	
public class LigaController {
	
	
	@Autowired
	LigaService ligaService;
	
	@GetMapping(produces = "application/json")
	public List<Liga> getligas() {
		
		return ligaService.getLigas();
		
	}

}
