package com.ipartek.taller.servicios;

import com.ipartek.maven.taller.AccesoDatos.MecanicoBD;
import com.ipartek.maven.taller.entidades.Mecanico;

public class MecanicoServicio extends MecanicoBD{

	//Mecanico
	
		public int obtenerIDMecanicoPasandoDni(String dni) {
			return obtenerIdMecanicoPorDniMecanico(dni);
		}
		
		public Mecanico[] obtenerMecanicoPorId(int id) {
			return obtenerMecanico(id);
		}
		
		public int insertarMecanico(Mecanico me) {
			return insertarMecanicoPorObjeto(me);
		}
		
		public int eliminarMecanicoPorId(int id) {
			return eliminarMecanico(id);
		}
		
		
		public int actualizarMecanicoPorIdYObjeto(int id,Mecanico me) {
			return updatearMecanico(id, me);
		}
		
		public Mecanico[] obtenerTodosLosMecanicos() {
			return obtenerTodosMecanico();
		}
}
