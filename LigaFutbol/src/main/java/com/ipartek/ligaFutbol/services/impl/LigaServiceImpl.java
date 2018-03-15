package com.ipartek.ligaFutbol.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.ligaFutbol.dao.LigaRepository;
import com.ipartek.ligaFutbol.model.Liga;
import com.ipartek.ligaFutbol.services.LigaService;

@Service
public class LigaServiceImpl implements LigaService {
	
	@Autowired
	LigaRepository ligaRepository;
	
	@Override
	public List<Liga> getLigas() {
		
		return ligaRepository.findAll();
	}

	@Override
	public Liga getLigaByID(int id) {
		
		return null;
	}

	
	
}
