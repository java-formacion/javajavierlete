package com.ipartek.maven.taller.AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import com.ipartek.maven.taller.entidades.Coche;
import com.ipartek.maven.taller.entidades.Mecanico;
import com.ipartek.maven.taller.entidades.Usuario;

public class tallerBD {
	// Acceso a la bd mysql

	private Connection con = null;
	private Statement st = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	
	//conexion
	public void CrearConexion() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller", "root", "root");
			st = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cerrarConexion() {
		try {
			if (con != null)
				con.close();
			if (con != null)
				st.close();
			if (ps != null)
				ps.close();
			if (st != null)
				st.close();
		} catch (SQLException e) {
			System.out.println("error al cerrar conexion");
			e.printStackTrace();
		}
	}

	
	
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

	
	//Coches
	
	public Coche[] obtenerCoche(int id) {
		ArrayList<Coche> coches = new ArrayList<Coche>();
		
		try {
			CrearConexion();
			rs = st.executeQuery("select * from coches where idCoche=?");
			ps.setInt(1, id);
			if (rs.next()) {
				Coche co = new Coche();
				co.setId(rs.getInt(1));
				co.setMarca(rs.getString(2));
				co.setModelo(rs.getString(3));
				co.setMatricula(rs.getString(4));
				coches.add(co);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			cerrarConexion();
		}
		return coches.toArray(new Coche[coches.size()]);
	}

	public int insertarCoche(Coche co, int idUsuario) {
		try {
			CrearConexion();
			ps = con.prepareStatement("INSERT INTO coches (marca,modelo,matricula,idUsuario) values (?,?,?,?)");
			ps.setString(1, co.getMarca());
			ps.setString(2, co.getModelo());
			ps.setString(3, co.getMatricula());
			ps.setInt(4, idUsuario);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}
	}

	public int eliminarCoche(int id) {
		try {
			CrearConexion();
			ps = con.prepareStatement("delete from coches where idCoche=?");
			ps.setInt(1, id);
			ps.executeQuery();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}
	}

	public int updateCoche(int id, Coche co) {
		try {
			CrearConexion();
			ps = con.prepareStatement("UPDATE coches SET marca=?, modelo=?, matricula=? WHERE idCoche=?");
			ps.setString(1, co.getModelo());
			ps.setString(2, co.getMarca());
			ps.setString(3, co.getMatricula());
			ps.setInt(4, id);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}
	}

	public int eliminarTodosLosCoches() {
		try {
			CrearConexion();
			ps = con.prepareStatement("delete from coches");
			ps.executeQuery();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}
	}
	
	public int obtenerIdCochePorMatricula(String matricula) {
		try {
			
				CrearConexion();
				String sql="select idCoche from coches where matricula=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, matricula);
				rs = ps.executeQuery();
				if (rs.next()) {
					int idCoche = rs.getInt(1);
					return idCoche;
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
	
	
	
	
	
	
	//Mecanicos
	
	public Mecanico[] obtenerMecanico(int id) {
		ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
		try {
			CrearConexion();
			rs = st.executeQuery("select * from mecanicos where idMecanico=?");
			ps.setInt(1, id);
			if (rs.next()) {
				Mecanico  me = new Mecanico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						obtenerCochesPorIdMecanico(rs.getInt(1)));
				mecanicos.add(me);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			cerrarConexion();
		}
		return mecanicos.toArray(new Mecanico[mecanicos.size()]);
	}

	public Mecanico[] obtenerTodosMecanico() {
		ArrayList<Mecanico> mecanicos= new ArrayList<Mecanico>();
		try {
			CrearConexion();
			rs = st.executeQuery("select * from mecanicos");
			while (rs.next()) {
				Mecanico me = new Mecanico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						obtenerCochesPorIdMecanico(rs.getInt(1)));
				mecanicos.add(me);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			cerrarConexion();
		}
		return mecanicos.toArray(new Mecanico[mecanicos.size()]);
	}
	
	public ArrayList<Coche> obtenerCochesPorIdMecanico(int id) {
		ArrayList<Coche> coches = new ArrayList<Coche>();
		try {
			CrearConexion();
			rs = st.executeQuery(
					"select * from coches where idCoche=(select coches.idCoche from coches_has_mecanicos where mecanicos.idMecanico=(SELECT idMecanico from mecanicos))");
			ps.setInt(1, id);
			while (rs.next()) {
				Coche co = new Coche(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						obtenerMecanicoPorIdCoche(rs.getInt(1)));
				coches.add(co);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			cerrarConexion();
		}
		return coches;
	}

	public ArrayList<Mecanico> obtenerMecanicoPorIdCoche(int id) {
		ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();

		try {
			CrearConexion();
			rs = st.executeQuery(
					"select * from mecanicos where idMecanico = (select mecanicos_idMecanido from coche_has_mecanicos where coches_idCoche = (select idCoche from coches))");
			ps.setInt(1, id);
			while (rs.next()) {
				Mecanico me = new Mecanico();
				me.setId(rs.getInt(0));
				me.setNombre(rs.getString(1));
				me.setApellidos(rs.getString(2));
				me.setDni(rs.getString(4));
				me.setTelefono(rs.getString(5));
				mecanicos.add(me);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			cerrarConexion();
		}
		return mecanicos;
	}

	public int insertarMecanicoPorObjeto(Mecanico me) {
		try {
			CrearConexion();
			ps = con.prepareStatement("INSERT INTO mecanicos (nombre,apellidos,dni,telefono) values (?,?,?,?)");
			ps.setString(1, me.getNombre());
			ps.setString(2, me.getApellidos());
			ps.setString(3, me.getDni());
			ps.setString(4, me.getTelefono());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}
	}

	public int eliminarMecanico(int id) {
		try {
			CrearConexion();
			ps = con.prepareStatement("delete from mecanicos where id=?");
			ps.setInt(1, id);
			ps.executeQuery();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}
	}

	public int updatearMecanico(int id, Mecanico me) {
		try {
			CrearConexion();
			ps = con.prepareStatement(
					"UPDATE mecanicos SET nombre=?, apellidos=?, dni=?, telefono=? WHERE idMecanico=?");
			ps.setString(1, me.getNombre());
			ps.setString(2, me.getApellidos());
			ps.setString(3, me.getDni());
			ps.setString(4, me.getTelefono());
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

	
	public int obtenerIdMecanicoPorDniMecanico(String dni) {
		try {
				CrearConexion();
				String sql="select idMecanico from mecanicos where dni=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, dni);
				rs = ps.executeQuery();
				if (rs.next()) {
					int idMecanico = rs.getInt(1);
					return idMecanico;
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

	
	
	
	
	//Tabla relacion
	public int insertarRelacionCocheMecanico(int idCoche,int idMecanico) {
		try {
				CrearConexion();
				ps = con.prepareStatement("INSERT INTO coches_has_mecanicos(coches_idCoche,mecanicos_idMecanico) values (?,?)");
				ps.setInt(1, idCoche);
				ps.setInt(2, idMecanico);
				ps.executeUpdate();
				return 1;
				
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			cerrarConexion();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
