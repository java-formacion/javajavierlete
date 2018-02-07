package com.ipartek.formacion.ejemplocapas.entidades;

import java.util.Date;

public class Factura {
	
	private final int id;
	private int iva;
	private double precio;
	private Date fecha;
	
	public Factura(int id, int iva, double precio, Date fecha) {
		this.id = id;
		this.iva = iva;
		this.precio = precio;
		this.fecha = fecha;
	}

	public long getId() {
		return id;
	}

	public int getIva() {
		return iva;
	}

	public double getPrecio() {
		return precio;
	}

	public Date getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", iva=" + iva + ", precio=" + precio + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + iva;
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (iva != other.iva)
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		return true;
	}
	
}
	
	