package com.ipartek.ligaFutbol.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.ligaFutbol.model.Jugador;

public interface JugadoresRepository extends JpaRepository<Jugador, Integer> {

}
