package Empresa;

import java.sql.*;


public class Empresa {

	public static void main(String[] args) {
		String url="jdbc:sqlite:db\\Empresa.s3db";
		
		Connection con=null;
		Statement st=null;
		String nombre=null;
		String nombreNuevo=null;
		double precio=0;
		String apellido=null;
		String dni=null;
		
		try {
			con=DriverManager.getConnection(url);
			st=con.createStatement();
			
			
			System.out.println("Producto y trabajador insertados");
			System.out.println("------------------------");
			nombre = "Lavadora";
			precio = 20.4;
			insertarProducto(con,nombre,precio);
			
			
			nombre="Iker";
			apellido="Garcia";
			dni="78965831x";
			insertarTrabajador(con,nombre,apellido,dni);
			System.out.println("Producto:");
			mostrarRegistroProductos(st);
			System.out.println("Trabajador:");
			mostrarRegistrotrabajadores(st);
			
			
			
			System.out.println("Producto y trabajador modificados");
			System.out.println("------------------------");
			nombre="Lavadora";
			nombreNuevo="Sofa";
			modificarNombreProducto(con,nombre,nombreNuevo);
			
			nombre="Iker";
			nombreNuevo="Jon";
			modificarNombreTrabajador(con,nombre,nombreNuevo);
			System.out.println("Producto:");
			mostrarRegistroProductos(st);
			System.out.println("Trabajador:");
			mostrarRegistrotrabajadores(st);
			
			
			System.out.println("Producto y trabajador eliminados");
			System.out.println("------------------------");
			dni="78965831x";
			eliminarTrabajador(con,dni);
			nombre="Sofa";
			eliminarProducto(con,nombre);
			System.out.println("Producto:");
			mostrarRegistroProductos(st);
			System.out.println("Trabajador:");
			mostrarRegistrotrabajadores(st);
			
			
			
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			System.out.println(e.getMessage());
		}

	}
	
	

	private static void mostrarRegistroProductos(Statement st) throws SQLException {
		String sql = "SELECT * FROM productos";
		ResultSet rs = st.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();

		/*for (int i = 1; i <= rsmd.getColumnCount(); i++)
			System.out.print(rsmd.getColumnName(i) + "\t");
		*/
		System.out.println();

		while (rs.next())
			// System.out.println(rs.getString("usuario")+"\t"+rs.getString("pass"));
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.print(rs.getString(i) + "\t");
				if ((i + 1) % 4 == 0) {
					System.out.println("\n");
				}
			}	
		System.out.println();
		
	}
	private static void mostrarRegistrotrabajadores(Statement st) throws SQLException {
		String sql = "SELECT * FROM trabajadores";
		ResultSet rs = st.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();

		/*for (int i = 1; i <= rsmd.getColumnCount(); i++)
			System.out.print(rsmd.getColumnName(i) + "\t");
		*/
		System.out.println();

		while (rs.next())
			// System.out.println(rs.getString("usuario")+"\t"+rs.getString("pass"));
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				
				System.out.print(rs.getString(i) + "\t");
				if ((i + 1) % 5 == 0) {
					System.out.println("\n");
				}
			}	
		System.out.println();
		
	}
	


	private static void eliminarProducto(Connection con, String nombre) throws SQLException {
		String sql="DELETE FROM productos WHERE id=(SELECT id FROM productos WHERE nombre=?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, nombre);
		preparedStatement.executeUpdate();
	}

	private static void eliminarTrabajador(Connection con,String dni) throws SQLException {
		String sql="DELETE FROM trabajadores WHERE id=(SELECT id FROM trabajadores WHERE dni=?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, dni);
		preparedStatement.executeUpdate();
	}
	

	private static void modificarNombreTrabajador(Connection con,String nombre,String nombreNuevo) throws SQLException {
		String sql = "UPDATE trabajadores SET nombre= ? WHERE id=(SELECT id FROM trabajadores WHERE nombre=?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, nombreNuevo);
		preparedStatement.setString(2, nombre);
		preparedStatement.executeUpdate();
		
	}

	private static void modificarNombreProducto(Connection con,String nombre,String nombreNuevo) throws SQLException {
		String sql = "UPDATE productos SET nombre= ? WHERE id=(SELECT id FROM productos WHERE nombre=?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, nombreNuevo);
		preparedStatement.setString(2, nombre);
		preparedStatement.executeUpdate();
		
	}

	private static void insertarTrabajador(Connection con,String nombre,String apellido,String dni) throws SQLException {
		
		String sql="INSERT INTO trabajadores (nombre,apellido,dni) VALUES(?,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, nombre);
		preparedStatement.setString(2, apellido);
		preparedStatement.setString(3, dni);
		preparedStatement.executeUpdate();
		
	}

	private static void insertarProducto(Connection con,String nombre,double precio) throws SQLException {
		float preci= (float)precio;
		String sql = "INSERT INTO productos (nombre,precio) VALUES (?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, nombre);	
		preparedStatement.setFloat(2, preci);
		preparedStatement.executeUpdate();
	}

}
