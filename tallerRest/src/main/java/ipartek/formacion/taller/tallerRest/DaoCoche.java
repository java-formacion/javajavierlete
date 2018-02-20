package ipartek.formacion.taller.tallerRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCoche {


	private static final String SQL_INSERT = 
			"INSERT INTO coche " +
			"(marca, modelo, cv, matricula, anios, Usuario_id)" +
			"VALUES (?, ?, ?, ?,?,?)";
	private static final String SQL_UPDATE =
			"UPDATE coche SET "+
			"marca=?, modelo=?, cv=?, matricula=?, anios=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM coche WHERE id=?";
	
	private static final String SQL_SELECTANIDADA_USUARIO = 
			"SELECT coche.id, coche.marca, coche.modelo, coche.cv, coche.matricula,\r\n" + 
			"coche.anios, usuario.id, usuario.nombre, usuario.apellido, \r\n" + 
			"usuario.email, usuario.telefono  From coche INNER JOIN\r\n" + 
			"usuario ON usuario.id = coche.Usuario_id";
	
	private static final String SQL_ANIDADA_COCHE_ID = 
			"SELECT coche.id, coche.marca, coche.modelo, coche.cv, coche.matricula,\r\n" + 
					"coche.anios, usuario.id, usuario.nombre, usuario.apellido, \r\n" + 
					"usuario.email, usuario.telefono  From coche INNER JOIN\r\n" + 
					"usuario ON usuario.id = coche.Usuario_id where coche.id=?";
	
	
	private static String url="jdbc:mysql://localhost:3306/taller";
	private static String user="root";
	private static String password="root";
	
	protected static Connection con = null;
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	
	public DaoCoche() {
		
	}
	public DaoCoche(String url, String user, String password) {
		super();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	protected static void crearConexion() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	*/
	
	
	
	public Coche[] mostrarCoches() throws Exception {
		
		//List<Usuario> usuarios = new ArrayList<Usuario>(); esta seria mejor
		List<Coche> coches = new ArrayList<Coche>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_SELECTANIDADA_USUARIO);
			
			rs = ps.executeQuery();
			
			Coche c;
			Usuario u;
			while(rs.next()) {
				
				u = new Usuario(
						rs.getInt("usuario.id"),
						rs.getString("usuario.nombre"),
						rs.getString("usuario.apellido"),
						rs.getString("usuario.email"),
						rs.getString("usuario.telefono"));
				c = new Coche(
						rs.getInt("coche.id"),
						rs.getString("coche.marca"),
						rs.getString("coche.modelo"),
						rs.getString("coche.cv"),
						rs.getString("coche.matricula"),
						rs.getString("coche.anios"),
						u);
				
				coches.add(c);
			}
			
			
			return coches.toArray(new Coche[coches.size()]);
		} catch (SQLException e) {
			throw new Exception(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
		
	}
	
	
	

	public Coche mostrarCoche(int id) throws Exception {
		
		//List<Usuario> usuarios = new ArrayList<Usuario>(); esta seria mejor
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_ANIDADA_COCHE_ID);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			Coche c;
			Usuario u;
			while(rs.next()) {
				
				u = new Usuario(
						rs.getInt("usuario.id"),
						rs.getString("usuario.nombre"),
						rs.getString("usuario.apellido"),
						rs.getString("usuario.email"),
						rs.getString("usuario.telefono"));
				c = new Coche(
						rs.getInt("coche.id"),
						rs.getString("coche.marca"),
						rs.getString("coche.modelo"),
						rs.getString("coche.cv"),
						rs.getString("coche.matricula"),
						rs.getString("coche.anios"),
						u);
				
				return c;
			}
				
			
		} catch (SQLException e) {
			throw new Exception(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
		return null;
		
	}
	
	
	public void insertarCoche(Coche c) throws Exception {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		Usuario u = c.getU();
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setString(3, c.getCv());
			ps.setString(4, c.getMatricula());
			ps.setString(5, c.getAnios());
			ps.setInt(6, u.getId());
			
			
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new Exception(
						"La inserci�n ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new Exception(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
		
		
	}
	
	
	public void modificarCoche(Coche c) throws Exception {
	
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_UPDATE);
			
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setString(3, c.getCv());
			ps.setString(4, c.getMatricula());
			ps.setString(5, c.getAnios());
			ps.setInt(6, c.getId());
			
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new Exception(
						"La inserci�n ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new Exception(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
		
		
	}
	
	
	public void borrarCoche(Coche c) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_DELETE);
			
			ps.setInt(1, c.getId());
			
			
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new Exception(
						"La inserci�n ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new Exception(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
	
	}
	
	
}
	
	
	
	
	
	
	

