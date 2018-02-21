package com.ipartek.maven.taller.taller;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.maven.taller.AccesoDatos.controladorAccesoBD;
import com.ipartek.maven.taller.entidades.Coche;

@Path("coche")
public class CocheAPI extends controladorAccesoBD{

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Coche[] getCoche(@PathParam("id") int id) {
			return obtenerCochePorId(id);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void insertarCoche(Coche co,String dni) {
		int idUsuario=obteneridUsuarioPorDni(dni);
		
		switch (idUsuario) {
		case 0:
			System.out.println("idCoche no encontrado");
			break;
		case -1:
			System.out.println("error");
			break;
		default:
			insertarCochePasandoOcocheyIdUsuario(co, idUsuario);
			break;
		}
		
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCoche(@PathParam("id") int id) {
		
			eliminarCochePorId(id);
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void updateCoche(Coche co,String matricula) {
		int idCoche = obtenerIdCochePasandoMatricula(matricula);
		actualizarCoche(idCoche, co);
	}
	
	
	
	
	
	
}
