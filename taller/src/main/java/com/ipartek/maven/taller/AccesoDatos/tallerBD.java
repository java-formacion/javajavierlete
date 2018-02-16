package com.ipartek.maven.taller.AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.maven.taller.entidades.Coche;
import com.ipartek.maven.taller.entidades.Mecanico;
import com.ipartek.maven.taller.entidades.Usuario;

public class tallerBD {
//Acceso a la bd mysql
	
	private Connection con=null;
	private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public void CrearConexion() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
	                "user=minty&password=greatsqldb");
			st = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cerrarConexion() {
		try {
			con.close();
			st.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("error al cerrar conexion");
			e.printStackTrace();
		}
	}
	
	
	public int insertUsuario(Usuario usu) {
		try {
			CrearConexion();
			ps= con.prepareStatement("INSERT INTO usuarios values (?,?,?,?)");
			ps.setString(1, usu.getNombre());
			ps.setString(2, usu.getApellidos());
			ps.setString(3, usu.getDni());
			ps.setString(4, usu.getTelefono());
			ps.executeQuery();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			cerrarConexion();
		}
		
	}
	
	public Usuario obtenerUsuario(int id) {
		
		Usuario usu=new Usuario();
		try {
			CrearConexion();
			rs = st.executeQuery("select * from usuarios where id=?");
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
			
		}finally {
			cerrarConexion();
		}
		return usu;
	}
	
	public int eliminarUsuario(int id) {
		try {
			CrearConexion();
			ps= con.prepareStatement("delete from usuarios where id=?");
			ps.setInt(1, id);
			ps.executeQuery();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally {
			cerrarConexion();
		}
	}
	
	public int updateUsuario(int id,Usuario usu) {
		try {
			CrearConexion();
			ps = con.prepareStatement("UPDATE usuarios SET nombre=?, apellidos=?, dni=?,telefono=? WHERE id=?");
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
		}finally {
			cerrarConexion();
		}
	}
	
	public Coche obtenerCoche(int id) {
		Coche co = new Coche();
		try {
			CrearConexion();
			rs = st.executeQuery("select * from coches where id=?");
			ps.setInt(1, id);
			if (rs.next()) {
				co.setId(rs.getInt(1));
				co.setMarca(rs.getString(2));
				co.setModelo(rs.getString(3));
				co.setMatricula(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			cerrarConexion();
		}
		return co;
	}

	public int insertarCoche(Coche co) {
		try {
			CrearConexion();
			ps= con.prepareStatement("INSERT INTO coches values (?,?,?)");
			ps.setString(1, co.getMarca());
			ps.setString(2, co.getModelo());
			ps.setString(3, co.getMatricula());
			ps.executeQuery();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			cerrarConexion();
		}
	}

	public int eliminarCoche(int id) {
		try {
			CrearConexion();
			ps= con.prepareStatement("delete from coches where id=?");
			ps.setInt(1, id);
			ps.executeQuery();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally {
			cerrarConexion();
		}
	}

	public int updateCoche(int id,Coche co) {
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
		}finally {
			cerrarConexion();
		}
	}

	public Mecanico obtenerMecanico(int id) {
		Mecanico me=null;
		try {
			CrearConexion();
			rs = st.executeQuery("select * from mecanicos where idMecanico=?");
			ps.setInt(1, id);
			if (rs.next()) {
				me = new Mecanico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), obtenerCochesPorIdMecanico(rs.getInt(1)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			cerrarConexion();
		}
		return me;
	}

	public ArrayList<Coche> obtenerCochesPorIdMecanico(int id){
		ArrayList<Coche> coches = new ArrayList<Coche>();
		try {
			CrearConexion();
			rs = st.executeQuery("select * from coches where idCoche=(select coches.idCoche from coches_has_mecanicos where mecanicos.idMecanico=(SELECT idMecanico from mecanicos))");
			ps.setInt(1, id);
			while (rs.next()) {
				Coche co = new Coche(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), obtenerMecanicoPorIdCoche(rs.getInt(1)));
				coches.add(co);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			cerrarConexion();
		}
		return coches;
	}
	
	
	public ArrayList<Mecanico> obtenerMecanicoPorIdCoche(int id){
		ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
		
		try {
			CrearConexion();
			rs = st.executeQuery("select * from mecanicos where idMecanico = (select mecanicos_idMecanido from coche_has_mecanicos where coches_idCoche = (select idCoche from coches))");
			ps.setInt(1, id);
			while (rs.next()) {
				Mecanico me=new Mecanico();
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
			
		}finally {
			cerrarConexion();
		}
		return mecanicos;
	}

	public int insertarMecanicoPorObjeto(Mecanico me) {
		try {
			CrearConexion();
			ps= con.prepareStatement("INSERT INTO mecanicos values (?,?,?,?)");
			ps.setString(1, me.getNombre());
			ps.setString(2, me.getApellidos());
			ps.setString(3, me.getDni());
			ps.setString(3, me.getTelefono());
			ps.executeQuery();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			cerrarConexion();
		}
	}

	public int eliminarMecanico(int id) {
		try {
			CrearConexion();
			ps= con.prepareStatement("delete from mecanicos where id=?");
			ps.setInt(1, id);
			ps.executeQuery();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally {
			cerrarConexion();
		}
	}

	public int updatearMecanico(int id,Mecanico me) {
		try {
			CrearConexion();
			ps = con.prepareStatement("UPDATE mecanicos SET nombre=?, apellidos=?, dni=? WHERE telefono=?");
			ps.setString(1, me.getNombre());
			ps.setString(2, me.getApellidos());
			ps.setString(3, me.getDni());
			ps.setString(4, me.getTelefono());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			cerrarConexion();
		}
	}

}
