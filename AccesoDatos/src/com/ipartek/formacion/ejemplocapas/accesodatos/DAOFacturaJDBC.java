package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Factura;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public class DAOFacturaJDBC implements DAOFactura{
	private static final String SQL_INSERT = 
			"INSERT INTO facturas " +
			"(codigo, fecha, subtotal, total) " +
			"VALUES (?, ?, ?)";
	private static final String SQL_UPDATE =
			"UPDATE facturas  SET "+
			"codigo=?, fecha=?, subtotal=?, total=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM facturas  WHERE id=?";
	
	private static final String SQL_SELECT = 
			"SELECT id, codigo, fecha, subtotal, total FROM facturas  ";
	private static final String SQL_SELECT_ID = 
			"SELECT id, codigo, fecha, subtotal, total "+
			"FROM facturas  WHERE id=?";
	private static final String SQL_SELECT_NOMBRE_PARCIAL = 
			"SELECT id, codigo, fecha, subtotal, total "+
			"FROM facturas  WHERE nombre LIKE ?";

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
						ps.setString(1, factura.getCodigo());
						ps.setDate(2, (Date) factura.getFecha());
						ps.setBigDecimal(3, factura.getSubtotal());
						ps.setBigDecimal(4, factura.getTotal());
					}
				});
		
	}

	@Override
	public void baja(final Factura factura) {
		genericoAltaBajaModificacion(factura, SQL_DELETE,
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setLong(1, factura.getId());
					}
				});
		
	}

	@Override
	public void modificacion(final Factura factura) {
		genericoAltaBajaModificacion(factura, SQL_UPDATE, 
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setString(1, factura.getCodigo());
						ps.setDate(2,(Date) factura.getFecha());
						ps.setBigDecimal(3, factura.getSubtotal());
						ps.setBigDecimal(4, factura.getTotal());
						ps.setLong(5, factura.getId());
					}
				});
		
	}
	public Factura[] genericoConsultaVarios(String sql, SettersPreparedStatement sps) {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			
			sps.ejecutar(ps);
			
			rs = ps.executeQuery();
			
			Factura p;
			
			while(rs.next()) {
				p = new Factura(
						rs.getLong("id"),
						rs.getString("codigo"),
						rs.getDate("fecha"),
						rs.getBigDecimal("subtotal"),
						rs.getBigDecimal("total"));
				
				facturas.add(p);
			}
			
			return facturas.toArray(new Factura[facturas.size()]);
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
	
	public Factura genericoConsultaUno(String sql, SettersPreparedStatement sps) {
		return genericoConsultaVarios(sql, sps)[0];
	}
	@Override
	public Factura[] obtenerFactura() {
		return genericoConsultaVarios(SQL_SELECT,
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
					}
				});
	}

	@Override
	public Factura obtenerFacturaPorId(final long id) {
		return genericoConsultaUno(SQL_SELECT_ID, 
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setLong(1, id);
					}
				});
	}
	
}
