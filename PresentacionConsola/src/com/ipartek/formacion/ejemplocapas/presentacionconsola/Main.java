package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import java.math.BigDecimal;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOProducto;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOProductoArrayList;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioArrayList;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioJDBC;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class Main {
	
	public static void main(String[] args) {
		DAOUsuario daoUsuario = new DAOUsuarioJDBC(
				"jdbc:sqlite:..\\AccesoDatos\\bdd\\ejemplocapas.s3db");
		
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
