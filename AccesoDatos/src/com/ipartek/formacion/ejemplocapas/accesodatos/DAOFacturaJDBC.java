package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ipartek.formacion.ejemplocapas.entidades.Factura;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public class DAOFacturaJDBC implements DAOFactura{

	private static final String SQL_INSERT = 
			"INSERT INTO Factura " +
			"(id_factura, id_carrito, num_factura, iva, importe, total, fecha) " +
			"VALUES (?,?,?,?,?,?,?)";
	
	private final String url, user, password;
	
	
	public DAOFacturaJDBC(String url, String user, String password) {
		super();
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public void genericoAltaBajaModificacion(Factura factura, String sql, SettersPreparedStatement sps) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(sql);
			
			sps.ejecutar(ps);
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new AccesoDatosException(
						"La operación ha devuelto un resultado diferente de 1");
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
	
	
	@Override
	public void alta(final Factura factura) {
		// TODO Auto-generated method stub
		
		genericoAltaBajaModificacion(factura, SQL_INSERT, 
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						java.sql.Date fecha = new java.sql.Date(factura.getFecha().getTime());
						ps.setLong(1, factura.getId());
						ps.setLong(2, factura.getCarrito().get(0).getId());
						ps.setLong(3, factura.getNumeroFactura());
						ps.setDouble(4, factura.getIva());
						ps.setDouble(5, factura.getImporte());
						ps.setDouble(6, factura.getTotal());
						ps.setDate(7,fecha);
					}
				});
		
	}

	@Override
	public void baja(Factura factura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificacion(Factura factura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Factura[] obtenerProductos() {
		// TODO Auto-generated method stub
		return null;
	}

}
