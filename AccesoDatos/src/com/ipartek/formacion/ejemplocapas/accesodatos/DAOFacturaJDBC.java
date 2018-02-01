package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ipartek.formacion.ejemplocapas.entidades.Factura;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public class DAOFacturaJDBC implements DAOFactura{
	private static final String SQL_INSERT = 
			"INSERT INTO Factura " +
			"(IVA, precioTotal, fechaFacturacion) " +
			"VALUES (?, ?, ?)";
	private static final String SQL_UPDATE =
			"UPDATE Factura SET "+
			"IVA=?, precioTotal=?, fechaFacturacion=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM Factura WHERE id=?";
	
	private static final String SQL_SELECT = 
			"SELECT id, IVA, precioTotal, fechaFacturacion FROM Factura ";
	private static final String SQL_SELECT_ID = 
			"SELECT id, IVA, precioTotal, fechaFacturacion "+
			"FROM Factura WHERE id=?";
	
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
		genericoAltaBajaModificacion(factura, SQL_INSERT, 
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setInt(1, factura.getIVA());
						ps.setFloat(2, factura.getPrecioTotal());
						ps.setDate(3, factura.getFechaFactura());
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
	public Factura[] obtenerFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura obtenerPFacturaPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}