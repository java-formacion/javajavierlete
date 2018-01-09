package db;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlite:C:\\Users\\Java\\Documents\\sqlite-tools-win32-x86-3210000\\ex1.db";//obtenes direccion de la bd
		
		Connection con;//declarar el objeto conexion
		
		con = DriverManager.getConnection(url);

		Statement st = con.createStatement();

		String sql = "SELECT * FROM usuarios";
		ResultSet rs = st.executeQuery(sql);
		
		ResultSetMetaData rsmd= rs.getMetaData();
		
		for(int i=1; i<=rsmd.getColumnCount(); i++)
			System.out.print(rsmd.getColumnName(i)+"\t");
		
		System.out.println();
		
		
		while(rs.next())
			//System.out.println(rs.getString("usuario")+"\t"+rs.getString("pass"));
			for (int i = 1; i <= rsmd.getColumnCount(); i++) 
				System.out.print(rs.getString(i)+"\n");
			
			System.out.println();
	}

}
