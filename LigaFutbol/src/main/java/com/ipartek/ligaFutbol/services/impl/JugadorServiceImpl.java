package com.ipartek.ligaFutbol.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.ligaFutbol.dao.JugadoresRepository;
import com.ipartek.ligaFutbol.model.Jugador;
import com.ipartek.ligaFutbol.services.JugadorService;

@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	JugadoresRepository jugadorRepository;
	
	@Override
	public List<Jugador> getJugadores() {
		
		return jugadorRepository.findAll();
	}

	@Override
	public Jugador getJugadorByID(int id) {
		
		return null;
	}

}
