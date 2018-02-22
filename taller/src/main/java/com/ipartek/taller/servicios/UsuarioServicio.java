package com.ipartek.taller.servicios;

import com.ipartek.maven.taller.entidades.Mecanico;
import com.ipartek.maven.taller.entidades.Usuario;
import com.ipartek.maven.taller.AccesoDatos.UsuarioBD;

public class UsuarioServicio extends UsuarioBD{

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
		
		
	
}
