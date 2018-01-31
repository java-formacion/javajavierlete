package com.ipartek.formacion.ejemplocapas.entidades;

import java.util.Date;

public class Factura {

	private final long id;
	private long numeroFactura;
	private Date fecha;
	
	public Factura(long id, long numeroFactura, Date fecha) {
		super();
		this.id = id;
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
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

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (numeroFactura ^ (numeroFactura >>> 32));
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
		if (numeroFactura != other.numeroFactura)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", numeroFactura=" + numeroFactura + ", fecha=" + fecha + "]";
	}
	
	
}
