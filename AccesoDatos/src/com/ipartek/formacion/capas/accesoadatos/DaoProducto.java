package com.ipartek.formacion.capas.accesoadatos;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public interface DaoProducto {

	
	

	void alta(Producto producto);
	void baja(Producto producto);
	void modificacion(Producto producto);
	
	
	Producto[] obtenerProductos();
	Producto obtenerProductoPorId(long id);
	
	
	
	
}
