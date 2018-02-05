package com.ipartek.formacion.ejemplomvc.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.ant.SessionsTask;


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

	private static final String FICHA_JSP = "/WEB-INF/jsps/ficha.jsp";

	private static final String CARRITO_JSP = "/WEB-INF/jsps/carrito.jsp";
	
	private static final String FACTURA_JSP = "/WEB-INF/jsps/factura.jsp";
	
	private static final String FACTURA_CREADA_JSP = "/WEB-INF/jsps/facturaCreada.jsp";
	
	private enum Estado { LOGIN_CORRECTO, LOGIN_INCORRECTO }; 
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().println(request.getServletPath());
		this.request = request; this.response = response;
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		String id;
		
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
		case "/frontcontroller/productos":
			id = request.getParameter("id");
			if(id == null) {
				productosIndex(); fw(PRODUCTOS_JSP);
			}
			else {
				fichaIndex(id); fw(FICHA_JSP);
			}
			break;
		case "/frontcontroller/carrito":
			id = request.getParameter("id");
			if(id != null) {
				//agregarProductoACarrito(id);
				agregarProductoACarritoBorja(id);
			}
				
			
			fw(CARRITO_JSP);
			break;
		case "/frontcontroller/factura":
			id = request.getParameter("id");
			if(id != null) {
				crearFactura();
				
				fw(FACTURA_JSP);
			}
				
			else 
				
				fw(PRODUCTOS_JSP);
				
			break;
		case "/frontcontroller/facturaCreada":
			id = request.getParameter("id");
			if(id != null) {
				HttpSession session = request.getSession();
				com.ipartek.formacion.ejemplocapas.entidades.Factura f = (com.ipartek.formacion.ejemplocapas.entidades.Factura) session.getAttribute("factura");
				LogicaNegocio.insertarFactura(f);
				fw(FACTURA_CREADA_JSP);
			}
				
			else 
				
				fw(LOGIN_JSP);
				
			break;
		default:
			response.getWriter().println(path);
			response.getWriter().println(request.getContextPath());
		}
	}

	private void agregarProductoACarrito(String id) {
		HttpSession session = request.getSession();
		
		Producto producto = LogicaNegocio.obtenerProductoPorId(id);
		
		ArrayList<Producto> productos = 
				(ArrayList<Producto>) session.getAttribute("carrito");
		
		productos.add(producto);
	}
	
	private void agregarProductoACarritoBorja(String id) {
		HttpSession session = request.getSession();
		
		com.ipartek.formacion.ejemplocapas.entidades.Usuario usuarioEntidad;
		Producto producto = LogicaNegocio.obtenerProductoPorId(id);
		
		ArrayList<com.ipartek.formacion.ejemplocapas.entidades.Carrito> carritos = 
				(ArrayList<com.ipartek.formacion.ejemplocapas.entidades.Carrito>) session.getAttribute("carritoNew");
		
		usuarioEntidad = (com.ipartek.formacion.ejemplocapas.entidades.Usuario) session.getAttribute("usuario");
		com.ipartek.formacion.ejemplocapas.entidades.Carrito c;
		int cantidad = 1;
		
		boolean enc = false;
		if (carritos.size() == 0) {
			c = new com.ipartek.formacion.ejemplocapas.entidades.Carrito(0, usuarioEntidad, producto, cantidad);
			carritos.add(c);
		}
		else {
		for (int i =0; i<carritos.size(); i++) {
			
			if(carritos.get(i).getProducto().getId() == producto.getId()) {
				
				int cant = carritos.get(i).getCantidad() + 1;
				carritos.get(i).setCantidad(cant);
				enc=false;
				break;
			}
			else
				enc = true;
			
		}
		if (enc){
			c = new com.ipartek.formacion.ejemplocapas.entidades.Carrito(0, usuarioEntidad, producto, cantidad);
			carritos.add(c);
		}
		
		}
	}
	

	private void fichaIndex(String id) {
		Producto producto = LogicaNegocio.obtenerProductoPorId(id);
		
		request.setAttribute("producto", producto);
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
			errores.put("usuario", "No es válido ese email y contrase�a");

		if(errores.size() > 0) {
			request.setAttribute("usuario", usuario);
			request.setAttribute("errores", errores);
			
			return Estado.LOGIN_INCORRECTO;
		}
		
		HttpSession session = request.getSession(true);
		
		usuarioEntidad = LogicaNegocio.obtenerUsuarioPorEmail(usuario.getEmail());
		
		session.setAttribute("usuario", usuarioEntidad);
		
		
		ArrayList<Producto> carrito = new ArrayList<Producto>();
		ArrayList<com.ipartek.formacion.ejemplocapas.entidades.Carrito> carritos = new ArrayList<com.ipartek.formacion.ejemplocapas.entidades.Carrito>();
		//Producto p = new Producto(0, null, null, new BigDecimal(0));
		//Carrito c = new Carrito(0, usuarioEntidad, p, 0);
		//carritos.add(c);
		session.setAttribute("carrito", carrito);
		session.setAttribute("carritoNew", carritos);
		
		
		return Estado.LOGIN_CORRECTO;
	}
	
	private void crearFactura() {
		HttpSession session = request.getSession();
		
		
		//ArrayList<Producto> carrito= (ArrayList<Producto>) session.getAttribute("carrito");
		ArrayList<com.ipartek.formacion.ejemplocapas.entidades.Carrito> carritos = (ArrayList<com.ipartek.formacion.ejemplocapas.entidades.Carrito>) session.getAttribute("carritoNew");
		com.ipartek.formacion.ejemplocapas.entidades.Usuario usuarioEntidad = (com.ipartek.formacion.ejemplocapas.entidades.Usuario) session.getAttribute("usuario");
		Date d= new Date();
		double importe = 0;
		double iva = 21;
		for(com.ipartek.formacion.ejemplocapas.entidades.Carrito c: carritos) {
			double precio = c.getProducto().getPrecio().doubleValue();
			importe = importe + (precio * c.getCantidad());
			
		}
		
			double dineroIva = (importe *iva)/100;
			double total = Math.round((importe + dineroIva)*100d)/100d;
			com.ipartek.formacion.ejemplocapas.entidades.Factura f = new com.ipartek.formacion.ejemplocapas.entidades.Factura(1, 101723, d, usuarioEntidad, carritos, iva, importe, total);
		
		session.setAttribute("facturaS", f);
		request.setAttribute("factura", f);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void fw(String ruta) throws ServletException, IOException {
		request.getRequestDispatcher(ruta).forward(request, response);
	}
}
