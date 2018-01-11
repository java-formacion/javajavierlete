package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public class DAOProductoArrayList implements DAOProducto {

	private ArrayList<Producto> productos = new ArrayList<Producto>();

	@Override
	public void alta(Producto producto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void baja(Producto producto) {

		productos.remove(producto);

	}

	@Override
	public void modificacion(Producto producto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Producto[] obtenerProductos() {

		return productos.toArray(new Producto[productos.size()]);

	}

	@Override
	public Producto obtenerProductoPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
