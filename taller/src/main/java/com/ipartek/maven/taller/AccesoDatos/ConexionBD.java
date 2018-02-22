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

public class ConexionBD {
	// Acceso a la bd mysql

	protected Connection con = null;
	protected Statement st = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	
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

	
	
}
