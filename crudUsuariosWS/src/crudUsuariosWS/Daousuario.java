package crudUsuariosWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Daousuario {

	private static final String SQL_INSERT = 
			"INSERT INTO Usuarios " +
			"(nombre, apellido, email, telefono)" +
			"VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE =
			"UPDATE Usuarios SET "+
			"nombre=?, apellido=?, email=?, telefono=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM Usuarios WHERE id=?";
	
	private static final String SQL_SELECT = 
			"SELECT id, nombre, apellido, email, telefono FROM Usuarios ";
	
	
	private static String url="jdbc:sqlite:C:\\sqliteCRUDUsuariosWS\\crudUsuariosWS.db";
	private static String user="";
	private static String password="";
	
	protected static Connection con = null;
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	
	public Daousuario() {
		
	}
	public Daousuario(String url, String user, String password) {
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
	
	
	
	public Usuario[] mostrarUsuarios() throws Exception {
		
		//List<Usuario> usuarios = new ArrayList<Usuario>(); esta seria mejor
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_SELECT);
			
			rs = ps.executeQuery();
			
			Usuario u;
			
			while(rs.next()) {
				u = new Usuario(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("email"),
						rs.getInt("telefono"));
				
				usuarios.add(u);
			}
			
			return usuarios.toArray(new Usuario[usuarios.size()]);
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
	
	
	public void insertarUsuario(Usuario usuario) throws Exception {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_INSERT);
			
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getEmail());
			ps.setInt(4, usuario.getTelefono());
			
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new Exception(
						"La inserción ha devuelto un resultado diferente de 1");
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
	
	
	public void modificarUsuario(Usuario usuario) throws Exception {
	
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_UPDATE);
			
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getEmail());
			ps.setInt(4, usuario.getTelefono());
			
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new Exception(
						"La inserción ha devuelto un resultado diferente de 1");
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
	
	
	public void borrarUsuario(Usuario usuario) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_DELETE);
			
			ps.setInt(1, usuario.getId());
			
			
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new Exception(
						"La inserción ha devuelto un resultado diferente de 1");
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
