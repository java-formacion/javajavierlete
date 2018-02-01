package com.ipartek.formacion.ejemplocapas.entidades;

import java.util.ArrayList;
import java.util.Date;

public class Factura {

	private final long id;
	private final long idUsuario;
	private ArrayList<Producto> producto;
	private Date fecha;
	private double iva;
	
	public Factura(long id, long idUsuario, ArrayList<Producto> producto, Date fecha, double iva) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.producto = producto;
		this.fecha = fecha;
		this.iva = iva;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
		long temp;
		temp = Double.doubleToLongBits(iva);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (Double.doubleToLongBits(iva) != Double.doubleToLongBits(other.iva))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", idUsuario=" + idUsuario + ", producto=" + producto + ", fecha=" + fecha
				+ ", iva=" + iva + "]";
	}
	public ArrayList<Producto> getProducto() {
		return producto;
	}
	public void setProducto(ArrayList<Producto> producto) {
		this.producto = producto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public long getId() {
		return id;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	
	
	
	
	
	
	
}
