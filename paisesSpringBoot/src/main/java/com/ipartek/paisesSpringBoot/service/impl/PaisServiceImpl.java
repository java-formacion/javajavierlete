package com.ipartek.paisesSpringBoot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.paisesSpringBoot.domain.Pais;
import com.ipartek.paisesSpringBoot.repository.PaisRepository;
import com.ipartek.paisesSpringBoot.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	PaisRepository paisRepository;

	public List<Pais> getPaises() {
		return paisRepository.findAll();
	}

	public Pais getPaisByNombre(String nombre) {
		return paisRepository.findByNombre(nombre);
	}

	public void addPais(Pais pais) {
		paisRepository.save(pais);
	}

	public void updatePais(Pais pais) {
		paisRepository.save(pais);
	}

	public void deletePaisById(Integer id) {
		Pais p = new Pais();
		p.setId(id);
		paisRepository.delete(p);
	}

}
