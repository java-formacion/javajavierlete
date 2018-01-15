package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.*;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DAOUsuarioJDBC implements DAOUusuario{

	private static final String SQL_INSERT = "INSERT INTO Usuario(dni,email,password,nombre,apellidos VALUES (?,?,?,?,?,?))";
	private final String url;
	
	public DAOUsuarioJDBC(String url) {
		this.url = url;
	}
	
	@Override
	public void alta(Usuario usuario) {
		
		Connection con =null;
		PreparedStatement ps=null;
		try {
			con = DriverManager.getConnection(url);
			ps = con.prepareStatement(SQL_INSERT);
			ps.setString(1, usuario.getDni());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getPassword());
			ps.setString(4, usuario.getNombre());
			ps.setString(5, usuario.getApellido());
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new AccesoDatosExcepcion("La insercion a devuelto un resultado diferente");
			
			
		} catch (SQLException e) {
			throw new AccesoDatosExcepcion(
					"Error al acceder a la base de datos",e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUsuariosPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUsuariosPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
