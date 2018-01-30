package com.formacion.ipartek.ejemplomvc.controladores;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formacion.ipartek.ejemplomvc.modelo.ModeloException;
import com.formacion.ipartek.ejemplomvc.modelo.Usuario;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemploservidorlogicanegocio.LogicaNegocio;

@WebServlet("/frontcontroller/*")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private enum Estado { LOGIN_CORRECTO, LOGIN_INCORRECTO };
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private static final String LOGIN = "/WEB-INF/jsps/login.jsp";
	private static final String PRODUCTOS = "/WEB-INF/jsps/productos.jsp";
	private static final String VISTA_PRODUCTO = "/WEB-INF/jsps/producto.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		this.request = request;
		this.response = response;
		
		switch(path) {
			case "/frontcontroller/":
				
				if(request.getSession(true) == null)
					forward(LOGIN);
				else {
					productosIndex();
					forward(PRODUCTOS);
				}
				
			break;
			case "/frontcontroller/login":
				
				if(request.getSession(true) == null) {
					switch(login()) {
						case LOGIN_CORRECTO:
							productosIndex();
							forward(PRODUCTOS);
						break;
						case LOGIN_INCORRECTO: forward(LOGIN); break;
					}
				}
				else {
					productosIndex();
					forward(PRODUCTOS);
				}
				
			break;
			case "/frontcontroller/productos":
				
				String id = request.getParameter("id");
				
				if(id == null) {
					productosIndex();
					forward(PRODUCTOS);
				}
				else {
					fichaProducto(id);
					forward(VISTA_PRODUCTO);
				}
				
			break;
			default: forward(LOGIN); break;
		}
		
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
		} catch (ModeloException me) {
			errores.put("password", me.getMessage());
		}
		
		if(errores.size() <= 0) {
			
			com.ipartek.formacion.ejemplocapas.entidades.Usuario usuarioEntidad;
			usuarioEntidad = new com.ipartek.formacion.ejemplocapas.entidades.Usuario(0, null, usuario.getEmail(), usuario.getPassword(), null, null);
			
			if(!LogicaNegocio.esValidoUsuario(usuarioEntidad)) {
				errores.put("usuario", "El email y/o contraseña son incorrectos");
			}
			
		}
		
		if(errores.size() > 0) {
			request.setAttribute("usuario", usuario);
			request.setAttribute("errores", errores);
			return Estado.LOGIN_INCORRECTO;
		}
		
		request.getSession(true).setAttribute("usuario", usuario);
		
		return Estado.LOGIN_CORRECTO;
	}
	
	private void productosIndex() {
		Producto[] productos = LogicaNegocio.obtenerProductos();
		
		request.setAttribute("productos", productos);
		
	}
	
	private void fichaProducto(String id) {
		Producto producto = LogicaNegocio.obtenerProductoPorId(id);
		
		request.setAttribute("producto", producto);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void forward (String ruta) throws ServletException, IOException {
		request.getRequestDispatcher(ruta).forward(request, response);
	}

}
