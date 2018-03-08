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

import com.ipartek.tallerHibernate.clases.Usuario;

public class App 
{
    public static void main( String[] args ) {
    	
    	Configuration cfg = new Configuration()
				.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/taller")
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "root")
				.setProperty("hibernate.show_sql", "true")
				.setProperty("hibernate.current_session_context_class","thread").addAnnotatedClass(Usuario.class);

		SessionFactory sf = cfg.buildSessionFactory();

		Session s = sf.getCurrentSession();

		s.beginTransaction();

		EntityManager em = s.getEntityManagerFactory().createEntityManager();

		// PASO 1: Crear CriteriaBuilder y CriteriaQuery
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);

		// PASO 2: Configurar la clausula FROM esta para coger todos los campos
		Root<Usuario> root = criteria.from(Usuario.class);

		// PASO 3: Configurar la clausula SELECT para clausulas especificas. hay que tener un comstructor con esas clausualas en la clase
		
		Path<Integer> id = root.<Integer>get("id");
		Path<String> nombre = root.<String>get("nombre");
		Path<String> apellido = root.<String>get("apellido");
		//Path<String> email = root.<String>get("email");
		//Path<String> telefono = root.<String>get("telefono");
		
		
		criteria.select(builder.construct(Usuario.class, id, nombre, apellido));
		
		//criteria.select(root); para seleccionar todos los campos
		
		// PASO 4: Cofigurar los criterios o predicates
		Predicate nombreT = builder.like(root.<String>get("nombre"), "%f%");

		// PASO 5: Configurar la clausula WHERE usando los predicates
		criteria.where(nombreT);

		// PASO 4 y 5 Juntos
		// criteria.where(builder.like(root.get("titulo"), "%b%"));

		// PASO 6: Ejecutar la Query
		List<Usuario> usuarios = em.createQuery(criteria).getResultList();

		s.getTransaction().commit();

		for (Usuario u : usuarios) {
		System.out.println(u.getId() + " " + u.getNombre() + " " + u.getApellido());
    	
    	
    	
    	
    }
   
    
    }
    
}
