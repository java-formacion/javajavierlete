package com.ipartek.formacion.ejemplocapas.presentacioncosola;

import com.ipartek.formacion.ejemplocapas.accesodatos.*;
import com.ipartek.formacion.ejemplocapas.entidades.*;

public class Main {
	
	
	private static DAOUusuario daoUsuario = new DAOUsuarioArrayList();

	public static void main(String[] args) {

		
		UsuariosComponente uc = new UsuariosComponente(daoUsuario);

		Usuario usuario1 = new Usuario(1, "45665487S", "lol@gtn.es", "contraseña","Judit", "Herrero");
		Usuario usuario2 = new Usuario(1, "42225487S", "oytd@gtn.es", "contraseña","Lola", "Herrera");

		daoUsuario.alta(usuario1);
		daoUsuario.alta(usuario2);

		uc.mostrarUsuarios();

		usuario2.setEmail("PEPA@email.com");

		daoUsuario.modificacion(usuario2);

		uc.mostrarUsuarios();

		Usuario usuario = daoUsuario.obtenerUsuariosPorEmail(usuario2.getEmail());

		System.out.println("El usuario cuyo email es nuevo... es ");

		uc.mostrarUsuario(usuario);

		usuario = daoUsuario.obtenerUsuariosPorId(1);

		System.out.println("Usuario ID = 1 ");

		uc.mostrarUsuario(usuario);

		daoUsuario.baja(usuario);

		uc.mostrarUsuarios();
	}

}

// Usuario usuario1 = new Usuario(1, "45665487S", "lol@gtn.es", "contraseña",
// "Judit", "Herrero");
// Usuario usuario2 = new Usuario(1, "42225487S", "oytd@gtn.es", "contraseña",
// "Lola", "Herrera");

// daoUsuario.alta(usuario1);
// daoUsuario.alta(usuario2);
// mostrarUsuarios();

/// usuario2.setEmail("nuevo@gn.com");
// daoUsuario.modificacion(usuario2);
// mostrarUsuarios();

// daoUsuario.baja(usuario1);
// mostrarUsuarios();

// }

// private static void mostrarUsuarios() {
// mostrarUsuarios(daoUsuario);
// }

// private static void mostrarUsuarios(DAOUusuario daoUsuario) {
// System.out.println("---INICIO-----");

// Usuario[] usuarios = daoUsuario.obtenerUsuarios();

// for (Usuario u : usuarios)
// System.out.println(u);

// System.out.println("---FIN-------");
// }

// }
