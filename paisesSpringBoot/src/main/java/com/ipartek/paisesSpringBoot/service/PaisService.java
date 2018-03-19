package com.ipartek.paisesSpringBoot.service;

import java.util.List;

import com.ipartek.paisesSpringBoot.domain.Pais;

public interface PaisService {

	public List<Pais> getPaises();

	public Pais getPaisByNombre(String nombre);

	public void addPais(Pais pais);

	public void updatePais(Pais pais);

	public void deletePaisById(Integer id);

}
