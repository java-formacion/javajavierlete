package com.ipartek.maven.taller.taller;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.maven.taller.entidades.Coche;
import com.ipartek.taller.servicios.CocheServicio;

@Path("coche")
public class CocheAPI extends CocheServicio{

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Coche[] getCoche(@PathParam("id") int id) {
			return obtenerCochePorId(id);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public int insertarCoche(Coche co,int  id) {
		
			int resultado=insertarCochePasandoOcocheyIdUsuario(co, id);
			return resultado;
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
