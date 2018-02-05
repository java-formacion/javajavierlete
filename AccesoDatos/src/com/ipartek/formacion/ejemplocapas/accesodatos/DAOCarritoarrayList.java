package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Carrito;

public class DAOCarritoarrayList implements DAOCarrito{

	
	private ArrayList<Carrito> carritos = new ArrayList<Carrito>();
	
	@Override
	public void alta(Carrito carrito) {
		
		carritos.add(carrito);
	}

	@Override
	public void baja(Carrito carrito) {
		carritos.remove(carrito);
		
	}

	@Override
	public void modificacion(Carrito carrito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long obtenerCantidadProductoPorIdProducto(Long idProducto) {
		
		for(Carrito c: carritos) {
			if(c.getIdProducto()==idProducto) {
				return (long) c.getCantidad();
			}
		}
		
		return (long) -1;
	}

	@Override
	public Carrito[] obetnerCarritos() {
		//return usuarios.toArray(new Usuario[usuarios.size()]);
		
		return carritos.toArray(new Carrito[carritos.size()]);
		
	}

	@Override
	public Carrito obetenerCarritoPorId(Long idCarrito) {
		
		for(Carrito c: carritos) {
			if(idCarrito== c.getIdCarrito()) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void sumarCantidadAlProducto(Long idProducto) {
		for(Carrito c: carritos) {
			if(c.getIdProducto()==idProducto) {
				c.setCantidad(c.getCantidad()+1);
			}
		}
		
	}

	

	
	
	

}
