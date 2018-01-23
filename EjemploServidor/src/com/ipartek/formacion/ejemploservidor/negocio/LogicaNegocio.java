package com.ipartek.formacion.ejemploservidor.negocio;

import com.ipartek.formacion.ejemploservidor.modelo.Usuario;

public class LogicaNegocio {

	private LogicaNegocio() { //para que nadie pueda instanciarla, vamos a usar todo metodos static
		
	}
	
	public static boolean validarUsuario (Usuario u) {
		
		
		
		
		return "bortx10".equalsIgnoreCase(u.getEmail()) && "pass".equalsIgnoreCase(u.getPassword());
	}
}
