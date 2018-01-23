package com.ipartek.formacion.ejemploservidor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemploservidor.modelo.Usuario;
import com.ipartek.formacion.ejemploservidor.negocio.LogicaNegocio;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(request.getParameter("nombre"));
		usuario.setPassword(request.getParameter("pass"));;
		
		if(LogicaNegocio.validarUsuario(usuario))
			response.sendRedirect("ok.html");
		else
			response.sendRedirect("error.html");
		
		
		
	}

}
