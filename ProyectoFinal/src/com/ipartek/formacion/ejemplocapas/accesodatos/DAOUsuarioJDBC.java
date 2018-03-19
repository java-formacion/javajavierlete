package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.*;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DAOUsuarioJDBC implements DAOUsuario {

	private static final String SQL_INSERT = 
			"INSERT INTO usuarios " +
			"(dni, email, password, nombre, apellidos)" +
			"VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE =
			"UPDATE usuarios SET "+
			"dni=?, email=?, password=?, nombre=?, apellidos=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM usuarios WHERE id=?";
	
	private static final String SQL_SELECT = 
			"SELECT id, dni, email, password, nombre, apellidos FROM usuarios ";
	private static final String SQL_SELECT_ID = 
			"SELECT id, dni, email, password, nombre, apellidos "+
			"FROM usuarios WHERE id=?";
	private static final String SQL_SELECT_EMAIL = 
			"SELECT id, dni, email, password, nombre, apellidos "+
			"FROM usuarios WHERE email=?";

	private final String url, user, password;
	
	
	
	public DAOUsuarioJDBC(String url, String user, String password) {
		super();
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		this.url = url;
		this.user = user;
		this.password = password;
	}

	@Override
	public void alta(Usuario usuario) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_INSERT);
			
			ps.setString(1, usuario.getDni());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getPassword());
			ps.setString(4, usuario.getNombre());
			ps.setString(5, usuario.getApellidos());
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new AccesoDatosException(
						"La inserción ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new AccesoDatosException(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new AccesoDatosException("Ha habido un error al cerrar", e);
			}
		}
	}

	@Override
	public void baja(Usuario usuario) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_DELETE);
			
			ps.setLong(1, usuario.getId());
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new AccesoDatosException(
						"El borrado ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new AccesoDatosException(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new AccesoDatosException("Ha habido un error al cerrar", e);
			}
		}
	}

	@Override
	public void modificacion(Usuario usuario) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_UPDATE);
			
			ps.setString(1, usuario.getDni());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getPassword());
			ps.setString(4, usuario.getNombre());
			ps.setString(5, usuario.getApellidos());
			ps.setLong(6, usuario.getId());
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new AccesoDatosException(
						"La actualizaci�n ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new AccesoDatosException(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new AccesoDatosException("Ha habido un error al cerrar", e);
			}
		}
	}

	@Override
	public Usuario[] obtenerUsuarios() {
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
						rs.getLong("id"),
						rs.getString("dni"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("nombre"),
						rs.getString("apellidos"));
				
				usuarios.add(u);
			}
			
			return usuarios.toArray(new Usuario[usuarios.size()]);
		} catch (SQLException e) {
			throw new AccesoDatosException(
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
				throw new AccesoDatosException("Ha habido un error al cerrar", e);
			}
		}
	}

	@Override
	public Usuario obtenerUsuarioPorId(long id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_SELECT_ID);
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			
			Usuario u;
			
			if(rs.next()) {
				u = new Usuario(
						rs.getLong("id"),
						rs.getString("dni"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("nombre"),
						rs.getString("apellidos"));
				
				return u;
			} 
			
			return null;
		} catch (SQLException e) {
			throw new AccesoDatosException(
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
				throw new AccesoDatosException("Ha habido un error al cerrar", e);
			}
		}
	}

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_SELECT_EMAIL);
			
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			Usuario u;
			
			if(rs.next()) {
				u = new Usuario(
						rs.getLong("id"),
						rs.getString("dni"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("nombre"),
						rs.getString("apellidos"));
				
				return u;
			} 
			
			return null;
		} catch (SQLException e) {
			throw new AccesoDatosException(
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
				throw new AccesoDatosException("Ha habido un error al cerrar", e);
			}
		}
	}

}
