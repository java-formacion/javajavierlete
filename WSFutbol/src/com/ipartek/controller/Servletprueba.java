package com.ipartek.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.services.servicioTodosPartidos;

import eu.dataaccess.footballpool.InfoSoapBindingStub;
import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.InfoSoapTypeProxy;
import eu.dataaccess.footballpool.TGameInfo;
import eu.dataaccess.footballpool.TGoal;
import eu.dataaccess.footballpool.TPlayersWithCards;
import eu.dataaccess.footballpool.TTeamInfo;

/**
 * Servlet implementation class Servletprueba
 */
@WebServlet("/prueba")
public class Servletprueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servletprueba() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*
		if(request.getAttribute("partidosr") != null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		*/
		InfoSoapType soap = new InfoSoapTypeProxy();
		TGameInfo[] partidosEuro = soap.allGames();
		
		//HttpSession session = request.getSession();
		request.setAttribute("partidos", partidosEuro);
		//session.setAttribute("partidos", partidosEuro);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
