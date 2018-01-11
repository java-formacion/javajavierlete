package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioArrayList;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUusuario;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class Main {

	public static void main(String[] args) {
		DAOUusuario daoUsuario = new DAOUsuarioArrayList();
		
		daoUsuario.alta(
				new Usuario(
						2,
						"12345678z",
						"pepepe@fds.com",
						"contrasena",
						"ander",
						"perez"
						)
				
				);
			
		
		

	}

}
