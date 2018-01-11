package com.ipartek.formacion.ejemplocapas.presentacionporconsola;

import com.ipartek.formacion.capas.accesoadatos.DaoUsuario;
import com.ipartek.formacion.capas.accesoadatos.DaoUsuariosArraylist;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class Main {

	private static DaoUsuario daoUsuario;	
	
	public static void main(String[] args) {
		
		daoUsuario = new DaoUsuariosArraylist();
		
		daoUsuario.alta(new Usuario(1, "16055865J", "borja@gmail.com", "123456789", "Borja", "Gonzalez"));
		daoUsuario.alta(new Usuario(2, "54789658F", "luffy@gmail.com", "123456789", "Luffy", "Gonzalez"));
		
		mostrarUsuario();

	}

	private static void mostrarUsuario() {
		Usuario[] usuarios = daoUsuario.obtenerUsuarios();
		
		System.out.println("------- INICIO-----------");
		for(Usuario u : usuarios)
			System.out.println(u);
		
		
		System.out.println("------- FIN -----------");
	}

}
