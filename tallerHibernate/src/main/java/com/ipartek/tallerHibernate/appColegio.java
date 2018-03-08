package com.ipartek.tallerHibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ipartek.colegioHibernate.entidades.alumno;
import com.ipartek.colegioHibernate.entidades.asignatura;
import com.ipartek.colegioHibernate.entidades.profesor;


public class appColegio {

	public static void main(String[] args) {
		
	
		Configuration cfg = new Configuration()
				.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/colegio")
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "root")
				.setProperty("hibernate.show_sql", "true")
				.setProperty("hibernate.current_session_context_class","thread")
							.addAnnotatedClass(alumno.class)
							.addAnnotatedClass(asignatura.class)
							.addAnnotatedClass(profesor.class);

		SessionFactory sf = cfg.buildSessionFactory();
		
		
		Session s = sf.getCurrentSession();

		s.beginTransaction();

		EntityManager em = s.getEntityManagerFactory().createEntityManager();

		// PASO 1: Crear CriteriaBuilder y CriteriaQuery
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<alumno> criteria = builder.createQuery(alumno.class);

		// PASO 2: Configurar la clausula FROM esta para coger todos los campos
		Root<alumno> root = criteria.from(alumno.class);

		// PASO 3: Configurar la clausula SELECT para clausulas especificas. hay que tener un comstructor con esas clausualas en la clase
		
		
		//criteria.select(builder.construct(alumno.class, id, nombre, apellido));
		
		criteria.select(root); //para seleccionar todos los campos
		
		// PASO 4: Cofigurar los criterios o predicates
		//Predicate nombreT = builder.like(root.<String>get("nombre"), "%f%");

		// PASO 5: Configurar la clausula WHERE usando los predicates
		//criteria.where(nombreT);

		// PASO 4 y 5 Juntos
		// criteria.where(builder.like(root.get("titulo"), "%b%"));

		// PASO 6: Ejecutar la Query
		List<alumno> alumnos = em.createQuery(criteria).getResultList();

		s.getTransaction().commit();

		for (alumno a : alumnos) {
			
			
				
		System.out.println(a.getId() + " " + a.getNombre() + " " + a.getApellido() + " " + a.getEmail()+ a.getNotas().size());
		
			
		
    	
		}
	}

}
