import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String url = "jdbc:sqlite:C:\\desarrolloRedes\\EjemploDB\\DB\\ex1.db";
		
		Connection con;
		con = DriverManager.getConnection(url);
		
		Statement st = con.createStatement();
		
		String sql = "SELECT * FROM usuarios";
		
		ResultSet rs = st.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		for(int i =1; i<=rsmd.getColumnCount();i++)
			System.out.println(rsmd.getColumnName(i)+"\t");
		
		System.out.println();
		
		while(rs.next()) {
			
		System.out.println(rs.getString("nick")+"\t"+rs.getString("pass"));
	
		for(int i = 1 ; i <= rsmd.getColumnCount();i++)
			System.out.println(rs.getString(i)+"\t");
		}
	}

}
