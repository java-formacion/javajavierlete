package com.ipartek.pruebaSpringMVC.model.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.ipartek.pruebaSpringMVC.model.AlumnoDAO;
import com.ipartek.pruebaSpringMVC.vo.Alumno;

@Repository
public class AlumnoDAOImpl implements AlumnoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Alumno> getAlumnos() {
		
		
		CriteriaBuilder builder = currentSession().getCriteriaBuilder();
		CriteriaQuery<Alumno> criteria = builder.createQuery(Alumno.class);
		
		Root<Alumno> root = criteria.from(Alumno.class);
		List<Alumno> alumnos =currentSession().createQuery(criteria).getResultList();

		
		
		return alumnos;
	}

	@Override
	@Transactional(readOnly=false)
	public void addAlumno(Alumno al) {
		
		
		sessionFactory.getCurrentSession().save(al);
		

		
	}
	
	
	
	
	
	
	
	
}
