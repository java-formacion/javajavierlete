package com.ipartek.maven.taller.taller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.maven.taller.entidades.Usuario;
import com.ipartek.taller.servicios.UsuarioServicio;

@Path("usuarioResource")
public class UsuarioAPI extends UsuarioServicio{

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario[] getUsuario() {
    	//obtener usuarios
    	Usuario[] usuarios=obtenerTodosUsuarios();
    	return usuarios;
    	
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void InsertUsuario(Usuario usu) {
		insertUsuarioPorObjeto(usu);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void EliminarUsuario(int idUsuario) {
			eliminarUsuarioPorId(idUsuario);
		
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizarUsuairo(int idUsuario,Usuario usu) {
		
			actualizarUsuarioPorId(idUsuario, usu);
		
	}
	
	
}
