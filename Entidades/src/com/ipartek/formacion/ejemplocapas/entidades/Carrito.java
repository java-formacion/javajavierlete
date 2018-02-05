package com.ipartek.formacion.ejemplocapas.entidades;

public class Carrito {

	private long idCarrito;
	private long idProducto;
	private long idUsuario;
	private int cantidad;
	

	public Carrito(long idCarrito, long idProducto, long idUsuario, int cantidad) {
		super();
		this.idCarrito = idCarrito;
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
		this.cantidad = cantidad;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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
