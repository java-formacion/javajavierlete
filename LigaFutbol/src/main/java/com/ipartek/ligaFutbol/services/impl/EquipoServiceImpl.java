package com.ipartek.ligaFutbol.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.ligaFutbol.dao.EquiposRepository;
import com.ipartek.ligaFutbol.model.Equipo;
import com.ipartek.ligaFutbol.services.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	EquiposRepository equiposRepository;
	
	
	@Override
	public List<Equipo> getEquipos() {
		
		return equiposRepository.findAll();
	}

	@Override
	public Equipo getEquipoByID(int id) {
		
		return null;
	}

}
