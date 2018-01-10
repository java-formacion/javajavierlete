
//llamada a java sql para la modificacion de bases de datos SQL
import java.sql.*;

/**
 * Hacer un ejercicio con los comandos equivalentes a estas lineas:
 * 
 * SELECT nick, password FROM usuarios;
 * INSERT INTO usuarios (nick, password) VALUES ('pepe', 'contra');
 * UPDATE usuarios SET password='contra2' WHERE nick='pepe';
 * DELETE FROM usuarios WHERE nick='pepe';
 * 
 * @author java
 *
 */

public class Main {

	private static PreparedStatement pst = null;

	public static void main(String[] args) {
		// System.out.println("C:\nuevos\trabajos");

		// llamada al comando de sqlite para abrir el DB dentro de la carpeta DB
		final String url = "jdbc:sqlite:DB\\PRUEBA.s3db";
		// final String url = "jdbc:mysql://localhost:3306/ipartekjava";

		// Se le da un valor para un usuario y contraseña para la modificacion de los
		// datos
		final String usuario = "root";
		final String password = "";

		Connection con = null;
		Statement st = null;

		try {
			// llamada al DriverManager que esta dentro del java.sql
			con = DriverManager.getConnection(url, usuario, password);

			//llamada a consola para que muestre lo que hay en la tabla
			String sql = "SELECT id,nombre,descripcion,stock,precio FROM productos";

			pst = con.prepareStatement(sql);

			mostrarRegistros();

			//Declaracion de las variables que haran de campos de nombre de las tablas
			String nombre = "Pan";
			String descripcion = "Pacomer";
			int cantidad = 6;
			double precio = 1.1;
			
			
			//Se crea una plantilla "segura" para evitar modificaciones no preparadas
			sql = "INSERT INTO Productos (Nombre,Descripcion,Stock,Precio) VALUES (?, ?, ?, ?)";
			//lo que ponga dentro de sql sera lo que vaya a ir a la consola dentro del programa de sql
			
			
			
			PreparedStatement pst = con.prepareStatement(sql);

			//se declaran las 4 variables de la plantilla
			pst.setString(1, nombre);
			pst.setString(2, descripcion);
			pst.setInt(3, cantidad);
			pst.setDouble(4, precio);

			int numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros();

			
			descripcion = "Muy rico";
			
			//declaracion del mensaje de sql
			sql = "UPDATE productos SET descripcion=? WHERE nombre=?";

			//inicio de llamada
			pst = con.prepareStatement(sql);

			pst.setString(1, descripcion);
			pst.setString(2, nombre);
			//fin de la llamada

			//ejecuta la llamada para actualizar los campos
			numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros();

			//llamada SQL para borrar la linea
			sql = "DELETE FROM prueba WHERE nombre=?";

			pst = con.prepareStatement(sql);

			pst.setString(1, nombre);

			numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			mostrarRegistros();

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

	private static void mostrarRegistros() throws SQLException {
		mostrarRegistros(pst);
	}

	private static void mostrarRegistros(PreparedStatement pst) throws SQLException {
		ResultSet rs = pst.executeQuery();

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