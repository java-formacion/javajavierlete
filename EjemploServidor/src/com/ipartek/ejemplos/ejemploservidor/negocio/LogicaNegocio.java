package com.ipartek.ejemplos.ejemploservidor.negocio;

import com.ipartek.ejemplos.ejemploservidor.modelo.Usuario;

public class LogicaNegocio {
	
	private LogicaNegocio() {
	}

	public static boolean validarUsuario(Usuario usuario) {
		return "javierlete@email.net".equals(usuario.getEmail()) && "contra".equals(usuario.getPassword());
	}
}