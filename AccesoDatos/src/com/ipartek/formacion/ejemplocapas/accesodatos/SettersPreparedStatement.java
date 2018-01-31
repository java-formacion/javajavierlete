package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SettersPreparedStatement {
	void ejecutar(PreparedStatement ps) throws SQLException;
}
