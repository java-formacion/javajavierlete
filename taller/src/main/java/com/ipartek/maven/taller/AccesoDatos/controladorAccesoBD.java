package com.ipartek.maven.taller.AccesoDatos;
import java.util.ArrayList;

import com.ipartek.maven.taller.AccesoDatos.*;
import com.ipartek.maven.taller.entidades.Coche;
import com.ipartek.maven.taller.entidades.Mecanico;
import com.ipartek.maven.taller.entidades.Usuario;
import com.mysql.fabric.xmlrpc.base.Array;

public class controladorAccesoBD extends tallerBD {

	
	
	//Usuario
	
	
	public Usuario obtenerUsuarioPorId(int id) {
		return obtenerUsuario(id);
	}
	public Usuario[] obtenerTodosUsuarios(){
		return obtenerUsuarios();
	}
	
	public int insertUsuarioPorObjeto(Usuario usu) {
		return insertUsuario(usu);
	}
	
	public int actualizarUsuarioPorId(int id,Usuario usu) {
		return updateUsuario(id, usu);
	}
	
	public int eliminarUsuarioPorId(int id) {
		
		return eliminarUsuario(id);
	}
	
	public int obteneridUsuarioPorDni(String dni) {
		return obtenerUsuarioPordni(dni);
	}
	public Mecanico[] obtenerTodosLosMecanicos() {
		return obtenerTodosMecanico();
	}
	
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
	
	//Relacion
	
	
	public int insertarRelacionCocheMecanicocPasandoIdcocheIdMecanico(int idCoche,int idMecanico) {
		return insertarRelacionCocheMecanico(idCoche, idMecanico);
	}
	
	
	
	
	

	
	
	
	
	
}
