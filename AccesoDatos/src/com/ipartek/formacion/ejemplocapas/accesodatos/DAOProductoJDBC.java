package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public class DAOProductoJDBC implements DAOProducto {
	private static final String SQL_INSERT = 
			"INSERT INTO productos " +
			"(nombre, descripcion, precio) " +
			"VALUES (?, ?, ?)";
	private static final String SQL_UPDATE =
			"UPDATE productos SET "+
			"nombre=?, descripcion=?, precio=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM productos WHERE id=?";
	
	private static final String SQL_SELECT = 
			"SELECT id, nombre, descripcion, precio FROM productos ";
	private static final String SQL_SELECT_ID = 
			"SELECT id, nombre, descripcion, precio "+
			"FROM productos WHERE id=?";
	private static final String SQL_SELECT_NOMBRE_PARCIAL = 
			"SELECT id, nombre, descripcion, precio "+
			"FROM productos WHERE nombre LIKE ?";

	private final String url, user, password;
	
	public DAOProductoJDBC(String url, String user, String password) {
		super();
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public void genericoAltaBajaModificacion(Producto producto, String sql, SettersPreparedStatement sps) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(sql);
			
			sps.ejecutar(ps);
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new AccesoDatosException(
						"La operaci�n ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new AccesoDatosException(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new AccesoDatosException("Ha habido un error al cerrar", e);
			}
		}
	}
	
//	class Alta implements SettersPreparedStatement {
//
//		@Override
//		public void ejecutar(PreparedStatement ps) throws SQLException {
//			ps.setString(1, producto.getNombre());
//			ps.setString(2, producto.getDescripcion());
//			ps.setBigDecimal(3, producto.getPrecio());
//		}
//		
//	}
	
	@Override
	public void alta(final Producto producto) {
//		Alta sps = new Alta();
//		genericoAltaBajaModificacion(producto, SQL_INSERT, sps);
		genericoAltaBajaModificacion(producto, SQL_INSERT, 
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setString(1, producto.getNombre());
						ps.setString(2, producto.getDescripcion());
						ps.setBigDecimal(3, producto.getPrecio());
					}
				});
//		genericoAltaBajaModificacion(producto, SQL_INSERT, 
//				(PreparedStatement ps) -> {
//					ps.setString(1, producto.getNombre());
//					ps.setString(2, producto.getDescripcion());
//					ps.setBigDecimal(3, producto.getPrecio());
//				});
	}
	
	@Override
	public void baja(final Producto producto) {
		genericoAltaBajaModificacion(producto, SQL_DELETE,
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setLong(1, producto.getId());
					}
				});
		
//		genericoAltaBajaModificacion(producto, SQL_DELETE,
//			(PreparedStatement ps) -> ps.setLong(1, producto.getId()));
	}

	@Override
	public void modificacion(final Producto producto) {
		genericoAltaBajaModificacion(producto, SQL_UPDATE, 
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setString(1, producto.getNombre());
						ps.setString(2, producto.getDescripcion());
						ps.setBigDecimal(3, producto.getPrecio());
						ps.setLong(4, producto.getId());
					}
				});
	}

	public Producto[] genericoConsultaVarios(String sql, SettersPreparedStatement sps) {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			
			sps.ejecutar(ps);
			
			rs = ps.executeQuery();
			
			Producto p;
			
			while(rs.next()) {
				p = new Producto(
						rs.getLong("id"),
						rs.getString("nombre"),
						rs.getString("descripcion"),
						rs.getBigDecimal("precio"));
				
				productos.add(p);
			}
			
			return productos.toArray(new Producto[productos.size()]);
		} catch (SQLException e) {
			throw new AccesoDatosException(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new AccesoDatosException("Ha habido un error al cerrar", e);
			}
		}
	}

	public Producto genericoConsultaUno(String sql, SettersPreparedStatement sps) {
		return genericoConsultaVarios(sql, sps)[0];
	}
	
	@Override
	public Producto[] obtenerProductos() {
		return genericoConsultaVarios(SQL_SELECT,
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
					}
				});
	}
	
	@Override
	public Producto obtenerProductoPorId(final long id) {
		return genericoConsultaUno(SQL_SELECT_ID, 
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setLong(1, id);
					}
				});
	}

	@Override
	public Producto[] obtenerProductosPorNombreParcial(final String nombreParcial) {
		return genericoConsultaVarios(SQL_SELECT_NOMBRE_PARCIAL, 
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setString(1, "%" + nombreParcial + "%");
					}
				});
	}

}
