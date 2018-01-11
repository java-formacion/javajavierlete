package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuario;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioArrayList;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class Main {
	
	public static void main(String[] args) {
		DAOUsuario daoUsuario = new DAOUsuarioArrayList();
		
		UsuariosComponente uc = new UsuariosComponente(daoUsuario);
		
		Usuario usuario1 = new Usuario(
				1, 
				"12345678Z", 
				"javierlete@miemail.com", 
				"contraseña", 
				"Javier", 
				"Lete");
		
		Usuario usuario2 = new Usuario(
				2, 
				"12345678Z", 
				"pepeperez@miemail.com", 
				"contraseña", 
				"Pepe", 
				"Pérez");
		
		daoUsuario.alta(usuario1);
		
		daoUsuario.alta(usuario2);

		uc.mostrarUsuarios();
		
		usuario2.setEmail("nuevo@email.com");
		
		daoUsuario.modificacion(usuario2);
		
		uc.mostrarUsuarios();
		
		Usuario usuario = daoUsuario.obtenerUsuarioPorEmail("nuevo@email.com");
		
		System.out.println("El usuario cuyo email es nuevo... es ");
		
		uc.mostrarUsuario(usuario);
		
		usuario = daoUsuario.obtenerUsuarioPorId(1);
		
		System.out.println("Usuario ID = 1 ");
		
		uc.mostrarUsuario(usuario);
		
		daoUsuario.baja(usuario);
		
		uc.mostrarUsuarios();
	}

	

}
