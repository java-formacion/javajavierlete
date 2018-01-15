package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioJDBC;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class MainConSQLite {

	public static void main(String[] args) {

		DAOUsuario daoUsuario = new DAOUsuarioJDBC("jdbc:sqlite:..\\AccesoDatos\\bdd\\ejemplocapas.s3db");

		daoUsuario.alta(new Usuario(0, "12345678Z", "yepa@email.com", "contraseña", "Javier", "Lete"));

		Usuario[] usuarios = daoUsuario.obtenerUsuarios();

		for (Usuario u : usuarios) {
			System.out.println(u);
		}
	}

}
