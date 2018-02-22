package com.ipartek.taller.servicios;

import com.ipartek.maven.taller.AccesoDatos.CocheBD;
import com.ipartek.maven.taller.entidades.Coche;

public class CocheServicio extends CocheBD{

	//Coches
	
		public int EliminarLosCoches() {
			return eliminarTodosLosCoches();
		}
		
		public Coche[] obtenerCochePorId(int id) {
			return obtenerCoche(id);
		}
		
		public int insertarCochePasandoOcocheyIdUsuario(Coche co,int idUsuario) {
			return insertarCoche(co,idUsuario);
		}
		
		public int eliminarCochePorId(int id) {
			return eliminarCoche(id);
		}
		
		public int actualizarCoche(int id, Coche co) {
			return updateCoche(id, co);
		}
		
		public int obtenerIdCochePasandoMatricula(String matricula) {
			return obtenerIdCochePorMatricula(matricula);
		}
}
