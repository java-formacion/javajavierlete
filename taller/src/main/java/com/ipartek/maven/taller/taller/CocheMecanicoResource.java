package com.ipartek.maven.taller.taller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.ipartek.maven.taller.AccesoDatos.controladorAccesoBD;
import com.ipartek.maven.taller.entidades.*;
import com.mysql.fabric.xmlrpc.base.Array;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class CocheMecanicoResource extends controladorAccesoBD{

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void insertarCocheMecanico(String matricula,String dni) {
		int idCoche= obtenerIdCochePasandoMatricula(matricula);
		int idMecanico= obtenerIDMecanicoPasandoDni(dni);
		int con=0;
		int con1=0;
		switch (idCoche) {
		case 0:
			System.out.println("idCoche no encontrado");
			break;
		case -1:
			System.out.println("Error");
			break;
		default:
			con++;
			break;
		}
		
		switch (idMecanico) {
		case 0:
			System.out.println("idMecanico no encontrado");
			break;
		case -1:
			System.out.println("Error");
			break;
		default:
			con1++;
			break;
		}
		
		if(con>0 && con1>0) {
			insertarRelacionCocheMecanicocPasandoIdcocheIdMecanico(idCoche, idMecanico);
		}
		
	}
    
    
    

}
