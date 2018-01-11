package com.ipartek.formacion.ejemplocapas.presentacionconsola;

import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarios;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOUsuarioArrayList;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class Main {
	
	public static void main(String[] args) {
		
		DAOUsuarios daoUsuario = new DAOUsuarioArrayList();
		
		UsuariosComponente uc = new UsuariosComponente(daoUsuario);
		
		//insercion de datos para el usuario 1
		Usuario usuario1 = new Usuario(
				1, 
				"12345678Z", 
				"javierlete@miemail.com", 
				"contraseña", 
				"Javier", 
				"Lete");
		
		//insercion de datos para el usuario 2
		Usuario usuario2 = new Usuario(
				2, 
				"12345678Z", 
				"pepeperez@miemail.com", 
				"contraseña", 
				"Pepe", 
				"Pérez");
		
		//llamada a alta para ambos usuarios
		daoUsuario.alta(usuario1);
		daoUsuario.alta(usuario2);

		//llamada al metodo de mostrar usuarios
		uc.mostrarUsuarios();
		
		//modificacion del email en usuario 2
		usuario2.setEmail("nuevo@email.com");
		daoUsuario.modificacion(usuario2);
		
		uc.mostrarUsuarios();
		
		//llamada para la busqueda del usuario al que le hemos modificado el email
		Usuario usuario = daoUsuario.obtenerUsuarioPorEmail("nuevo@email.com");
		System.out.println("El usuario cuyo email es nuevo... es ");
		
		uc.mostrarUsuario(usuario);
		
		//llamada para mostrar el usuario usando su ID
		usuario = daoUsuario.obtenerUsuarioPorId(1);
		
		System.out.println("Usuario ID = 1 ");
		
		uc.mostrarUsuario(usuario);
		
		//da de baja al usuario con el ID que hemos marcado antes
		daoUsuario.baja(usuario);
		
		uc.mostrarUsuarios();
	}

	

}