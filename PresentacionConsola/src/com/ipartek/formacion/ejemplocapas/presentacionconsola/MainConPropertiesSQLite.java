package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOFactory;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class MainConPropertiesSQLite {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader("src/ejemplocapas.properties"));

		String url = p.getProperty("accesodatos.url");
		String motor = p.getProperty("accesodatos.motor");

		DAOFactory df = new DAOFactory(motor, url);
		DAOUsuario daoUsuario = df.getDAOUsuario();

		UsuariosComponente uc = new UsuariosComponente(daoUsuario);

		Usuario usuario1 = new Usuario(1, "12345678Z", "javierlete@miemail.com", "contraseña", "Javier", "Lete");

		Usuario usuario2 = new Usuario(2, "12345678Z", "pepeperez@miemail.com", "contraseña", "Pepe", "Pérez");

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
