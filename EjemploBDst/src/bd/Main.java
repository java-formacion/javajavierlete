package bd;

import java.sql.*;

//TODO
public class Main {

	public static void main(String[] args) {
		
		final String url = "jdbc:sqlite:bdd\\ex1.db";
		
		Connection con = null;
		Statement st = null;
		String nombre=null;
		String nombreNasdf=null;
		String apellidos=null;
		String dni=null;
		double precio=0;
		
		try {
			con=DriverManager.getConnection(url);
			st = con.createStatement();
			
			nombre = "Manolo";
			apellidos="Garcia";
			dni="78964251n";
			insertarTrabajador(con, nombre, apellidos, dni);
			nombre="Lavadora";
			precio=5.5;
			insertarProducto(con, nombre, precio);
			mostrarTrabajadores(st);
			mostrarProductos(st);
			System.out.println("Insertamos el trabajador y el producto:");
			espacio();
			
			
			nombreNasdf="Iker";
			nombre="Manolo";
			modificarNombreTrabajador(con, st, nombreNasdf,nombre);
			mostrarTrabajadores(st);
			System.out.println("Nombre del trabajador modificado");
			espacio();
			
			
			EliminarTrabajadorPorNombre(con, nombreNasdf);
			mostrarTrabajadores(st);
			System.out.println("Trabajador eliminado");
			espacio();
			
			
			
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			System.out.println(e.getMessage());
		}
		

	}
	private static void EliminarTrabajadorPorNombre(Connection con, String nombreN) throws SQLException {
		String updateTableSQL = "DELETE FROM trabajadores WHERE id=(SELECT id FROM trabajadores WHERE nombre=?)";
		PreparedStatement preparedStatement = con.prepareStatement(updateTableSQL);
		preparedStatement.setString(1, nombreN);
		preparedStatement .executeUpdate();
	}
	private static void espacio() {
		System.out.println();
		System.out.println("------------------");
		System.out.println();
	}
	private static void modificarNombreTrabajador(Connection con, Statement st, String nombreN, String nombre) throws SQLException {
		String updateTableSQL = "UPDATE trabajadores SET nombre=? WHERE nombre=?";
		PreparedStatement preparedStatement = con.prepareStatement(updateTableSQL);
		preparedStatement.setString(1, nombreN);
		preparedStatement.setString(2, nombre);
		preparedStatement.executeUpdate();
	}
	
	
	private static void mostrarProductos(Statement st) throws SQLException {
		String sql = "SELECT * FROM Productos";
		mostrarProductos(st, sql);
	}

	private static void mostrarProductos(Statement st, String sql) throws SQLException {
		ResultSet rs = st.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();

		for (int i = 1; i <= rsmd.getColumnCount(); i++)
			System.out.print(rsmd.getColumnName(i) + "\t");

		System.out.println();

		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
				System.out.print(rs.getString(i) + "\t");

			System.out.println();
		}
		System.out.println();
	}
	
	private static void mostrarTrabajadores(Statement st) throws SQLException {
		String sql = "SELECT * FROM trabajadores";
		mostrarTrabajadores(st, sql);
		System.out.println();
	}

	private static void mostrarTrabajadores(Statement st, String sql) throws SQLException {
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

	private static void insertarProducto(Connection con, String nombre, double precio) throws SQLException {
		String sql = "INSERT INTO Productos (nombre,precio) VALUES (?,?)";

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, nombre);
		pst.setDouble(2, precio);

		int numeroRegistrosModificados = pst.executeUpdate();
		System.out.println(numeroRegistrosModificados);
	}

	private static void insertarTrabajador(Connection con, String nombre, String apellidos, String dni)
			throws SQLException {
		String sql = "INSERT INTO trabajadores (nombre, apellidos, dni) VALUES (?, ?, ?)";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setString(1, nombre);
		pst.setString(2, apellidos);
		pst.setString(3, dni);

		int numeroRegistrosModificados = pst.executeUpdate();
		System.out.println(numeroRegistrosModificados);
	}

}
