package com.ipartek.formacion.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.dataaccess.footballpool.InfoSoapBindingStub;
import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.InfoSoapTypeProxy;
import eu.dataaccess.footballpool.TGameInfo;
import eu.dataaccess.footballpool.TGameResultCode;
import eu.dataaccess.footballpool.TGoal;
import eu.dataaccess.footballpool.TPlayersWithCards;
import eu.dataaccess.footballpool.TTeamInfo;

/**
 * Servlet implementation class ServletPrueba
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Partidos_JSP = "/WEB-INF/jsps/futbol.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }
    private HttpServletRequest request;
	private HttpServletResponse response;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		InfoSoapType soap = new InfoSoapTypeProxy();
		//TPlayersWithCards[] jugadores=soap.allPlayersWithYellowOrRedCards(true, false, false);
		/*for(TPlayersWithCards j: jugadores) {
			System.out.println(j.getSName() + " - " + j.getIYellowCards() + " - " + j.getSTeamName());
		}*/
		
		
		/*for(TGameInfo r: resultados) {
			TTeamInfo t1 = r.getTeam1();
			TTeamInfo t2= r.getTeam2();
			System.out.println(t1.getSCountryFlagLarge()+" "+r.getDPlayDate()+" "+t2.getSName());
			TGoal[] goles = r.getGoals();
			System.out.println("goleadores");
			for(TGoal g:goles) {
				System.out.println(g.getDGame()+" del equipo "+g.getSTeamName());
			}
			System.out.println("-----------------------");
		}*/
		
		ArrayList<TGameInfo> arrayPartidos=com.ipartek.formacion.controler.service.obtenerArraydePartidos(soap);
		this.request = request;
		this.response = response;
		
		HttpSession session = request.getSession();
		session.setAttribute("partido", arrayPartidos);
		fw(Partidos_JSP);
	}
	private void fw(String ruta) throws ServletException, IOException {
		request.getRequestDispatcher(ruta).forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
