package com.ipartek.formacion.capas.accesoadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DaoUsuarioJDBC implements DaoUsuario{

	private static final String SQL_INSERT = "INSERT INTO Usuarios (dni, email, password, nombre, apellido)" + 
													"values (?,?,?,?,?))";
	private final String url;
	
	
	public DaoUsuarioJDBC(String url) {
		super();
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
			ps.setString(5, usuario.getApellido());
			
			int num = ps.executeUpdate();
			
			if ( num != 1)
				throw new AccesoDatosException("La insercion a devuelto un resultado diferente");
		} catch (SQLException e) {
			
			throw new AccesoDatosException("Error al acceder a la base de datos",e);
			
		}finally {
			
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
					
			}catch (SQLException e) {
				throw new AccesoDatosException("Error al cerrar",e);
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
