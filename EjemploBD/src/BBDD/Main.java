package BBDD;
import java.sql.*;
import java.util.Iterator;



public class Main {

	public static void main(String[] args) throws SQLException{
		
		String url = "jdbc:sqlite:BBDD\\ex1.db";
		Connection con = null;
		Statement st = null;
		PreparedStatement pstm = null;
		
		
		try {
			con = DriverManager.getConnection(url);

			st = con.createStatement();
			

			mostrarRegistros(st);

			
			
			
			String nick = "sqlite";
			String pass = "pass";
			
			
			String sql = "INSERT INTO usuarios (usuario, pass) VALUES (?,?)";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nick);
			pstm.setString(2, pass);
			
			int numeroRegistrosModificados = pstm.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros(st);

			pass = "nueva password";
			sql = "UPDATE usuarios SET pass='" + pass + "' WHERE usuario='" + nick + "'";

			numeroRegistrosModificados = st.executeUpdate(sql);

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros(st);

			sql = "DELETE FROM usuarios WHERE usuario='" + nick + "'";

			numeroRegistrosModificados = st.executeUpdate(sql);

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros(st);
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

	
	
	private static void mostrarRegistros(Statement st) throws SQLException{
		String sql="SELECT * FROM usuarios";
		
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
	
	
	
	
	
	
