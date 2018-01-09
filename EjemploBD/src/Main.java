import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		//System.out.println("C:\nuevos\trabajos");
		String url = "jdbc:sqlite:C:\\Users\\javierlete\\git\\javajavierlete\\EjemploBD\\bdd\\javierlete.db";
		
		Connection con;
		con = DriverManager.getConnection(url);
		
		Statement st = con.createStatement();
		
		String sql = "SELECT pass,nick FROM usuarios";
		
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
