import java.sql.*;

/*
 * SELECT nick, password FROM usuarios;
 * INSERT INTO usuarios (nick, password) VALUES ('pepe', 'contra');
 * UPDATE usuarios SET password='contra2' WHERE nick='pepe';
 * DELETE FROM usuarios WHERE nick='pepe';
 */

public class Main {
	private static PreparedStatement psSelect = null;
	
	public static void main(String[] args) {
		// System.out.println("C:\nuevos\trabajos");
		final String url = "jdbc:sqlite:bdd\\javierlete.db";
		// final String url = "jdbc:mysql://localhost:3306/ipartekjava";
		final String usuario = "root";
		final String password = "";

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = DriverManager.getConnection(url, usuario, password);

			String sql = "SELECT nick,pass FROM usuarios";
			
			psSelect = con.prepareStatement(sql);

			mostrarRegistros();
			
			String nick = "sqlite";
			String pass = "pass";
			sql = "INSERT INTO usuarios (nick, pass) VALUES (?, ?)";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, nick);
			pst.setString(2, pass);
			
			int numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros();

			pass = "nueva password";
			sql = "UPDATE usuarios SET pass=? WHERE nick=?";

			pst = con.prepareStatement(sql);
			
			pst.setString(2, nick);
			pst.setString(1, pass);
			
			numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros();

			sql = "DELETE FROM usuarios WHERE nick=?";

			pst = con.prepareStatement(sql);
			
			pst.setString(1, nick);
			
			numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros();			

		} catch (SQLException e) {

			System.out.println("Ha habido un error al trabajar con la base de datos");
			System.out.println(e.getMessage());
		} finally {
			if(pst != null)
				try {
					pst.close();
				} catch (SQLException e1) {
					System.out.println("Ha habido un problema al cerrar la sentencia");
				}
			
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("HA HABIDO UN ERROR AL CERRAR LA CONEXIÓN");
					System.out.println(e.getMessage());
				}
			
		}
		
//		System.out.println(Long.MIN_VALUE);
//		System.out.println(Long.MAX_VALUE);
//		System.out.println(Double.MIN_VALUE);
//		System.out.println(Double.MAX_VALUE);
	}
	
	private static void mostrarRegistros() throws SQLException {
		mostrarRegistros(psSelect);
	}

	private static void mostrarRegistros(PreparedStatement pst) throws SQLException {
		ResultSet rs = pst.executeQuery();

		ResultSetMetaData rsmd = rs.getMetaData();

		int numeroCampos = rsmd.getColumnCount();
		
		for (int i = 1; i <= numeroCampos; i++)
			System.out.print(rsmd.getColumnName(i) + "\t");

		System.out.println();

		while (rs.next()) {
			// System.out.println(
			// rs.getString("nick") + "\t" + rs.getString("pass"));

			for (int i = 1; i <= numeroCampos; i++)
				System.out.print(rs.getString(i) + "\t");

			System.out.println();
		}
	}

}
