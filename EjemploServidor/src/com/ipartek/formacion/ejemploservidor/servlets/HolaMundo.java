package com.ipartek.formacion.ejemploservidor.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class HolaMundo
 */
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hola Mundo!!</title>");
		out.println("</head>");
		out.println("<html>");
		out.println("<body>");
		if(nombre == null)
			out.println("<h1> HOLA MUNDO</h1>");
		else if(nombre.trim().length() == 0) //nombre.trim().isEmpty()) hace lo mismo en java 6 (1.6) en adelante
			out.print("<h1> HOLA timido</h1>");
		else
			out.println("<h1> HOLA "+ nombre +"</h1>");
		out.print(new java.util.Date());
		out.println(request.getContextPath());
		out.println("</body>");
		out.println("</html>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
