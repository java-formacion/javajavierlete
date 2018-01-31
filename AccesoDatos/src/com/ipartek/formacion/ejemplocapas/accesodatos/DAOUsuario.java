package com.ipartek.formacion.ejemplocapas.accesodatos;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public interface DAOUsuario {
	void alta(Usuario usuario);
	void baja(Usuario usuario);
	void modificacion(Usuario usuario);
	
	Usuario[] obtenerUsuarios();
	Usuario obtenerUsuarioPorId(long id);
	Usuario obtenerUsuarioPorEmail(String email);
	//boolean existeUsuarioEMail(String email, String password);
}
