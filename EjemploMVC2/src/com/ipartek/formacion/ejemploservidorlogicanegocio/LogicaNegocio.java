package com.ipartek.formacion.ejemploservidorlogicanegocio;

import com.formacion.ipartek.ejemplomvc.modelo.Usuario;

public class LogicaNegocio {
	
	private LogicaNegocio() {}
	
	public static boolean esValidoUsuario(Usuario usuario) {
		return "mikel@mikel.com".equals(usuario.getEmail()) && "123456".equals(usuario.getPassword());
	}
	
}
