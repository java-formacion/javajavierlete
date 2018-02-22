package com.ipartek.maven.taller.AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.maven.taller.entidades.Usuario;

public class UsuarioBD extends ConexionBD{

	//usuario
	
	public int obtenerUsuarioPordni(String dni) {
		try {
				CrearConexion();
				String sql="select idUsuario from usuarios where dni=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, dni);
				rs = ps.executeQuery();
				if (rs.next()) {
					int idUsuario = rs.getInt(1);
					return idUsuario;
				} else {
					return 0;
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}

	}
	
	public int insertUsuario(Usuario usu) {
		try {
			if (!SiExisteUsuarioPasandoDni(usu.getDni())) {
				CrearConexion();
				ps = con.prepareStatement("INSERT INTO usuarios(nombre,apellidos,dni,telefono) values (?,?,?,?)");
				ps.setString(1, usu.getNombre());
				ps.setString(2, usu.getApellidos());
				ps.setString(3, usu.getDni());
				ps.setString(4, usu.getTelefono());
				ps.executeUpdate();
				return 0;
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
		} finally {
			cerrarConexion();
		}

	}

	public Usuario obtenerUsuario(int id) {

		Usuario usu = new Usuario();
		try {
			CrearConexion();
			rs = st.executeQuery("select * from usuarios where idUsuario=?");
			ps.setInt(1, id);
			if (rs.next()) {
				usu.setId(rs.getInt(1));
				usu.setNombre(rs.getString(2));
				usu.setApellidos(rs.getString(3));
				usu.setDni(rs.getString(4));
				usu.setTelefono(rs.getString(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			cerrarConexion();
		}
		return usu;
	}

	public int updateUsuario(int id, Usuario usu) {
		try {
			CrearConexion();
			ps = con.prepareStatement("UPDATE usuarios SET nombre=?, apellidos=?, dni=?,telefono=? WHERE idUsuario=?");
			ps.setString(1, usu.getNombre());
			ps.setString(2, usu.getApellidos());
			ps.setString(3, usu.getDni());
			ps.setString(4, usu.getTelefono());
			ps.setInt(5, id);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}
	}

	public Usuario[] obtenerUsuarios() {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			CrearConexion();
			String query = "select * from usuarios";
			st = con.createStatement();

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Usuario usu = new Usuario();
				usu.setId(rs.getInt(1));
				usu.setNombre(rs.getString(2));
				usu.setApellidos(rs.getString(3));
				usu.setDni(rs.getString(4));
				usu.setTelefono(rs.getString(5));
				usuarios.add(usu);
			}
			return usuarios.toArray(new Usuario[usuarios.size()]);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			cerrarConexion();
		}
		return null;

	}

	public int eliminarUsuario(int id) {
		try {
			CrearConexion();
			ps = con.prepareStatement("delete from usuarios where idUsuario=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}
	}

	public boolean SiExisteUsuarioPasandoDni(String dni) {
		try {
			CrearConexion();
			String sql="select idUsuario from usuarios where dni=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dni);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			cerrarConexion();
		}
		return false;
	}

}
