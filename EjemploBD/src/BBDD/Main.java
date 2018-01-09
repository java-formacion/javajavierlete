package BBDD;
import java.sql.*;
import java.util.Iterator;



public class Main {

	public static void main(String[] args) {
		
		String url = "jdbc:sqlite:C:\\desarrolloRedes\\javajavierlete\\EjemploBD\\BBDD\\ex1.db";
		Connection con;
		try {
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql="SELECT * FROM tbl1";
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
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
