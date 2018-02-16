package ipartek.formacion.taller.tallerRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoMecanico {

	

	private static final String SQL_INSERT = 
			"INSERT INTO Mecanico " +
			"(nombre, apellido, experiencia, telefono)" +
			"VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE =
			"UPDATE Mecanico SET "+
			"nombre=?, apellido=?, experiencia=?, telefono=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM Mecanico WHERE id=?";
	
	private static final String SQL_SELECT = 
			"SELECT id, nombre, apellido, experiencia, telefono FROM Mecanico ";
	private static final String SQL_SELECTID = 
			"SELECT id, nombre, apellido, experiencia, telefono FROM Mecanico where id=?";
	
	
	private static String url="jdbc:sqlite:C:\\BDD\\taller.db";
	private static String user="";
	private static String password="";
	
	protected static Connection con = null;
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	
	public DaoMecanico() {
		
	}
	public DaoMecanico(String url, String user, String password) {
		super();
		
		try {
			Class.forName("org.sqlite.JDBC");
			
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
	
	
	
	public Mecanico[] mostrarMecanicos() throws Exception {
		
		//List<Usuario> usuarios = new ArrayList<Usuario>(); esta seria mejor
		List<Mecanico> mecanicos = new ArrayList<Mecanico>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_SELECT);
			
			rs = ps.executeQuery();
			
			Mecanico m;
			
			while(rs.next()) {
				m = new Mecanico(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("experiencia"),
						rs.getString("telefono"));
				
				mecanicos.add(m);
			}
			
			
			return mecanicos.toArray(new Mecanico[mecanicos.size()]);
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
	
	
	

	public Mecanico mostrarMecanico(int id) throws Exception {
		
		//List<Usuario> usuarios = new ArrayList<Usuario>(); esta seria mejor
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_SELECTID);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			Mecanico m;
			
			if(rs.next()) {
				m = new Mecanico(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("experiencia"),
						rs.getString("telefono"));
				return m;
				
			}else return null;
			
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
	
	
	public void insertarMecanico(Mecanico m) throws Exception {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_INSERT);
			
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getApellido());
			ps.setString(3, m.getExperiencia());
			ps.setString(4, m.getTelefono());
			
			
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
	
	
	public void modificarMecanico(Mecanico m) throws Exception {
	
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_UPDATE);
			
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getApellido());
			ps.setString(3, m.getExperiencia());
			ps.setString(4, m.getTelefono());
			ps.setInt(5, m.getId());
			
			
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
	
	
	public void borrarMecanico(Mecanico m) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_DELETE);
			
			ps.setInt(1, m.getId());
			
			
			
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
	
	
	

