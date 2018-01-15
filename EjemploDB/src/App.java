import java.sql.*;

public class App {
	
	public static void main(String[] args) {
		
		String url = "jdbc:sqlite:bbdd\\usuarios.db";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url);
			
			String sql = "SELECT u.nombre, r.rol FROM usuarios u\r\n" + 
							"INNER JOIN roles r on r.id_usuario = u.id\r\n" + 
							"GROUP BY r.id\r\n" + 
							"ORDER BY u.nombre DESC";
			
			rs = executeQuery(con, ps, sql);
			showResults(rs);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}	

	}

	public static ResultSet executeQuery(Connection con, PreparedStatement ps, String sql) {
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return rs;
	}
	
	private static void showResults(ResultSet rs) {
		
		try {
			
			ResultSetMetaData rsm = rs.getMetaData();
			
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				System.out.print(rsm.getColumnName(i).toUpperCase() + " | ");
			}
			
			System.out.print("\n\n");
			
			while(rs.next()) {
				for (int i = 1; i <= rsm.getColumnCount(); i++) {
					System.out.print(rs.getString(i) + "    ");
				}
				System.out.print("\n");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
