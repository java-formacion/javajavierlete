package com.ipartek.formacion.capas.accesoadatos;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public interface DaoUsuario {

	
	
	void alta(Usuario usuario);
	void baja(Usuario usuario);
	void modificacion(Usuario usuario);
	
	
	Usuario[] obtenerUsuarios();
	Usuario obtenerUsuarioPorId(long id);
	Usuario obtenerUsuarioPorEmail(String email);
	// mejor en logica de negocios boolean existeUsuarioEmail(String email, String password);
}
