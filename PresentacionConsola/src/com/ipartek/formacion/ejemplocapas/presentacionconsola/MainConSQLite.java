package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioJDBC;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class MainConSQLite {

	public static void main(String[] args) {

		DAOUsuario daoUsuario = new DAOUsuarioJDBC("jdbc:sqlite:..\\AccesoDatos\\bdd\\ejemplocapas.s3db");

		UsuariosComponente uc = new UsuariosComponente(daoUsuario);

		Usuario usuario1 = new Usuario(1, "12345678Z", "javierlete@miemail.com", "contrase�a", "Javier", "Lete");

		Usuario usuario2 = new Usuario(2, "12345678Z", "pepeperez@miemail.com", "contrase�a", "Pepe", "P�rez");

		daoUsuario.alta(usuario1);

		daoUsuario.alta(usuario2);

		uc.mostrarUsuarios();

		Usuario usuario = daoUsuario.obtenerUsuarioPorEmail("pepeperez@miemail.com");

		System.out.println("El usuario cuyo email es nuevo... es ");

		uc.mostrarUsuario(usuario);

		usuario.setNombre("Nuevo");
		usuario.setApellidos("Nuevez");

		daoUsuario.modificacion(usuario);

		uc.mostrarUsuarios();

		usuario = daoUsuario.obtenerUsuarioPorId(usuario.getId());

		System.out.println("Usuario por ID");

		uc.mostrarUsuario(usuario);

		daoUsuario.baja(usuario);

		daoUsuario.baja(daoUsuario.obtenerUsuarioPorEmail("javierlete@miemail.com"));

		uc.mostrarUsuarios();
	}

}
