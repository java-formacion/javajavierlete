package com.ipartek.services;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.InfoSoapTypeProxy;
import eu.dataaccess.footballpool.TGameInfo;

/**
 * Servlet implementation class servicioTodosPartidos
 */
@WebServlet("/servicioTodosPartidos")
public class servicioTodosPartidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servicioTodosPartidos() {
       

		InfoSoapType soap = new InfoSoapTypeProxy();
		
		try {
			TGameInfo[] partidosEuro = soap.allGames();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//HttpSession session = request.getSession();
		//request.setAttribute("partidos", partidosEuro);
		//session.setAttribute("partidos", partidosEuro);
    	
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		InfoSoapType soap = new InfoSoapTypeProxy();
		TGameInfo[] partidosEuro = soap.allGames();
		
		//HttpSession session = request.getSession();
		request.setAttribute("partidos", partidosEuro);
		//session.setAttribute("partidos", partidosEuro);
		
		request.getRequestDispatcher("/Servletprueba.java").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
