package com.ipartek.ligaFutbol.services;

import java.util.List;

import com.ipartek.ligaFutbol.model.Liga;

public interface LigaService {

	
	public List<Liga> getLigas();
	public Liga getLigaByID(int id);
	
	
}
