package com.ipartek.formacion.ejemplomvc.controladores;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.ejemploservidor.modelo.ModeloException;
import com.ipartek.ejemplos.ejemploservidor.modelo.Usuario;
import com.ipartek.ejemplos.ejemploservidor.negocio.LogicaNegocio;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;

@WebServlet("/frontcontroller/*")
public class IndexServlet extends HttpServlet {
	private static final String LOGIN_JSP = "/WEB-INF/jsps/login.jsp";
	
	private static final long serialVersionUID = 1L;

	private static final String BIENVENIDA_JSP = "/WEB-INF/jsps/bienvenida.jsp";
	private static final String PRODUCTOS_JSP = "/WEB-INF/jsps/productos.jsp";
	
	private enum Estado { LOGIN_CORRECTO, LOGIN_INCORRECTO }; 
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().println(request.getServletPath());
		this.request = request; this.response = response;
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		switch(path) {
		case "/frontcontroller/":
			fw(LOGIN_JSP);
			break;
		case "/frontcontroller/login":
			switch(login()) {
			case LOGIN_CORRECTO: productosIndex(); fw(PRODUCTOS_JSP); break;
			case LOGIN_INCORRECTO: fw(LOGIN_JSP); break;
			}
			break;
		default:
			response.getWriter().println(request.getServletPath());
		}
	}

	private void productosIndex() {
		Producto[] productos = LogicaNegocio.obtenerProductos();
		
		request.setAttribute("productos", productos);
	}

	private Estado login() {
		Hashtable<String, String> errores = new Hashtable<>();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario();
		
		try {
			usuario.setEmail(email);
		} catch (ModeloException me) {
			errores.put("email", me.getMessage());
		}
		
		try {
			usuario.setPassword(password);
		} catch(ModeloException me) {
			errores.put("password", me.getMessage());
		}
		
		com.ipartek.formacion.ejemplocapas.entidades.Usuario usuarioEntidad;
		usuarioEntidad = new com.ipartek.formacion.ejemplocapas.entidades.Usuario(0, null, usuario.getEmail(), usuario.getPassword(), null, null);
		
		if(!LogicaNegocio.esValidoUsuario(usuarioEntidad))
			errores.put("usuario", "No es válido ese email y contraseña");

		if(errores.size() > 0) {
			request.setAttribute("usuario", usuario);
			request.setAttribute("errores", errores);
			
			return Estado.LOGIN_INCORRECTO;
		}
		
		request.getSession(true).setAttribute("usuario", usuario);
		
		return Estado.LOGIN_CORRECTO;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void fw(String ruta) throws ServletException, IOException {
		request.getRequestDispatcher(ruta).forward(request, response);
	}
}
