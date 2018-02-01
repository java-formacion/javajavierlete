package com.ipartek.formacion.ejemplocapas.accesodatos;

import com.ipartek.formacion.ejemplocapas.entidades.Factura;

public interface DAOFactura {
	void alta(Factura factura);
	void baja(Factura factura);
	void modificacion(Factura factura);
	
	Factura[] obtenerFactura();
	Factura obtenerPFacturaPorId(long id);
	//Factura[] obtenerFacturasPorNombreParcial(String nombreParcial);
}
