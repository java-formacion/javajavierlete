package com.ipartek.formacion.ejemplocapas.accesodatos;

import com.ipartek.formacion.ejemplocapas.entidades.Factura;

public interface DAOFactura {

	void alta(final Factura factura,long idFactura);
	void baja(final Factura factura,long idFactura);
	void modificacion(final Factura factura);
	
	Factura[] obtenerFacturas();
	Factura obtenerFacturaPorId(long id);
	
	
}
