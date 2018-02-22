package com.ipartek.taller.servicios;

import com.ipartek.maven.taller.AccesoDatos.CocheMecanicoBD;

public class CocheMecanicoServicio extends CocheMecanicoBD{

	//Relacion
	
		public int insertarRelacionCocheMecanicocPasandoIdcocheIdMecanico(int idCoche,int idMecanico) {
			return insertarRelacionCocheMecanico(idCoche, idMecanico);
		}
}
