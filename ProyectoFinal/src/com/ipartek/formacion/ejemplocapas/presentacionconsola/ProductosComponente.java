package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOProducto;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public class ProductosComponente {
	private DAOProducto daoProducto;
	
	ProductosComponente(DAOProducto daoProducto) {
		super();
		this.daoProducto= daoProducto;
	}

	void mostrarProducto(Producto producto) {
		System.out.println("ID\t" + producto.getId());
		System.out.println(producto.getNombre());
		System.out.println(producto.getDescripcion());
		System.out.println(producto.getPrecio());
	}
	
	void mostrarProductos() {
		mostrarProductos(daoProducto);
	}
	
	void mostrarProductos(DAOProducto daoProducto) {
		System.out.println("----INICIO-----");
		
		Producto[] productos = daoProducto.obtenerProductos();
		
		for(Producto p: productos)
			System.out.println(p);
		
		System.out.println("-----FIN------");
	}
}
