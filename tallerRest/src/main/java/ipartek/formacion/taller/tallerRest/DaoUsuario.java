package ipartek.formacion.taller.tallerRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;


public class DaoUsuario {

	
	
	private static final String SQL_INSERT = 
			"INSERT INTO usuario " +
			"(nombre, apellido, email, telefono)" +
			"VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE =
			"UPDATE usuario SET "+
			"nombre=?, apellido=?, email=?, telefono=? "+
			"WHERE id=?";
	private static final String SQL_DELETE =
			"DELETE FROM usuario WHERE id=?";
	
	private static final String SQL_SELECT = 
			"SELECT usuario.id, usuario.nombre, usuario.apellido, usuario.email, usuario.telefono,coche.id,\r\n" + 
			"coche.marca, coche.modelo, coche.cv, coche.matricula, coche.anios FROM usuario INNER JOIN\r\n" + 
			"coche on coche.Usuario_id = usuario.id order by usuario.id";
	private static final String SQL_SELECTID = 
			"SELECT id, nombre, apellido, email, telefono FROM usuario where id=?";
	
	private static final String SQL_SELECT_COCHES_USUARIOID =
			"SELECT id, marca, modelo, cv, matricula, anios FROM coche where Usuario_id = ?";
	
	
	private static String url="jdbc:mysql://localhost:3306/taller";
	private static String user="root";
	private static String password="root";
	
	protected static Connection con = null;
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	
	public DaoUsuario() {
		
	}
	public DaoUsuario(String url, String user, String password) {
		super();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	protected static void crearConexion() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	*/
	
	
	
	public Usuario[] mostrarUsuarios() throws Exception {
		
		//List<Usuario> usuarios = new ArrayList<Usuario>(); esta seria mejor
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_SELECT);
			
			rs = ps.executeQuery();
			
			Usuario u;
			Coche c;
			int cont = 1;
			while(rs.next()) {
				
				c= new Coche();
				c.setId(rs.getInt("coche.id"));
				c.setMarca(rs.getString("coche.marca"));
				c.setModelo(rs.getString("coche.modelo"));
				c.setCv(rs.getString("coche.cv"));
				c.setMatricula(rs.getString("coche.matricula"));
				c.setAnios(rs.getString("coche.anios"));
				
				List<Coche> coches = new ArrayList<Coche>();
				coches.add(c);
				
				
				
				u = new Usuario(
						rs.getInt("usuario.id"),
						rs.getString("usuario.nombre"),
						rs.getString("usuario.apellido"),
						rs.getString("usuario.email"),
						rs.getString("usuario.telefono"),
						coches.toArray(new Coche[coches.size()]));
				
				if( cont == 1) {
					usuarios.add(u);
					cont++;
				}
				else {
				for (int i = 0; i< usuarios.size(); i++) {
					
					if(usuarios.get(i).getId() == u.getId()) {
					List<Coche> cocheUser = new ArrayList<Coche>();
					
					for (Coche coche : usuarios.get(i).getCoches()) {
						
						
						cocheUser.add(coche);
						if(coche.getId() != c.getId()) {
							cocheUser.add(c);
						}
					}
					
					
					usuarios.get(i).setCoches(cocheUser.toArray(new Coche[coches.size()]));
					
					System.out.println(usuarios.get(i).getCoches().length);
					break;
					}
					else usuarios.add(u);
					
				}
				}
				
			}
			
			
			return usuarios.toArray(new Usuario[usuarios.size()]);
		} catch (SQLException e) {
			throw new Exception(
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
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
		
	}
	
	
	

	public Usuario mostrarUsuario(int id) throws Exception {
		
		//List<Usuario> usuarios = new ArrayList<Usuario>(); esta seria mejor
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(SQL_SELECTID);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			Usuario u;
			Coche c;
			if(rs.next()) {
				u = new Usuario(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("email"),
						rs.getString("telefono"));
				
				ps= con.prepareStatement(SQL_SELECT_COCHES_USUARIOID);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				
				List<Coche> coches = new ArrayList<Coche>();
				while(rs.next()) {
					c = new Coche();
					c.setId(rs.getInt("id"));
					c.setMarca(rs.getString("marca"));
					c.setModelo(rs.getString("modelo"));
					c.setCv(rs.getString("cv"));
					c.setMatricula(rs.getString("matricula"));
					c.setAnios(rs.getString("anios"));
							
					coches.add(c);
					
				}
				
				u.setCoches(coches.toArray(new Coche[coches.size()]));
				
				return u;
			}else return null;
			
		} catch (SQLException e) {
			throw new Exception(
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
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
		
	}
	
	
	public void insertarUsuario(Usuario usuario) throws Exception {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_INSERT);
			
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getTelefono());
			
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new Exception(
						"La inserci�n ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new Exception(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
		
		
	}
	
	
	public void modificarUsuario(Usuario usuario) throws Exception {
	
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_UPDATE);
			
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getTelefono());
			ps.setInt(5, usuario.getId());
			
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new Exception(
						"La inserci�n ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new Exception(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
		
		
	}
	
	
	public void borrarUsuario(Usuario usuario) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user , password);
			
			ps = con.prepareStatement(SQL_DELETE);
			
			ps.setInt(1, usuario.getId());
			
			
			
			int num = ps.executeUpdate();
			
			if(num != 1)
				throw new Exception(
						"La inserci�n ha devuelto un resultado diferente de 1");
		} catch (SQLException e) {
			throw new Exception(
					"Error al acceder a la base de datos", e);
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				throw new Exception("Ha habido un error al cerrar", e);
			}
		}
	
	}
	
	
}
