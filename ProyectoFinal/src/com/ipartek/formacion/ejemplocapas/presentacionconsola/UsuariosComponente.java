package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class UsuariosComponente {
	private DAOUsuario daoUsuario;
	
	UsuariosComponente(DAOUsuario daoUsuario) {
		super();
		this.daoUsuario = daoUsuario;
	}

	void mostrarUsuario(Usuario usuario) {
		System.out.println("ID\t" + usuario.getId());
		System.out.println("DNI\t" + usuario.getDni());
		System.out.println("Email\t" + usuario.getEmail());
		System.out.println(usuario.getNombre() + " " + usuario.getApellidos());
	}
	
	void mostrarUsuarios() {
		mostrarUsuarios(daoUsuario);
	}
	
	void mostrarUsuarios(DAOUsuario daoUsuario) {
		System.out.println("----INICIO-----");
		
		Usuario[] usuarios = daoUsuario.obtenerUsuarios();
		
		for(Usuario u: usuarios)
			System.out.println(u);
		
		System.out.println("-----FIN------");
	}
}
