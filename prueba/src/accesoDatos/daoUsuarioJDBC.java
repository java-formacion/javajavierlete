package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import java.sql.PreparedStatement;

import entidades.Usuario;

public class daoUsuarioJDBC{
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
	
	/*public ArrayList<Usuario> getUsuarios(){
		abrirConexion();
		try {
			ps=con.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/


	public void modificacion(Usuario usuario) {
		
		
	}
	
}
