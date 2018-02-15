package com.ipartek.jerseyPruebaRest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("usuario")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	private static String url="jdbc:sqlite:C:\\sqliteCRUDUsuariosWS\\crudUsuariosWS.db";
	private static String user="";
	private static String password="";
	
	Daousuario daou = new Daousuario(url, user, password);
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario[] getUsuarios() {
    	
        	try {
				return daou.mostrarUsuarios();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("id") String id) {
    	
    	
        	try {
				return daou.mostrarUsuario(Integer.parseInt(id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insertarUsuario(Usuario u) {
    	
		 try {
			daou.insertarUsuario(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void modificarUsuario(Usuario u) {
    	
    	try {
			daou.modificarUsuario(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public void borrarUsuario(@PathParam("id") String id) {
    	
    	Usuario u = null;
		try {
			u = daou.mostrarUsuario(Integer.parseInt(id));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
			daou.borrarUsuario(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    
}
