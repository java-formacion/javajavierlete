package com.ipartek.paisesSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.paisesSpringBoot.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, String> {

	Pais findByNombre(String nombre);

}
