package BBDD;
import java.sql.*;
import java.util.Iterator;



public class Main {

	public static void main(String[] args) throws SQLException{
		
		String url = "jdbc:sqlite:BBDD\\ex1.db";
		Connection con;
		
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql="SELECT * FROM tbl1";
			ResultSet rs = st.executeQuery(sql);
			
			mostrarRegistros(rs);
			
			
			
			
			
			
			}

	private static void mostrarRegistros(ResultSet rs) throws SQLException {
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
	
	
	
	
	
	
