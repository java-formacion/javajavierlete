import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		//System.out.println("C:\nuevos\trabajos");
		final String url = "jdbc:sqlite:bdd\\javierlete.db";
		//final String url = "jdbc:mysql://localhost:3306/ipartekjava";
		final String usuario = "root";
		final String password = "";
		
		Connection con;
		con = DriverManager.getConnection(url, usuario, password);
		
		Statement st = con.createStatement();
		
		String sql = "SELECT nick,pass FROM usuarios";
		
		ResultSet rs = st.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		for(int i = 1; i <= rsmd.getColumnCount(); i++)
			System.out.print(rsmd.getColumnName(i) + "\t");
		
		System.out.println();
		
		while(rs.next()) {
			//System.out.println(
			//		rs.getString("nick") + "\t" + rs.getString("pass"));
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				System.out.print(rs.getString(i) + "\t");
			
			System.out.println();
		}
	}

}
