package com.ipartek.formacion.ejemplocapas.accesodatos;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public interface DAOProducto {
	void alta(Producto producto);
	void baja(Producto producto);
	void modificacion(Producto producto);
	
	Producto[] obtenerProductos();
	Producto obtenerProductoPorId(long id);
	Producto[] obtenerProductosPorNombreParcial(String nombreParcial);
}
