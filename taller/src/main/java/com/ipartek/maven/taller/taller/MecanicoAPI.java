package com.ipartek.maven.taller.taller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.maven.taller.AccesoDatos.controladorAccesoBD;
import com.ipartek.maven.taller.entidades.Mecanico;

@Path("mecanicoResource")
public class MecanicoAPI extends controladorAccesoBD{

	
	@GET
	 @Produces(MediaType.APPLICATION_JSON)
    public Mecanico[] getMecanicos() {
		return obtenerTodosLosMecanicos();
	}
	
	@GET
	 @Produces(MediaType.APPLICATION_JSON)
   public Mecanico[] getMecanicos(String dni) {
		int idMecanico=obtenerIDMecanicoPasandoDni(dni);
		if(idMecanico != 0 && idMecanico != -1) {
			return obtenerMecanicoPorId(idMecanico);
		}else {return null;}
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    public void insertMecanico(Mecanico mec) {
		insertarMecanico(mec);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	 public void UpsateMecanico(String dni,Mecanico me) {
		
		int idMecanico=obtenerIdMecanicoPorDniMecanico(dni);
		
		switch (idMecanico) {
		case 0:
			System.out.println("no se a encontrado ningun idMecanico con este dni");
			break;
			
		case -1:
			System.out.println("error al obtener el idMecanico");
			break;
		default:
			
			break;
		}
		
		actualizarMecanicoPorIdYObjeto(idMecanico, me);
	}
	
	
	
	

	
	
}
