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
import com.ipartek.formacion.controler.*;

/**
 * Servlet implementation class ServletPrueba
 */
@WebServlet("/ServletPartidos")
public class ServletPartidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Partidos_JSP = "/WEB-INF/jsps/futbol.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPartidos() {
        super();
        // TODO Auto-generated constructor stub
    }
    private HttpServletRequest request;
	private HttpServletResponse response;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	PartidoService partidoService;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		partidoService = new PartidoService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TGameInfo[] partidos = partidoService.getPartidos();
		
		//Opcion 1:
		request.getSession().setAttribute("partido", partidos);
		
		
		//obcion 2: Esta opcion es mejor en este caso!!!!
		//request.setAttribute("partido", partidos);
		//request.getRequestDispatcher("WEB-INF/partidos.jsp").forward(request, response);
		
		fw(Partidos_JSP,request,response);
	}
	private void fw(String ruta,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(ruta);
		request.getRequestDispatcher(ruta).forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
