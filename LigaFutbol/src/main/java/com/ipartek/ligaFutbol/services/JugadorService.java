package com.ipartek.ligaFutbol.services;

import java.util.List;

import com.ipartek.ligaFutbol.model.Jugador;



public interface JugadorService {

	
	public List<Jugador> getJugadores();
	public Jugador getJugadorByID(int id);
	
}
