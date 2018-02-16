package com.ipartek.maven.taller.AccesoDatos;
import com.ipartek.maven.taller.AccesoDatos.*;
import com.ipartek.maven.taller.entidades.Coche;
import com.ipartek.maven.taller.entidades.Mecanico;
import com.ipartek.maven.taller.entidades.Usuario;

public class controladorAccesoBD extends tallerBD {

	public Usuario obtenerUsuarioPorId(int id) {
		return obtenerUsuario(id);
	}
	
	public int insertUsuarioPorObjeto(Usuario usu) {
		return insertUsuario(usu);
	}
	
	public int eliminarUsuarioPorId(int id) {
		
		return eliminarUsuario(id);
	}
	
	public int actualizarUsuarioPorId(int id,Usuario usu) {
		return updateUsuario(id, usu);
	}
	
	public Coche obtenerCochePorId(int id) {
		return obtenerCoche(id);
	}
	
	public int isertarCoche(Coche co) {
		return insertarCoche(co);
	}
	
	public int eliminarCoche(int id) {
		return eliminarCoche(id);
	}

	public int actualizarCoche(int id, Coche co) {
		return updateCoche(id, co);
	}
	
	public Mecanico obtenerMecanicoPorId(int id) {
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
	
	
}
