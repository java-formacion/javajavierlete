package com.ipartek.formacion.ejemplos.ejemploservidor.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Hola", urlPatterns = { "/hola" })
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nombre = request.getParameter("nombre");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>¡Hola Mundo!</title>");
        out.println("</head>");
        out.println("<body>");
        
        if(nombre == null)
        	out.println("<h1>¡Hola Mundo!</h1>");
        else if(nombre.trim().isEmpty()) //JAVA6 (1.6)
        	out.println("<h1>Hola tímido</h1>");
        else
        	out.println("<h1>¡Hola " + nombre.replaceAll("<", "&lt;") + "!</h1>");
        
        out.println(new java.util.Date());
        out.println("Served at: ");
        out.println(request.getContextPath());
        out.println("</body>");
        out.println("</html>");
		
	}

}
