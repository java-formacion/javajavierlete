package com.ipartek.formacion.ejemplocapas.entidades;

public class Carrito {

	private long idCarrito;
	private long idProducto;
	private int cantidad;
	

	public Carrito(long idCarrito, long idProducto, int cantidad) {
		this.idCarrito = idCarrito;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	

	public long getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public long getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(long idCarrito) {
		this.idCarrito = idCarrito;
	}
	
	
	
	
	
	
	
	
	
}
