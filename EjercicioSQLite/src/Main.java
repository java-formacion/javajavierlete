import java.sql.*;

public class Main {

	private static PreparedStatement pst = null;

	public static void main(String[] args) {

		final String url = "jdbc:sqlite:bbdd\\tienda.s3db";
		final String usuario = "root";
		final String password = "";

		Connection con = null;
		Statement st = null;

		try {

			con = DriverManager.getConnection(url, usuario, password);

			String sql = "SELECT nombre, descripcion, precio, stock FROM productos";
			pst = con.prepareStatement(sql);
			mostrarRegistros();

			String nombre = "Movil";
			String descripcion = "iPhone";
			double precio = 1200.50;
			int stock = 50;
			sql = "INSERT INTO productos (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, nombre);
			pst.setString(2, descripcion);
			pst.setDouble(3, precio);
			pst.setInt(4, stock);

			int numeroRegistrosModificados = pst.executeUpdate();
			System.out.println(numeroRegistrosModificados);
			mostrarRegistros();

			precio = 1420.75;
			sql = "UPDATE productos SET precio=? WHERE descripcion=?";

			pst = con.prepareStatement(sql);

			pst.setDouble(1, precio);
			pst.setString(2, descripcion);

			numeroRegistrosModificados = pst.executeUpdate();
			System.out.println(numeroRegistrosModificados);
			mostrarRegistros();

			sql = "DELETE FROM productos WHERE descripcion=?";

			pst = con.prepareStatement(sql);

			pst.setString(1, descripcion);

			numeroRegistrosModificados = pst.executeUpdate();
			System.out.println(numeroRegistrosModificados);
			mostrarRegistros();

		} catch (SQLException e) {

			System.out.println("Ha habido un error al trabajar con la base de datos");
			System.out.println(e.getMessage());

		} finally {

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("HA HABIDO UN ERROR AL CERRAR LA CONEXIÓN");
					System.out.println(e);
				}
			}
		}
	}

	private static void mostrarRegistros() throws SQLException {

		mostrarRegistros(pst);

	}

	private static void mostrarRegistros(PreparedStatement pst) throws SQLException {

		ResultSet rs = pst.executeQuery();

		ResultSetMetaData rsmd = rs.getMetaData();

		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i) + "\t");
		}
		System.out.println();

		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}

	}

}
