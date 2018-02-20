package com.ipartek.maven.taller.taller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.maven.taller.AccesoDatos.controladorAccesoBD;
import com.ipartek.maven.taller.entidades.Coche;

@Path("usuarioResourse")
public class CocheResource extends controladorAccesoBD{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Coche[] obtenerCoche(String matricula) {
		int idCoche= obtenerIdCochePasandoMatricula(matricula);
		switch (idCoche) {
		case 0:
			System.out.println("no se a encontrado el idcoche");
			break;
		case -1:
			System.out.println("error");
			break;
		default:
			return obtenerCochePorId(idCoche);
		}
		return null;
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
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCoche(String matricula) {
		int idCoche = obtenerIdCochePasandoMatricula(matricula);
		switch (idCoche) {
		case 0:
			System.out.println("idCoche no encontrado");
			break;
		case -1:
			System.out.println("error");
			break;
		default:
			eliminarCochePorId(idCoche);
			break;
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void updateCoche(Coche co,String matricula) {
		int idCoche = obtenerIdCochePasandoMatricula(matricula);
		actualizarCoche(idCoche, co);
	}
	
	
	
	
	
	
}
