package com.ipartek.maven.taller.taller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.maven.taller.AccesoDatos.controladorAccesoBD;
import com.ipartek.maven.taller.entidades.Usuario;

@Path("usuarioResource")
public class UsuarioAPI extends controladorAccesoBD{

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
	public void EliminarUsuario(String dni) {
		int idUsuario= obtenerUsuarioPordni(dni);
		switch (idUsuario) {
		case 0:
			System.out.println("No existe el usuario con ese dni");
			break;
		case -1:
			System.out.println("Error al obtener el id usuario pasando dni");
			break;
		default:
			eliminarUsuarioPorId(idUsuario);
			break;
		}
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizarUsuairo(Usuario usu,String dni) {
		int idUsuario = obteneridUsuarioPorDni(dni);
		switch (idUsuario) {
		case 0:
			System.out.println("No existe el usuario con ese dni");
			break;
		case -1:
			System.out.println("Error al obtener el id usuario pasando dni");
			break;
		default:
			actualizarUsuarioPorId(3, usu);
			break;
		}
	}
	
	
}
