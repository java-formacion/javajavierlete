package com.ipartek.formacion.ejemplocapas.presentacioncosola;

import com.ipartek.formacion.ejemplocapas.accesodatos.*;
import com.ipartek.formacion.ejemplocapas.entidades.*;


public class UsuariosComponente {
private DAOUusuario daoUsuario;
	
	UsuariosComponente(DAOUusuario daoUsuario) {
		super();
		this.daoUsuario = daoUsuario;
	}

	void mostrarUsuario(Usuario usuario) {
		System.out.println("ID\t" + usuario.getId());
		System.out.println("DNI\t" + usuario.getDni());
		System.out.println("Email\t" + usuario.getEmail());
		System.out.println(usuario.getNombre() + " " + usuario.getApellido());
	}
	
	void mostrarUsuarios() {
		mostrarUsuarios(daoUsuario);
	}
	
	void mostrarUsuarios(DAOUusuario daoUsuario) {
		System.out.println("----INICIO-----");
		
		Usuario[] usuarios = daoUsuario.obtenerUsuarios();
		
		for(Usuario u: usuarios)
			System.out.println(u);
		
		System.out.println("-----FIN------");
	}
}
