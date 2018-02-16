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
			"INSERT INTO Coche " +
			"(marca, modelo, cv, matricula, anios)" +
			"VALUES (?, ?, ?, ?,?)";
	private static final String SQL_UPDATE =
			"UPDATE Coche SET "+
			"marca=?, modelo=?, cv=?, matricula=?, anios=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM Coche WHERE id=?";
	
	private static final String SQL_SELECT = 
			"SELECT id, marca, modelo, cv, matricula, anios FROM Coche ";
	private static final String SQL_SELECTID = 
			"SELECT id, marca, modelo, cv, matricula, anios FROM Coche where id=?";
	
	
	private static String url="jdbc:sqlite:C:\\BDD\\taller.db";
	private static String user="";
	private static String password="";
	
	protected static Connection con = null;
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	
	public DaoCoche() {
		
	}
	public DaoCoche(String url, String user, String password) {
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
	
	
	
	public Coche[] mostrarCoches() throws Exception {
		
		//List<Usuario> usuarios = new ArrayList<Usuario>(); esta seria mejor
		List<Coche> coches = new ArrayList<Coche>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_SELECT);
			
			rs = ps.executeQuery();
			
			Coche c;
			
			while(rs.next()) {
				c = new Coche(
						rs.getInt("id"),
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getString("cv"),
						rs.getString("matricula"),
						rs.getString("anios"));
				
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
			
			ps = con.prepareStatement(SQL_SELECTID);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			Coche c;
			
			if(rs.next()) {
				c = new Coche(
						rs.getInt("id"),
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getString("cv"),
						rs.getString("matricula"),
						rs.getString("anios"));
				return c;
				
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
	
	
	public void insertarCoche(Coche c) throws Exception {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setString(3, c.getCv());
			ps.setString(4, c.getMatricula());
			ps.setString(5, c.getAnios());
			
			
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
	
	
	
	
	
	
	

