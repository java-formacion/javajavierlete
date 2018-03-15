package com.ipartek.ligaFutbol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.ligaFutbol.dao.EquiposRepository;
import com.ipartek.ligaFutbol.model.Equipo;



public interface EquipoService {


	
	
	public List<Equipo> getEquipos();
	public Equipo getEquipoByID(int id);
	
}
