package com.ipartek.ejemplos.ejemploservidor.negocio;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class LogicaNegocio {
	private LogicaNegocio() {}
	
	public static boolean esValidoUsuario(Usuario usuario) {
		return "javierlete@email.net".equals(usuario.getEmail()) && 
				"Pa$$w0rd".equals(usuario.getPassword());
	}
}