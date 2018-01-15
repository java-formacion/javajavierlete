package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.*;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public class DAOProductoJDBC implements DAOProducto {
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, descripcion, precio) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, descripcion=?, precio=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";
	private static final String SQL_SELECT ="SELECT nombre, descripcion, precio FROM productos";
	String url;

	@Override
	public void alta(Producto producto) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url);
			ps = con.prepareStatement(SQL_INSERT);
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDescripcion());
			ps.setBigDecimal(3, producto.getPrecio());
			int num = ps.executeUpdate();
			if (num != 1) {
				throw new AccesoDatosException("La inserción ha devuelto un resultado diferente de 1");
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al acceder a la base de datos", e);
		} finally {
			if (ps != null) {
				try {
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {

					throw new AccesoDatosException("Ha habido un error al cerrar", e);
				}
			}

		}

	}

	@Override
	public void baja(Producto producto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificacion(Producto producto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Producto[] obtenerProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtenerProductoPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto[] obtenerProductosPorNombreParcial(String nombreParcial) {
		// TODO Auto-generated method stub
		return null;
	}

}
