package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class UsuariosComponente {

	private DAOUsuario daoUsuario;

	UsuariosComponente(DAOUsuario daoUsuario) {
		super();
		this.daoUsuario = daoUsuario;
	}

	void mostrarUsuarios() {
		mostrarUsuarios(daoUsuario);
	}

	void mostrarUsuarios(DAOUsuario daoUsuario) {
		Usuario[] usuarios = daoUsuario.obtenerUsuarios();

		for (Usuario u : usuarios) {
			System.out.println(u);
		}
		System.out.println("-------------");
	}

}
