package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.*;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DAOUsuarioJDBC implements DAOUsuario {

	private static final String SQL_INSERT = 
			"INSERT INTO usuarios " +
			"(dni, email, password, nombre, apellidos)" +
			"VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_SELECT = 
			"SELECT id, dni, email, password, nombre, apellidos FROM usuarios ";
	private final String url;
	
	public DAOUsuarioJDBC(String url) {
		this.url = url;
	}
	
	@Override
	public void alta(Usuario usuario) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url);
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificacion(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario[] obtenerUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url);
			
			ps = con.prepareStatement(SQL_SELECT);
			
			rs = ps.executeQuery();
			
			Usuario u;
			
			while(rs.next()) {
				u = new Usuario(
						rs.getInt("id"),
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
