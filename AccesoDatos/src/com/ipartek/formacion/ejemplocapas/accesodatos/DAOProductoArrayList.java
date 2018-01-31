package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public class DAOProductoArrayList implements DAOProducto {

	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	@Override
	public void alta(Producto producto) {
		if(obtenerProductoPorId(producto.getId()) == null)
			productos.add(producto);
		else
			throw new AccesoDatosException(
					"Ya existe ese producto con ID = " + 
							producto.getId());
	}

	@Override
	public void baja(Producto producto) {
		productos.remove(producto);
	}

	@Override
	public void modificacion(Producto producto) {
		Producto p = obtenerProductoPorId(producto.getId());

		if(p != null) {
			p.setNombre(producto.getNombre());
			p.setDescripcion(producto.getDescripcion());
			p.setPrecio(producto.getPrecio());
		} else {
			throw new AccesoDatosException("No existe el producto a modificar");
		}
	}

	@Override
	public Producto[] obtenerProductos() {
		return productos.toArray(new Producto[productos.size()]);
	}

	@Override
	public Producto obtenerProductoPorId(long id) {
		Producto p;
		
		for(int i = 0; i < productos.size(); i++) {
			p = productos.get(i);
			
			if(p.getId() == id) 
				return p;
		}
		
		return null;
	}

	@Override
	public Producto[] obtenerProductosPorNombreParcial(String nombreParcial) {
		Producto p;
		ArrayList<Producto> resultados = new ArrayList<Producto>();
		
		for(int i = 0; i < productos.size(); i++) {
			p = productos.get(i);
			
			if(p.getNombre().contains(nombreParcial)) 
				resultados.add(p);
		}
		
		return resultados.toArray(new Producto[resultados.size()]);
	}

}
