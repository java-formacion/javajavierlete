package com.formacion.ipartek.ejemplomvc.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
	
	private static final String INICIO = "WEB-INF/jsps/dashboard.jsp";
	private static final String LOGIN = "WEB-INF/jsps/login.jsp";
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		switch(path) {
			case "/login":
				request.getRequestDispatcher(LOGIN).forward(request, response);
			break;
			default:
				request.getRequestDispatcher(INICIO).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
