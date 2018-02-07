package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ipartek.formacion.ejemplocapas.entidades.Carrito;
import com.ipartek.formacion.ejemplocapas.entidades.Factura;

public class DAOCarritoJDBC implements DAOCarrito {
	
	private static final String SQL_INSERT = 
			"INSERT INTO Carrito " +
			"(id_carrito, id_usuario, id_producto, cantidad)" +
			"VALUES (?,?,?,?)";
	
	private final String url, user, password;
	
	
	public DAOCarritoJDBC(String url, String user, String password) {
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

	public void genericoAltaBajaModificacion(Carrito carrito, String sql, SettersPreparedStatement sps) {
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
	public void alta(final Carrito carrito) {
		
		genericoAltaBajaModificacion(carrito, SQL_INSERT, 
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						
					
						ps.setLong(1, carrito.getId());
						ps.setLong(2, carrito.getU().getId());
						ps.setDouble(3, carrito.getProducto().getId());
						ps.setDouble(4, carrito.getCantidad());
						
					}
				});
		
	}

	@Override
	public void baja(Carrito carrito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificacion(Carrito carrito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carrito[] obtenerCarritos() {
		// TODO Auto-generated method stub
		return null;
	}

}
