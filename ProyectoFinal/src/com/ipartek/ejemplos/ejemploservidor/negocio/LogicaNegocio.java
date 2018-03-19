package com.ipartek.ejemplos.ejemploservidor.negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.ipartek.formacion.ejemplocapas.accesodatos.AccesoDatosException;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOFactory;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOProducto;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class LogicaNegocio {
	
	private static DAOUsuario daoUsuario;
	private static DAOProducto daoProducto;
	
	static {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream is = classLoader.getResourceAsStream("/ejemplocapas.properties");
			
			Properties p = new Properties();
			p.load(is);//new FileReader("ejemplocapas.properties"));

			final String url = p.getProperty("accesodatos.url");
			final String motor = p.getProperty("accesodatos.motor");
			final String user = p.getProperty("accesodatos.usuario");
			final String password = p.getProperty("accesodatos.password");
			
			DAOFactory df = new DAOFactory(motor, url, user, password);
			
			daoProducto = df.getDAOProducto();
			
			daoUsuario = df.getDAOUsuario();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LogicaNegocioException(
					"No se ha encontrado el fichero", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new LogicaNegocioException(
					"Error al intentar leer el fichero de configuración", e);
		}
	}
	
	private LogicaNegocio() {}
	
	public static boolean esValidoUsuario(Usuario usuario) {
		Usuario u = daoUsuario.obtenerUsuarioPorEmail(usuario.getEmail());
		
		return u != null && u.getPassword().equals(usuario.getPassword());
		
		//		return "javierlete@email.net".equals(usuario.getEmail()) && 
//				"Pa$$w0rd".equals(usuario.getPassword());
		
	}

	public static Producto[] obtenerProductos() {
		
		return daoProducto.obtenerProductos();
	}

	public static Producto obtenerProductoPorId(String id) {
		
		return daoProducto.obtenerProductoPorId(Long.parseLong(id));
	}

	public static Usuario obtenerUsuarioPorEmail(String email) {
		
		return daoUsuario.obtenerUsuarioPorEmail(email);
	}

	public static void altaUsuario(Usuario usuario) {

		if(obtenerUsuarioPorEmail(usuario.getEmail()) != null){
			throw new LogicaNegocioException("Ya existe un usuario con ese Email");
		}
		try {
			daoUsuario.alta(usuario);
		} catch(AccesoDatosException ade) {
			throw new LogicaNegocioException("No se puede crear el usuario", ade);
		}
	}
}
