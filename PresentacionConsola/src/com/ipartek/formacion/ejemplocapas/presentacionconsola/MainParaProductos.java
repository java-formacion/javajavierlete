package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import java.math.BigDecimal;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOProducto;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOProductoArrayList;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public class MainParaProductos {

	public static void main(String[] args) {

		DAOProducto daoProducto = new DAOProductoArrayList();

		ProductosComponente pc = new ProductosComponente(daoProducto);

		for (int i = 1; i <= 3; i++) {
			daoProducto.alta(new Producto(i, "Producto" + i, "Descripción" + i, new BigDecimal("" + i + i + "." + i + i)));
		}

		pc.mostrarProductos();

		Producto producto2 = daoProducto.obtenerProductoPorId(1);

		pc.mostrarProducto(producto2);

		producto2.setNombre("MODIFICADO");
		producto2.setPrecio(new BigDecimal("50.50"));

		daoProducto.modificacion(producto2);

		pc.mostrarProductos();

		Producto producto1 = new Producto(2, "Producto2", "Descripción2", new BigDecimal("22.22"));

		daoProducto.baja(producto1);

		pc.mostrarProductos();

	}

}
