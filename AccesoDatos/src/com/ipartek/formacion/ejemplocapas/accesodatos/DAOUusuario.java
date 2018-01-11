package com.ipartek.formacion.ejemplocapas.accesodatos;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

//DAO -->Data access 

public interface DAOUusuario {
	
	//para que no de error hay que referenciar un proyecto con otro con fix proyect setup (se ve en el asistente). 
	//si pones solo el import da error.
	void alta(Usuario usuario);
	void baja(Usuario usuario);
	void modificacion(Usuario usuario);
	
	Usuario [] obtenerUsuarios();
	Usuario obtenerUsuariosPorId(long id);
	Usuario obtenerUsuariosPorEmail(String email);
	//boolean validarUsuarioEmail (String email, String password);
	
}
