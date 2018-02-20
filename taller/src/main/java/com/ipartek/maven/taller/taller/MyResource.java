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
public class MyResource extends controladorAccesoBD{

    

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario[] getIt() {
    	
    	ArrayList<Coche> coches = new ArrayList<Coche>();
    	
    	Mecanico mecanic = new Mecanico(1, "Javier", "Garcia", "56765675x", "678855677", coches);
    	Mecanico mecanic1 = new Mecanico(2, "Ander", "Bilbao", "76565456x", "676545435", coches);
    	
    	ArrayList<Mecanico> mecanicos= new ArrayList<Mecanico>();
    	mecanicos.add(mecanic);
    	mecanicos.add(mecanic1);
    	insertarMecanico(mecanic);
    	
    	Coche coche = new Coche(1, "Audi", "A3", "bi-7898-hj", mecanicos);
    	Usuario usu= new Usuario(1, "iker", "garcia", "76787655", "678856748", coche);
    	insertarCoche(coche, usu.getId());
    	int respuesta=insertUsuarioPorObjeto(usu);
    	switch (respuesta) {
		case 1:
			System.out.println("usuario insertado");
			break;
		case 0:
			System.out.println("El usuario ya existe en la bd");
			break;
		case -1:
			System.out.println("Error al realizar la isercion");
			break;
		default:
			break;
		}
    	eliminarUsuarioPorId(3);
    	Usuario[] usuarios=obtenerTodosUsuarios();
    	
    	return usuarios;
    }
   
    
}
