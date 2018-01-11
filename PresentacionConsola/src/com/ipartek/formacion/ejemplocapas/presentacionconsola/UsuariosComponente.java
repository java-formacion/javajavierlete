package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarios;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class UsuariosComponente {
	private DAOUsuarios daoUsuario;
	
	//llamada a daousuario dentro de DAOUsuarios
	UsuariosComponente(DAOUsuarios daoUsuario) {
		super();
		this.daoUsuario = daoUsuario;
	}

	//metodo para mostrar usuario
	void mostrarUsuario(Usuario usuario) {
		System.out.println("ID\t" + usuario.getId());
		System.out.println("DNI\t" + usuario.getDni());
		System.out.println("Email\t" + usuario.getEmail());
		//este mostrara el nombre y apellido el uno seguido del otro
		System.out.println(usuario.getNombre() + " " + usuario.getApellidos());
	}
	
	void mostrarUsuarios() {
		mostrarUsuarios(daoUsuario);
	}
	
	//la llamada a esta declaracion añadira un inicio y fin delante y detras
	void mostrarUsuarios(DAOUsuarios daoUsuario) {
		System.out.println("----INICIO-----");
		
		Usuario[] usuarios = daoUsuario.obtenerUsuarios();
		
		for(Usuario u: usuarios)
			System.out.println(u);
		
		System.out.println("-----FIN------");
	}
}