package prueba.pruebahibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageUsuario {

	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageUsuario MU = new ManageUsuario();

		Integer userId1 = MU.addUser("Mikel", "mikelpasswd");
		System.out.println("Usuario con identificador: " + userId1 + " creado correctamente en bd");

	}

	public Integer addUser(String nombre, String passwd) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userID = null;

		try {
			tx = session.beginTransaction();
			
			Usuario user = new Usuario(nombre, passwd);
			userID = (Integer) session.save(user);
			
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return userID;
	}

}
