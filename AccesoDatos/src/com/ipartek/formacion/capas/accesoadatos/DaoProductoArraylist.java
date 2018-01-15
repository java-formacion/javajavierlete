package com.ipartek.formacion.capas.accesoadatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DaoProductoArraylist implements DaoProducto {

	
	
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	@Override
	public void alta(Producto producto) {
		
		productos.add(producto);
		
	}

	@Override
	public void baja(Producto producto) {
		
		
		productos.remove(producto);
		
	}

	@Override
	public void modificacion(Producto producto) {

		Producto p;
		
		if (producto.getPrecio().doubleValue() < 0)
			throw new AccesoDatosException("No puede tener un precio negativo");
		
		for(int i = 0; i < productos.size(); i++) {
			
				p= productos.get(i);
				
				if(p.getId() == producto.getId()) {
				
					p.setDescripcion(producto.getDescripcion());
					p.setNombre(producto.getNombre());
					p.setPrecio(producto.getPrecio());
					
			}
		}
		
	}

	@Override
	public Producto[] obtenerProductos() {
		
		return productos.toArray(new Producto[productos.size()]);
	}

	@Override
	public Producto obtenerProductoPorId(long id) {
		
		for(Producto p : productos)
			if(id == p.getId())
				return p;
		
		return null;
	}

}
