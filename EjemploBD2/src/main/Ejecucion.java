package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejecucion {

	public static void main(String[] args) throws SQLException {
		
		//primero creamos la conexion
		String url = "jdbc:sqlite:bbdd\\ex1.db";
		Connection con = null;
		Statement st = null;
		PreparedStatement pstm = null;
		
		try {
			con = DriverManager.getConnection(url);

			st = con.createStatement();
			

			mostrarProductos(st);

			
			
			
			String nombre = "platano";
			String descripcion = "Esto es una platano";
			int precio = 7;
			int stock = 30;
			
			
			
			String sql = "INSERT INTO productos (nombre, descripcion, precio, stock) VALUES (?,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nombre);
			pstm.setString(2, descripcion);
			pstm.setInt(3, precio);
			pstm.setInt(4, stock);
			
			int numeroRegistrosModificados = pstm.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarProductos(st);

			precio = 8;
			stock = 25;
			sql = "UPDATE productos SET precio=?,stock=? WHERE nombre= ?";

			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, precio);
			pstm.setInt(2, stock);
			pstm.setString(3, nombre);
			numeroRegistrosModificados = pstm.executeUpdate();
			
			System.out.println(numeroRegistrosModificados);

			mostrarProductos(st);

			sql = "DELETE FROM productos WHERE nombre=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nombre);
			numeroRegistrosModificados = pstm.executeUpdate();
			

			System.out.println(numeroRegistrosModificados);

			mostrarProductos(st);
		} catch (SQLException e) {

			System.out.println("Ha habido un error al trabajar con la base de datos");
			System.out.println(e.getMessage());
		} finally {
			if(st != null)
				try {
					st.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("HA HABIDO UN ERROR AL CERRAR LA CONEXIÓN");
					System.out.println(e);
				}

	}

}
	
	
	
private static void mostrarProductos(Statement st) throws SQLException{
	String sql="SELECT * FROM productos";
	
	mostrarRegistros(sql, st);
	
}


private static void mostrarRegistros(String sql,Statement st) throws SQLException {
	
	
	
	
	ResultSet rs = st.executeQuery(sql);
	
	ResultSetMetaData rsmd = rs.getMetaData();

	
	for (int i = 1; i <=rsmd.getColumnCount(); i++) {
		
		System.out.print(rsmd.getColumnName(i)+ "  ");
	}
	System.out.println();
	while(rs.next()) {
		
		for (int i = 1; i <=rsmd.getColumnCount(); i++) {
			
			System.out.print(rs.getString(i)+ "  ");
		}
		System.out.println();
	}
}
}

