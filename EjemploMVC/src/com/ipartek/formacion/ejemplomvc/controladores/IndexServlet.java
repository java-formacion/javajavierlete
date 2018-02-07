package com.ipartek.formacion.ejemplomvc.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.ant.SessionsTask;


import com.ipartek.ejemplos.ejemploservidor.negocio.LogicaNegocio;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Usuario;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.ipartek.formacion.ejemplocapas.entidades.Factura;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOFactura;
import com.ipartek.formacion.ejemplocapas.accesodatos.DAOFacturaJDBC;
import com.ipartek.formacion.ejemplocapas.entidades.Carrito;
import com.ipartek.ejemplos.ejemploservidor.modelo.*;


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
			response.setHeader("Refresh", "0; http://localhost:8080/tiendavirtual/carrito");
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
				Factura f = (Factura) session.getAttribute("facturaS");
				LogicaNegocio.insertarFactura(f);
				
				for (Carrito c : f.getCarrito()) {
					LogicaNegocio.insertarCarrito(c);
				}
				
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

	/*
	private void agregarProductoACarrito(String id) {
		HttpSession session = request.getSession();
		
		Producto producto = LogicaNegocio.obtenerProductoPorId(id);
		
		ArrayList<Producto> productos = 
				(ArrayList<Producto>) session.getAttribute("carrito");
		
		productos.add(producto);
	}
	*/
	
	/**
	 * Funcion para agregar productos a mi carrito
	 * mi carrito es una clase que contiene un id, usuario, producto y la cantidad
	 * de producto que quiere del mismo.
	 * @param id
	 */
	private void agregarProductoACarritoBorja(String id) {
		HttpSession session = request.getSession();
		
		com.ipartek.formacion.ejemplocapas.entidades.Usuario usuarioEntidad;
		Producto producto = LogicaNegocio.obtenerProductoPorId(id);
		
		ArrayList<Carrito> carritos = 
				(ArrayList<Carrito>) session.getAttribute("carritoNew");
		
		usuarioEntidad = (Usuario) session.getAttribute("usuario");
		Carrito c;
		int cantidad = 1;
		//sin hacer aun. habria que comprobar en la base de datos cual es el ultimo id_carrito
		// y sumarle 1
		int idCarrito = 4;
		
		boolean enc = false;
		if (carritos.size() == 0) {
			c = new Carrito(idCarrito, usuarioEntidad, producto, cantidad);
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
			c = new Carrito(idCarrito, usuarioEntidad, producto, cantidad);
			carritos.add(c);
		}
		
		}
		
	}
	

	/**
	 * Funcion obtener cada producto por id
	 * @param id
	 */
	private void fichaIndex(String id) {
		Producto producto = LogicaNegocio.obtenerProductoPorId(id);
		
		request.setAttribute("producto", producto);
	}

	/**
	 * Funcion para obtener todos los productos existentes
	 */
	private void productosIndex() {
		Producto[] productos = LogicaNegocio.obtenerProductos();
		
		request.setAttribute("productos", productos);
	}

	/**
	 * Comprueba que el usuario y la password sean correctas.
	 * Si son correctas crea al usuario y le almacena en una sesion
	 * y aparte tambien crea un carrito vacio.
	 * @return
	 */
	private Estado login() {
		Hashtable<String, String> errores = new Hashtable<>();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		com.ipartek.ejemplos.ejemploservidor.modelo.Usuario usuario = new com.ipartek.ejemplos.ejemploservidor.modelo.Usuario();
		
		
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
		
		Usuario usuarioEntidad;
		usuarioEntidad = new Usuario(0, null, usuario.getEmail(), usuario.getPassword(), null, null);
		
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
		
		
		ArrayList<Carrito> carritos = new ArrayList<Carrito>();
		session.setAttribute("carritoNew", carritos);
		
		
		return Estado.LOGIN_CORRECTO;
	}
	
	/**
	 * Funcion para crear la factura.
	 * Recibe el carrito por sesion con los datos del usuario, producto y cantidad
	 * te hace los calculos del importe, iva, total, fecha...
	 * y crea una sesion factura
	 */
	
	private void crearFactura() {
		HttpSession session = request.getSession();
		
		
		
		ArrayList<Carrito> carritos = (ArrayList<Carrito>) session.getAttribute("carritoNew");
		Date  d= new Date();
		double importe = 0;
		double iva = 21;
		for(Carrito c: carritos) {
			double precio = c.getProducto().getPrecio().doubleValue();
			importe = importe + (precio * c.getCantidad());
			
		}
		
			double dineroIva = (importe *iva)/100;
			double total = Math.round((importe + dineroIva)*100d)/100d;
			Factura f = new Factura(-1,101726, d, carritos, iva, importe, total);
		
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
