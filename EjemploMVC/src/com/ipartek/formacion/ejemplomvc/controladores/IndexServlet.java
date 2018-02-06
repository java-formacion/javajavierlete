package com.ipartek.formacion.ejemplomvc.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.ejemplos.ejemploservidor.modelo.ModeloException;
import com.ipartek.ejemplos.ejemploservidor.modelo.Usuario;

import com.ipartek.ejemplos.ejemploservidor.negocio.LogicaNegocio;
import com.ipartek.formacion.ejemplocapas.entidades.Factura;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Carrito;

import javafx.scene.control.Alert;

@WebServlet("/frontcontroller/*")
public class IndexServlet extends HttpServlet {
	private static final String LOGIN_JSP = "/WEB-INF/jsps/login.jsp";
	
	private static final long serialVersionUID = 1L;

	private static final String BIENVENIDA_JSP = "/WEB-INF/jsps/bienvenida.jsp";
	private static final String PRODUCTOS_JSP = "/WEB-INF/jsps/productos.jsp";

	private static final String FICHA_JSP = "/WEB-INF/jsps/ficha.jsp";

	private static final String CARRITO_JSP = "/WEB-INF/jsps/carrito.jsp";
	
	private static final String FACTURA_JSP = "/WEB-INF/jsps/factura.jsp";
	
	private enum Estado { LOGIN_CORRECTO, LOGIN_INCORRECTO }; 
	
	private int idFactura=0;
	private int idcarrito=0;
	
	private ArrayList<Producto> productos;
	private ArrayList<Carrito> carritos = new ArrayList<Carrito>();
	
	
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
			if(id != null) 
				agregarProductoACarrito(id);
			
			fw(CARRITO_JSP);
			break;
		case "/frontcontroller/factura":
			crearFactura();
			fw(FACTURA_JSP);
			
		default:
			response.getWriter().println(path);
			response.getWriter().println(request.getContextPath());
		}
	}
	
	private void crearFactura() {
		idFactura++;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		HttpSession session = request.getSession();
		com.ipartek.formacion.ejemplocapas.entidades.Usuario u = (com.ipartek.formacion.ejemplocapas.entidades.Usuario) session.getAttribute("usuario");
		
		
		Factura factura = new Factura(idFactura, u.getId(), productos, date, 21);
		
		//set a string session attribute
		//session.setAttribute(FACTURA_JSP, factura);
		request.setAttribute("factura",factura);
		
		
		
		
	}

	
	private void agregarProductoACarrito(String id) {
		
		HttpSession session = request.getSession();
		
		Producto producto = LogicaNegocio.obtenerProductoPorId(id);
		
		productos = (ArrayList<Producto>) session.getAttribute("carrito");
		
		
		cantidadesProducto(id,productos,producto);
		
	}
	
	
	



	private void cantidadesProducto(String id, ArrayList<Producto> productos2, Producto producto) {
		
		/* si no encontramos el mismo producto en el array de productos del carrito 
		 * no agregamos el mimos producto sino le sumamos la cantidad.
		 */
		//protected List<EventSeat> modelData = new ArrayList<EventSeat>();
		if(productos.size()==0) {
			
			idcarrito++;
			Long idC=(long) idcarrito;
			Long idP=Long.parseLong(id);
			Carrito c = new Carrito(idC, idP, 1);
			carritos.add(c);
			System.out.println("entra");
			productos.add(producto);
			
			/*Carrito c= new Carrito((long)idcarrito, id, 1);
			System.out.println((long)idcarrito+" , "+id+" , "+1);
			carritos.add(c);*/
			
		}else {
			int a=0;
			for (int i = 0; i < productos.size(); i++) {
				if(productos.get(i).getId()==Long.parseLong(id)) {
					for (Carrito c: carritos) {
						if(c.getIdProducto()==productos.get(i).getId()) {
							c.setCantidad(c.getCantidad()+1);
						}
					}
					a++;break;
				}	
			}
			if(a==0) {
				idcarrito++;
				Long idC=(long) idcarrito;
				Long idP=Long.parseLong(id);
				Carrito c = new Carrito(idC, idP, 1);
				carritos.add(c);
				productos.add(producto);
				
			}
		}
		for(Carrito c: carritos) {
			System.out.println(c.getCantidad());
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
		
		session.setAttribute("carrito", carrito);
		
		return Estado.LOGIN_CORRECTO;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void fw(String ruta) throws ServletException, IOException {
		request.getRequestDispatcher(ruta).forward(request, response);
	}
}
