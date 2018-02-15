package com.ipartek.jersey.pruebaJersey;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.jersey.pruebaJersey.*;

public class AccesoRest{

	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs=null;
	
	static final String SQL_INSERT = 
			"INSERT INTO usuarios " +
			"(?,nombre, apellidos, telefono, dni) " +
			"VALUES ( ?, ?, ?, ?, ?)";
	static final String SQL_UPDATE =
			"UPDATE usuarios SET "+
			"nombre=?, apellidos=?, telefono=?, dni=? "+
			"WHERE dni=?";
	static final String SQL_DELETE =
			"DELETE FROM usuarios WHERE id=?";
	
	static final String SQL_SELECT = 
			"SELECT id, nombre, apellidos, telefono, dni FROM usuarios ";
	
	
	public void abrirConexion() {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection("C:\\BDD\\usuarios.s3db", "", "");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void cerrarConexion(Connection con,PreparedStatement ps) {
		try {
			if(ps != null)
				ps.close();
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario obtenerUsuario(Usuario usu) {
		
		abrirConexion();
		try {
			ps = con.prepareStatement(SQL_SELECT);
			ps.setInt(1, usu.getId());
			 rs = ps.executeQuery();

			if (rs.next()) {
				Usuario usu1=new Usuario();
				usu1.setId(rs.getInt(0));
				usu1.setNombre(rs.getString(1));
				usu1.setApellidos(rs.getString(3));
				usu1.setTelefono(rs.getInt(4));
				usu1.setDni(rs.getString(5));
				return usu1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
