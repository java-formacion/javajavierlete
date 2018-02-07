package com.ipartek.formacion.ejemplocapas.accesodatos;

import com.ipartek.formacion.ejemplocapas.entidades.Carrito;
import com.ipartek.formacion.ejemplocapas.entidades.Factura;

public interface DAOCarrito {

	void alta(Carrito carrito);
	void baja(Carrito carrito);
	void modificacion(Carrito carrito);
	
	Carrito[] obtenerCarritos();
	
	
}
