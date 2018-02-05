package com.ipartek.formacion.ejemplocapas.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class Factura {

	private final long id;
	private long numeroFactura;
	private Date fecha;
	private com.ipartek.formacion.ejemplocapas.entidades.Usuario u;
	ArrayList<Carrito> carrito = new ArrayList<Carrito>();
	private double iva;
	private double importe;
	private double total;
	
	public Factura(long id, long numeroFactura, Date fecha, Usuario u, ArrayList<Carrito> carrito, double iva,
			double importe, double total) {
		super();
		this.id = id;
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		this.u = u;
		this.carrito = carrito;
		this.iva = iva;
		this.importe = importe;
		this.total = total;
	}

	public long getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public com.ipartek.formacion.ejemplocapas.entidades.Usuario getU() {
		return u;
	}

	public void setU(com.ipartek.formacion.ejemplocapas.entidades.Usuario u) {
		this.u = u;
	}

	public ArrayList<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Carrito> carrito) {
		this.carrito = carrito;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", numeroFactura=" + numeroFactura + ", fecha=" + fecha + ", u=" + u + ", carrito="
				+ carrito + ", iva=" + iva + ", importe=" + importe + ", total=" + total + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrito == null) ? 0 : carrito.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(importe);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(iva);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (numeroFactura ^ (numeroFactura >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((u == null) ? 0 : u.hashCode());
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
		if (carrito == null) {
			if (other.carrito != null)
				return false;
		} else if (!carrito.equals(other.carrito))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(importe) != Double.doubleToLongBits(other.importe))
			return false;
		if (Double.doubleToLongBits(iva) != Double.doubleToLongBits(other.iva))
			return false;
		if (numeroFactura != other.numeroFactura)
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		return true;
	}
	
	

	
	
	
}