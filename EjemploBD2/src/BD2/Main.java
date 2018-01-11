package BD2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		final String url = "jdbc:sqlite:C:\\desarrollo redes\\sqlite-tools-win32-x86-3210000\\Productos.s3db";
		// final String url = "jdbc:mysql://localhost:3306/ipartekjava";
		final String usuario = "root";
		final String stockword = "";

		// connection y statement son interfaces
		Connection con = null;
		Statement st = null;

		try {
			// conectamos con la BD y la visualizamos
			con = DriverManager.getConnection(url, usuario, stockword);
			st = con.createStatement();

			mostrarRegistros(st);

			// añadimos linea y la vemos
			String nombre = "Manzana";
			String stock = "86";
			String sql = "INSERT INTO Productos (nombre, stock) VALUES (?, ?)";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, nombre);
			pst.setString(2, stock);

			int numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros(st);
			// modificamo parte de una línea y lo vemos
			stock = "1";

			// codigo en sql
			// UPDATE Productos SET pass = 'nueva stockword' WHERE nombre ='Manzanas'
			// asi es mas complejo
			// sql = "UPDATE Productos SET stock='" + stock + "' WHERE nombre='" + nombre +
			// "'";
			// la mejor forma de pasarselo a java
			sql = "UPDATE Productos SET stock = ? WHERE nombre = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, stock);
			pst.setString(2, nombre);

			numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros(st);

			// eliminamos una linea
			// codigo en sql
			// DELETE FROM Productos WHERE nick ='Manzana';
			// asi es mas complejo
			// sql = "DELETE FROM Productos WHERE nombre='" + nombre + "'";
			// la mejor forma de pasarselo a java

			sql = "DELETE FROM Productos WHERE nombre =?";
			pst = con.prepareStatement(sql);
			pst.setString(1, nombre);

			numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros(st);

			// nombre = "Pepino'; DELETE FROM Productos WHERE nombre LIKE 'Pera";
			// SELECT*FROM Productos WHERE nombre LIKE 'Pera'
			nombre = "Pera";

			sql = "SELECT * FROM Productos WHERE nombre=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, nombre);

			mostrarRegistros(sql, st);

		} catch (SQLException e) {

			System.out.println("Ha habido un error al trabajar con la base de datos");
			System.out.println(e.getMessage());
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e1) {

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

		String sql = "SELECT id,nombre,stock FROM Productos";

		mostrarRegistros(sql, st);
	}

	private static void mostrarRegistros(String sql, Statement st) throws SQLException {
		ResultSet rs = st.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();

		for (int i = 1; i <= rsmd.getColumnCount(); i++)
			System.out.print(rsmd.getColumnName(i) + "\t");

		System.out.println();

		while (rs.next()) {
			// System.out.println(
			// rs.getString("nombre") + "\t" + rs.getString("stock"));

			for (int i = 1; i <= rsmd.getColumnCount(); i++)
				System.out.print(rs.getString(i) + "\t");

			System.out.println();
		}
	}

}