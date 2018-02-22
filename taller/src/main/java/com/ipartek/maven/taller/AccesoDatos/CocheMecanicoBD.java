package com.ipartek.maven.taller.AccesoDatos;

import java.sql.SQLException;

public class CocheMecanicoBD extends ConexionBD{

	//Tabla relacion
		public int insertarRelacionCocheMecanico(int idCoche,int idMecanico) {
			try {
					CrearConexion();
					ps = con.prepareStatement("INSERT INTO coches_has_mecanicos(coches_idCoche,mecanicos_idMecanico) values (?,?)");
					ps.setInt(1, idCoche);
					ps.setInt(2, idMecanico);
					ps.executeUpdate();
					return 1;
					
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			} finally {
				cerrarConexion();
			}
		}


}
