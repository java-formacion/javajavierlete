package com.ipartek.formacion.ejemplocapas.entidades;

import java.sql.Date;

public class Factura {
	
	private final long id;
	private final int IVA;
	private final float precioTotal;
	private final Date fechaFactura;
	
	public Factura(long id, int iVA, float precioTotal, Date fechaFactura) {
		super();
		this.id = id;
		IVA = iVA;
		this.precioTotal = precioTotal;
		this.fechaFactura = fechaFactura;
	}
	
	public long getId() {
		return id;
	}
	
	public int getIVA() {
		return IVA;
	}
	
	public float getPrecioTotal() {
		return precioTotal;
	}
	
	public Date getFechaFactura() {
		return fechaFactura;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IVA;
		result = prime * result + ((fechaFactura == null) ? 0 : fechaFactura.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Float.floatToIntBits(precioTotal);
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
		if (IVA != other.IVA)
			return false;
		if (fechaFactura == null) {
			if (other.fechaFactura != null)
				return false;
		} else if (!fechaFactura.equals(other.fechaFactura))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(precioTotal) != Float.floatToIntBits(other.precioTotal))
			return false;
		return true;
	}
	
	

}