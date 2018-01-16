package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;

public interface SettersPreparedStatement {
	void ejecutar(PreparedStatement ps, Producto producto) throws SQLException;
}
