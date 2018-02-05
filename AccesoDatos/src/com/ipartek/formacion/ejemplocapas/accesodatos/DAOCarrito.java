package com.ipartek.formacion.ejemplocapas.accesodatos;

import com.ipartek.formacion.ejemplocapas.entidades.Carrito;

public interface DAOCarrito {

	void alta(Carrito carrito);
	void baja(Carrito carrito);
	void modificacion(Carrito carrito);
	
	void sumarCantidadAlProducto(Long idProducto);
	
	long obtenerCantidadProductoPorIdProducto(Long idProducto);
	Carrito[] obetnerCarritos();
	Carrito obetenerCarritoPorId(Long idCarrito);
	
}
