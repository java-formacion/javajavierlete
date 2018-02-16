package ipartek.formacion.taller.tallerRest;

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
@Path("taller")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	private static String url="jdbc:sqlite:C:\\BDD\\taller.db";
	private static String user="";
	private static String password="";
	
	DaoUsuario daou = new DaoUsuario(url, user, password);
	DaoCoche daoc = new DaoCoche(url, user, password);
	DaoMecanico daom = new DaoMecanico(url, user, password);
	
	
  
    
    @GET
    @Path("/coche")
    @Produces(MediaType.APPLICATION_JSON)
    public Coche[] getCoches() {
    	
        	try {
				return daoc.mostrarCoches();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
    }
    
    @GET
    @Path("/mecanico")
    @Produces(MediaType.APPLICATION_JSON)
    public Mecanico[] getMecanicos() {
    	
        	try {
				return daom.mostrarMecanicos();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
    }
    
    @GET
    @Path("/usuario")
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
    @Path("/coche/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Coche getCoche(@PathParam("id") int id) {
    	
    	
        	try {
				return daoc.mostrarCoche(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
    }
    
    @GET
    @Path("/mecanico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mecanico getMecanico(@PathParam("id") int id) {
    	
    	
        	try {
				return daom.mostrarMecanico(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
    }
    
    @GET
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("id") int id) {
    	
    	
        	try {
				return daou.mostrarUsuario(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
    }
    
    @POST
    @Path("/coche")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insertarCoche(Coche c) {
    	
		 try {
			daoc.insertarCoche(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    @POST
    @Path("/mecanico")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insertarMecanico(Mecanico m) {
    	
		 try {
			daom.insertarMecanico(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    @POST
    @Path("/usuario")
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
    @Path("/coche")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void modificarCoche(Coche c) {
    	
    	try {
			daoc.modificarCoche(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @PUT
    @Path("/mecanico")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void modificarMecanico(Mecanico m) {
    	
    	try {
			daom.modificarMecanico(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @PUT
    @Path("/usuario")
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
    @Path("/coche/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public void borrarCoche(@PathParam("id") int id) {
    	
    	Coche c = null;
		try {
			c = daoc.mostrarCoche((id));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
			daoc.borrarCoche(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @DELETE
    @Path("/mecanico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public void borrarMecanico(@PathParam("id") int id) {
    	
    	Mecanico m = null;
		try {
			m = daom.mostrarMecanico(id);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
			daom.borrarMecanico(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @DELETE
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public void borrarUsuario(@PathParam("id") int id) {
    	
    	Usuario u = null;
		try {
			u = daou.mostrarUsuario(id);
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
