package com.ipartek.formacion.ejemplocapas.entidades;

public class Carrito {

	private long idCarrito;
	private  Producto p;
	private Usuario u;
	private int cantidad;
	
	
	public Carrito(long idCarrito, Producto p, Usuario u, int cantidad) {
		super();
		this.idCarrito = idCarrito;
		this.p = p;
		this.u = u;
		this.cantidad = cantidad;
	}


	public long getIdCarrito() {
		return idCarrito;
	}


	public void setIdCarrito(long idCarrito) {
		this.idCarrito = idCarrito;
	}


	public Producto getP() {
		return p;
	}


	public void setP(Producto p) {
		this.p = p;
	}


	public Usuario getU() {
		return u;
	}


	public void setU(Usuario u) {
		this.u = u;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
