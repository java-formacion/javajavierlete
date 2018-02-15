package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;

public class daousuarioArray extends daoUsuarioJDBC{
	
	
	public int anadiUsuario(Usuario usu) {
		
		abrirConexion();
		try {
			ps=con.prepareStatement(SQL_INSERT);
			ps.setString(2, usu.getNombre());
			ps.setString(3, usu.getApellidos());
			ps.setInt(4, usu.getTel());
			ps.setString(5, usu.getDni());
			ps.executeUpdate();
			cerrarConexion(con, ps);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			cerrarConexion(con, ps);
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public int eliminarUsuario(int id) {
		abrirConexion();
		try {
			ps=con.prepareStatement(SQL_DELETE);
			ps.setInt(1, id);
			ps.executeUpdate();
			cerrarConexion(con, ps);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			cerrarConexion(con, ps);
			e.printStackTrace();
			return -1;
		}
	}
	
	/*public Usuario[] getUsuarios() {
		List<Usuario> usuarios = daoUsuario.get
	}*/
	
	

}
