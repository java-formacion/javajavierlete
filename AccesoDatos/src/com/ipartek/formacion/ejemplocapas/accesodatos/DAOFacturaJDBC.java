package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.ipartek.formacion.ejemplocapas.entidades.Carrito;
import com.ipartek.formacion.ejemplocapas.entidades.Factura;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;

public class DAOFacturaJDBC implements DAOFactura{
	private static final String SQL_INSERT = 
			"INSERT INTO factura " +
			"(idCarrito, fecha, totalConIva, totalSinIva) " +
			"VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE =
			"UPDATE factura SET "+
			"fecha=?, totalConIva=?, totalSinIva=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM factura WHERE id=?";
	
	private static final String SQL_SELECT = 
			"SELECT id,idCarrito, fecha, totalConIva, totalSinIva FROM factura ";
	private static final String SQL_SELECT_ID = 
			"SELECT id, idCarrito, fecha, totalConIva, totalSinIva "+
			"FROM productos WHERE id=?";
	private static final String SQL_SELECT_IDCARRITO_PARCIAL = 
			"SELECT id, idCarrito, fecha, totalConIva, totalSinIva "+
			"FROM factura WHERE idCarrito LIKE ?";
	
	private final String url, user, password;
	
	public DAOFacturaJDBC (String url,String user,String password) {
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
	public void alta(final Factura factura,final long idCarrito) {
		genericoAltaBajaModificacion(factura, SQL_INSERT, 
				new SettersPreparedStatement() {
					
					Date fecha= (Date) factura.getFecha();
					int id=(int) idCarrito;
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
						ps.setInt(2, id );
						ps.setDate(3, fecha);
						ps.setDouble(4, factura.getTotalConIva());
						ps.setDouble(5, factura.getTotalSinIva());
					}
				});
		
	}

	@Override
	public void baja(final Factura factura,final long idCarrito) {
	
		genericoAltaBajaModificacion(factura, SQL_DELETE, new SettersPreparedStatement() {
			
			@Override
			public void ejecutar(PreparedStatement ps) throws SQLException {
				ps.setLong(1, factura.getId());
				
			}
		});
	}

	@Override
	public void modificacion(final Factura factura) {
		genericoAltaBajaModificacion(factura, SQL_UPDATE, new SettersPreparedStatement() {
			
			@Override
			public void ejecutar(PreparedStatement ps) throws SQLException {
				ps.setDate(3, (Date) factura.getFecha());
				ps.setDouble(4, factura.getTotalConIva());
				ps.setDouble(5, factura.getTotalSinIva());
				
			}
		});
	}

	@Override
	public Factura[] obtenerFacturas() {
		/*return genericoConsultaVarios(SQL_SELECT,
				new SettersPreparedStatement() {
					
					@Override
					public void ejecutar(PreparedStatement ps) throws SQLException {
					}
				});*/
		
		
		return null;
	}
	
	public Factura[] genericoConsultaVarios(String sql, SettersPreparedStatement sps) {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		/*while(rs.next()) {
				p = new Producto(
						rs.getLong("id"),
						rs.getString("nombre"),
						rs.getString("descripcion"),
						rs.getBigDecimal("precio"));
				
				productos.add(p);
			}*/
		/*
		 * f = new Factura(
						rs.getLong("id"),
						rs.getObject("u"),
						rs.getArray("c"),
						rs.getDate("fecha"),
						rs.getDouble("iva"),
						rs.getDouble("totalSinIva"),
						rs.getDouble("totalConIva"));
				
				facturas.add(f);*/
		try {
			con = DriverManager.getConnection(url,user,password);
			ps = con.prepareStatement(sql);
			sps.ejecutar(ps);
			rs=ps.executeQuery();
			Factura f;
			while(rs.next()) {
				f = new Factura(rs.getLong("id"), rs.getObject("u"), rs.getArray("c"), rs.getDate("fecha"), rs.getDouble("iva"), rs.getDouble("totalSinIva"), rs.getDouble("totalConIva"));
				facturas.add(f);
						
			}
			return facturas.toArray(new Factura[facturas.size()]);
		}catch (SQLException e) {
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
	

	@Override
	public Factura obtenerFacturaPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
