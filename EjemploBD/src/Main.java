import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// System.out.println("C:\nuevos\trabajos");
		final String url = "jdbc:sqlite:bdd\\javierlete.db";
		// final String url = "jdbc:mysql://localhost:3306/ipartekjava";
		final String usuario = "root";
		final String password = "";

		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection(url, usuario, password);

			st = con.createStatement();

			mostrarRegistros(st);

			String nick = "sqlite";
			String pass = "pass";
			String sql = "INSERT INTO usuarios (nick, pass) VALUES ('" + nick + "', '" + pass + "')";

			int numeroRegistrosModificados = st.executeUpdate(sql);

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros(st);

			pass = "nueva password";
			sql = "UPDATE usuarios SET pass='" + pass + "' WHERE nick='" + nick + "'";

			numeroRegistrosModificados = st.executeUpdate(sql);

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros(st);

			sql = "DELETE FROM usuarios WHERE nick='" + nick + "'";

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

	private static void mostrarRegistros(Statement st) throws SQLException {
		String sql = "SELECT nick,pass FROM usuarios";

		ResultSet rs = st.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();

		for (int i = 1; i <= rsmd.getColumnCount(); i++)
			System.out.print(rsmd.getColumnName(i) + "\t");

		System.out.println();

		while (rs.next()) {
			// System.out.println(
			// rs.getString("nick") + "\t" + rs.getString("pass"));

			for (int i = 1; i <= rsmd.getColumnCount(); i++)
				System.out.print(rs.getString(i) + "\t");

			System.out.println();
		}
	}

}
