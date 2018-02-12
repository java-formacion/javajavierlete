package com.ipartek.formacion.ejemplocapas.entidades;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

public class Factura {

	private final long id;
	private Usuario u;
	private ArrayList<Carrito> c;
	private Date fecha;
	private double iva;
	private double totalSinIva;
	private double totalConIva;
	
	
	public Factura(long id, Usuario u, ArrayList<Carrito> c, Date fecha, double iva, double totalSinIva,
			double totalConIva) {
		super();
		this.id = id;
		this.u = u;
		this.c = c;
		this.fecha = fecha;
		this.iva = iva;
		this.totalSinIva = totalSinIva;
		this.totalConIva = totalConIva;
	}





	public Usuario getU() {
		return u;
	}


	public void setU(Usuario u) {
		this.u = u;
	}


	public ArrayList<Carrito> getC() {
		return c;
	}


	public void setC(ArrayList<Carrito> c) {
		this.c = c;
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


	public double getTotalSinIva() {
		return totalSinIva;
	}


	public void setTotalSinIva(double totalSinIva) {
		this.totalSinIva = totalSinIva;
	}


	public double getTotalConIva() {
		return totalConIva;
	}


	public void setTotalConIva(double totalConIva) {
		this.totalConIva = totalConIva;
	}


	public long getId() {
		return id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(iva);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalConIva);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalSinIva);
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
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(iva) != Double.doubleToLongBits(other.iva))
			return false;
		if (Double.doubleToLongBits(totalConIva) != Double.doubleToLongBits(other.totalConIva))
			return false;
		if (Double.doubleToLongBits(totalSinIva) != Double.doubleToLongBits(other.totalSinIva))
			return false;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Factura [id=" + id + ", u=" + u + ", c=" + c + ", fecha=" + fecha + ", iva=" + iva + ", totalSinIva="
				+ totalSinIva + ", totalConIva=" + totalConIva + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
