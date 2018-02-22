package com.ipartek.maven.taller.taller;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.taller.servicios.CocheMecanicoServicio;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class CocheMecanicoAPI extends CocheMecanicoServicio{

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public int insertarCocheMecanico(int idCoche,int idMecanico) {
		
			int resultado=insertarRelacionCocheMecanicocPasandoIdcocheIdMecanico(idCoche, idMecanico);
			return resultado;
		
	}
    
    
    

}
