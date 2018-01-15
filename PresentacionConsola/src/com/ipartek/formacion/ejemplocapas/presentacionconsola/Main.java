package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOFactory;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOProducto;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOProductoArrayList;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioArrayList;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioJDBC;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class Main {
	public static void main(String[] args) {
		DAOProducto daoProducto = new DAOProductoArrayList();
		
		ProductosComponente pc = new ProductosComponente(daoProducto);
		
		for(int i = 1; i <= 3; i++)
			daoProducto.alta(new Producto(
				i,
				"Producto" + i,
				"Descripción" + i,
				new BigDecimal("" + i + i + "." + i + i)
				)
			);
		
		Producto producto = daoProducto.obtenerProductosPorNombreParcial("ucto1")[0];
		
		pc.mostrarProducto(producto);
		
		producto.setNombre("MODIFICADO");
		producto.setPrecio(new BigDecimal("50.50"));
		
		daoProducto.modificacion(producto);
		
		pc.mostrarProductos();
		
		Producto producto2 = daoProducto.obtenerProductoPorId(producto.getId());
		
		pc.mostrarProducto(producto2);
		
		pc.mostrarProductos();
		
		Producto producto1 = new Producto(
				2, "Producto2", "Descripción2", new BigDecimal("22.22")
				);

		daoProducto.baja(producto1);
		
		pc.mostrarProductos();
	}
	
	public static void mainUsuariosConProperties(String[] args) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader("src/ejemplocapas.properties"));

		final String url = p.getProperty("accesodatos.url");
		final String motor = p.getProperty("accesodatos.motor");
		final String user = p.getProperty("accesodatos.usuario");
		final String password = p.getProperty("accesodatos.password");
		
		DAOFactory df = new DAOFactory(motor, url, user, password);
		DAOUsuario daoUsuario = df.getDAOUsuario();
		
		UsuariosComponente uc = new UsuariosComponente(daoUsuario);
		
		Usuario usuario1 = new Usuario(
				1, 
				"12345678Z", 
				"javierlete@miemail.com", 
				"contraseña", 
				"Javier", 
				"Lete");
		
		Usuario usuario2 = new Usuario(
				2, 
				"12345678Z", 
				"pepeperez@miemail.com", 
				"contraseña", 
				"Pepe", 
				"Pérez");
		
		daoUsuario.alta(usuario1);
		
		daoUsuario.alta(usuario2);

		uc.mostrarUsuarios();
		
		Usuario usuario = daoUsuario.obtenerUsuarioPorEmail("pepeperez@miemail.com");
		
		System.out.println("El usuario cuyo email es nuevo... es ");
		
		uc.mostrarUsuario(usuario);
		
		usuario.setNombre("Nuevo");
		usuario.setApellidos("Nuevez");
		
		daoUsuario.modificacion(usuario);
		
		uc.mostrarUsuarios();
		
		usuario = daoUsuario.obtenerUsuarioPorId(usuario.getId());
		
		System.out.println("Usuario por ID");
		
		uc.mostrarUsuario(usuario);
		
		daoUsuario.baja(usuario);
		
		daoUsuario.baja(daoUsuario.obtenerUsuarioPorEmail("javierlete@miemail.com"));
		
		uc.mostrarUsuarios();
	}
	
	public static void mainPruebaUsuarioJDBC(String[] args) {
		DAOUsuario daoUsuario = new DAOUsuarioJDBC(
				"jdbc:sqlite:..\\AccesoDatos\\bdd\\ejemplocapas.s3db", null, null);
		
		daoUsuario.alta(new Usuario(
				0, 
				"12345678Z", 
				"yepa@email.com",
				"contraseña",
				"Javier",
				"Lete")
		);
		
		Usuario[] usuarios = daoUsuario.obtenerUsuarios();
		
		for(Usuario u: usuarios)
			System.out.println(u);
	}
	
	public static void mainProducto(String[] args) {
		DAOProducto daoProducto = new DAOProductoArrayList();
		
		ProductosComponente pc = new ProductosComponente(daoProducto);
		
		for(int i = 1; i <= 3; i++)
			daoProducto.alta(new Producto(
				i,
				"Producto" + i,
				"Descripción" + i,
				new BigDecimal("" + i + i + "." + i + i)
				)
			);
		
		pc.mostrarProductos();
		
		Producto producto2 = daoProducto.obtenerProductoPorId(1);
		
		pc.mostrarProducto(producto2);
				
		producto2.setNombre("MODIFICADO");
		producto2.setPrecio(new BigDecimal("50.50"));
		
		daoProducto.modificacion(producto2);
		
		pc.mostrarProductos();
		
		Producto producto1 = new Producto(
				2, "Producto2", "Descripción2", new BigDecimal("22.22")
				);

		daoProducto.baja(producto1);
		
		pc.mostrarProductos();
	}
	public static void mainUsuario(String[] args) {
		DAOUsuario daoUsuario = new DAOUsuarioArrayList();
		
		UsuariosComponente uc = new UsuariosComponente(daoUsuario);
		
		Usuario usuario1 = new Usuario(
				1, 
				"12345678Z", 
				"javierlete@miemail.com", 
				"contraseña", 
				"Javier", 
				"Lete");
		
		Usuario usuario2 = new Usuario(
				2, 
				"12345678Z", 
				"pepeperez@miemail.com", 
				"contraseña", 
				"Pepe", 
				"Pérez");
		
		daoUsuario.alta(usuario1);
		
		daoUsuario.alta(usuario2);

		uc.mostrarUsuarios();
		
		usuario2.setEmail("nuevo@email.com");
		
		daoUsuario.modificacion(usuario2);
		
		uc.mostrarUsuarios();
		
		Usuario usuario = daoUsuario.obtenerUsuarioPorEmail("nuevo@email.com");
		
		System.out.println("El usuario cuyo email es nuevo... es ");
		
		uc.mostrarUsuario(usuario);
		
		usuario = daoUsuario.obtenerUsuarioPorId(1);
		
		System.out.println("Usuario ID = 1 ");
		
		uc.mostrarUsuario(usuario);
		
		daoUsuario.baja(usuario);
		
		uc.mostrarUsuarios();
	}

	

}
