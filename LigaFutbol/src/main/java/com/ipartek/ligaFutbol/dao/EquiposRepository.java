package com.ipartek.ligaFutbol.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.ligaFutbol.model.Equipo;

public interface EquiposRepository extends JpaRepository<Equipo, Integer> {

}
