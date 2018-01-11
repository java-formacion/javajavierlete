package db;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlite:src\\bd\\ex1.db";// obtenes direccion de la bd

		Connection con = null;// declarar el objeto conexion
		Statement st=null;
		try {
			con = DriverManager.getConnection(url);

			st = con.createStatement();

			mostrarRegistros(st);

			String usuario = "Unai";
			String pass = "Unaicon";
			String sql = "INSERT INTO usuarios (usuario,pass) VALUES('" + usuario + "','" + pass + "')";
			int numeroRegistrosModificados = st.executeUpdate(sql);
			System.out.println(numeroRegistrosModificados);
			mostrarRegistros(st);

			usuario = "Unai";
			pass = "Unaiconasd";
			sql = "UPDATE usuarios SET pass='" + pass + "' WHERE usuario='" + usuario + "'";
			numeroRegistrosModificados = st.executeUpdate(sql);
			System.out.println(numeroRegistrosModificados);
			mostrarRegistros(st);
		} catch (SQLException e) {
			System.out.println("Error al trabajar con la base de datos");
			System.out.println(e.getMessage());
		} finally {//siempre entra a esta parte se usa para CERRAR las conexiones...
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e2) {
					System.out.println("Error al cerrar el statement");
					System.out.println(e2.getMessage());
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					System.out.println("Error al Cerrar la base de datos");
					System.out.println(e2.getMessage());
				}
			}
			

		}

	}

	private static void mostrarRegistros(Statement st) throws SQLException {
		String sql = "SELECT * FROM usuarios";
		ResultSet rs = st.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();

		for (int i = 1; i <= rsmd.getColumnCount(); i++)
			System.out.print(rsmd.getColumnName(i) + "\t");

		System.out.println();

		while (rs.next())
			// System.out.println(rs.getString("usuario")+"\t"+rs.getString("pass"));
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
				System.out.print(rs.getString(i) + "\n");

		System.out.println();
	}
	
	

}
