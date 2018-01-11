package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioArrayList;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class Main {

	// TODO REVISAR DECLARACION
	private static DAOUsuario daoUsuario;

	public static void main(String[] args) {
		
		UsuariosComponente uc = new (daoUsuario);

		DAOUsuario daoUsuario = new DAOUsuarioArrayList();

		Usuario usuario = new Usuario(1, "12345678Z", "nombre@email.com", "contraseña", "Pepe", "García");

		daoUsuario.alta(usuario);

		mostrarUsuarios(daoUsuario);

		usuario.setEmail("nuevo@email.com");

		daoUsuario.modificacion(usuario);

		mostrarUsuarios();

		// TODO FALTA ELIMINAR USUARIO

	}

}
