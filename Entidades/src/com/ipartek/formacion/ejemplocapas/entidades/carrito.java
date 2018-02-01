package com.ipartek.formacion.ejemplocapas.entidades;

public class carrito {

	private long idProducto;
	private int cantidad;
	
	
	public carrito(long idProducto, int cantidad) {
		super();
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	public long getIdProducto() {
		return idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
}
