package com.ipartek.formacion.ejemplocapas.presentacionporconsola;

import java.math.BigDecimal;

import com.ipartek.formacion.capas.accesoadatos.DaoProducto;
import com.ipartek.formacion.capas.accesoadatos.DaoProductoArraylist;
import com.ipartek.formacion.capas.accesoadatos.DaoUsuario;
import com.ipartek.formacion.capas.accesoadatos.DaoUsuariosArraylist;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class Main {

	private static DaoUsuario daoUsuario;	
	private static DaoProducto daoProducto;
	
	public static void main(String[] args) {
		
		daoUsuario = new DaoUsuariosArraylist();
		daoProducto = new DaoProductoArraylist();
		
		daoUsuario.alta(new Usuario(1, "16055865J", "borja@gmail.com", "123456789", "Borja", "Gonzalez"));
		daoUsuario.alta(new Usuario(2, "54789658F", "luffy@gmail.com", "123456789", "Luffy", "Gonzalez"));
		
		Producto producto1 = new Producto(1, "Manzana", "esto es una maznana",new BigDecimal("5"));
		Producto producto2 = new Producto(2, "Platano", "esto es un platano",new BigDecimal("3"));
		
		daoProducto.alta(producto1);
		daoProducto.alta(producto2);
		
		mostrarUsuario();
		mostrarProducto();

	}

	private static void mostrarUsuario() {
		Usuario[] usuarios = daoUsuario.obtenerUsuarios();
		
		System.out.println("------- INICIO-----------");
		for(Usuario u : usuarios)
			System.out.println(u);
		
		
		System.out.println("------- FIN -----------");
	}
	
	private static void mostrarProducto() {
		
			Producto[] productos = daoProducto.obtenerProductos();		
		System.out.println("------- INICIO-----------");
		for(Producto p : productos)
			System.out.println(p);
		
		
		System.out.println("------- FIN -----------");
	}
	

}
