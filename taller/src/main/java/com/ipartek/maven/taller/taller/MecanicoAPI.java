package com.ipartek.maven.taller.taller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.maven.taller.entidades.Mecanico;
import com.ipartek.taller.servicios.MecanicoServicio;

@Path("mecanicoResource")
public class MecanicoAPI extends MecanicoServicio{

	
	@GET
	 @Produces(MediaType.APPLICATION_JSON)
    public Mecanico[] getMecanicos() {
		return obtenerTodosLosMecanicos();
	}
	
	@GET
	 @Produces(MediaType.APPLICATION_JSON)
   public Mecanico[] getMecanicos(int idMecanico) {
		
			return obtenerMecanicoPorId(idMecanico);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    public void insertMecanico(Mecanico mec) {
		insertarMecanico(mec);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	 public void UpsateMecanico(int idMecanico,Mecanico me) {
		actualizarMecanicoPorIdYObjeto(idMecanico, me);
	}
	
	
	
	

	
	
}
