package com.ipartek.jersey.pruebaJersey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.ipartek.jersey.pruebaJersey.*;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource extends AccesoRest{
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Usuario obtenerUsuarios(){
		Usuario usu=new Usuario();
		usu.setId(4);
		obtenerUsuario(usu);
		
		return null;
	}
	
}
