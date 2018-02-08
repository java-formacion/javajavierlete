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
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.Remove;

import com.ipartek.ejemplos.ejemploservidor.modelo.ModeloException;
import com.ipartek.ejemplos.ejemploservidor.modelo.Usuario;

import com.ipartek.ejemplos.ejemploservidor.negocio.LogicaNegocio;
import com.ipartek.formacion.ejemplocapas.entidades.Factura;
import com.ipartek.formacion.ejemplocapas.entidades.Producto;
import com.ipartek.formacion.ejemplocapas.entidades.Carrito;

import javafx.scene.control.Alert;
import sun.nio.cs.ext.ISCII91;

@WebServlet("/frontcontroller/*")
public class IndexServlet extends HttpServlet {
	private static final String LOGIN_JSP = "/WEB-INF/jsps/login.jsp";

	private static final long serialVersionUID = 1L;

	private static final String BIENVENIDA_JSP = "/WEB-INF/jsps/bienvenida.jsp";
	
	private static final String PRODUCTOS_JSP = "/WEB-INF/jsps/productos.jsp";

	private static final String FICHA_JSP = "/WEB-INF/jsps/ficha.jsp";

	private static final String CARRITO_JSP = "/WEB-INF/jsps/carrito.jsp";

	private static final String FACTURA_JSP = "/WEB-INF/jsps/factura.jsp";

	private static final String PRODUCTOSGUARDADOS_JSP = "/WEB-INF/jsps/productosComprados.jsp";

	private enum Estado {
		LOGIN_CORRECTO, LOGIN_INCORRECTO
	};

	private int idFactura = 0;
	private int idcarrito = 0;

	private ArrayList<Producto> productos;
	private ArrayList<Carrito> carritos = new ArrayList<Carrito>();

	private HttpServletRequest request;
	private HttpServletResponse response;

	private static final double iva = 21;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().println(request.getServletPath());
		this.request = request;
		this.response = response;
		String path = request.getRequestURI().substring(request.getContextPath().length());

		String id;
		String idProducto;
		String idProductoSumarCantidad;
		String idProductoRestarCantidad;

		switch (path) {
		case "/frontcontroller/":
			fw(LOGIN_JSP);
			break;
		case "/frontcontroller/login":
			switch (login()) {
			case LOGIN_CORRECTO:
				productosIndex();
				fw(PRODUCTOS_JSP);
				break;
			case LOGIN_INCORRECTO:
				fw(LOGIN_JSP);
				break;
			}
			break;
		case "/frontcontroller/productos":
			id = request.getParameter("id");
			if (id == null) {
				productosIndex();
				fw(PRODUCTOS_JSP);
			} else {
				fichaIndex(id);
				fw(FICHA_JSP);
			}
			break;
		case "/frontcontroller/carrito":

			id = request.getParameter("id");
			idProducto = request.getParameter("idProducto");
			idProductoSumarCantidad = request.getParameter("idProductoSumarCantidad");
			idProductoRestarCantidad = request.getParameter("idProductoRestarCantidad");
			
			if (idProductoRestarCantidad != null) {
				restarCantidadAProducto(idProductoRestarCantidad);
				idProductoRestarCantidad = null;
				response.setHeader("Refresh", "0; http://localhost:9080/tiendavirtual/carrito");
			}
			
			if (idProductoSumarCantidad != null) {
				sumarCantidadAlProducto(idProductoSumarCantidad);
				idProductoSumarCantidad = null;
				response.setHeader("Refresh", "0; http://localhost:9080/tiendavirtual/carrito");
			}
			
			if (idProducto != null) {
				borrarProducto(idProducto);
				idProducto = null;
				response.setHeader("Refresh", "0; http://localhost:9080/tiendavirtual/carrito");
			}

			if (id != null) {
				agregarProductoACarrito(id);
				response.setHeader("Refresh", "0; http://localhost:9080/tiendavirtual/carrito");
			}

			fw(CARRITO_JSP);
			break;

		case "/frontcontroller/factura":
			if (crearFactura()) {
				fw(FACTURA_JSP);
			} else {
				fw(CARRITO_JSP);
			}
			break;

		case "/frontcontroller/productosComprados":
			HttpSession session = request.getSession(true);
			Factura factura = (Factura) session.getAttribute("factura");
			double totalConIva = (double) session.getAttribute("totalConIva");
			double TotalSinIva = (double) session.getAttribute("totalSinIva");
			GuardarFacturaEnBD(factura, totalConIva, TotalSinIva);
			borrarSesiones(session);
			fw(PRODUCTOSGUARDADOS_JSP);
			break;
		default:
			response.getWriter().println(path);
			response.getWriter().println(request.getContextPath());
		}

	}

	private void sumarCantidadAlProducto(String idProductoSumarCantidad) {
		HttpSession session = request.getSession();

		Producto producto = LogicaNegocio.obtenerProductoPorId(idProductoSumarCantidad);

		productos = (ArrayList<Producto>) session.getAttribute("carrito");

		if (productos.size() != 0) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i).getId() == Long.parseLong(idProductoSumarCantidad)) {
					sumarCantidad(productos.get(i));
					break;
				}
			}
		}
		sumarProductoConIva(carritos, session);
		sumarProductosSinIva(carritos, session);

	}

	private void restarCantidadAProducto(String idProductoRestarCantidad) {
		HttpSession session = request.getSession();

		Producto producto = LogicaNegocio.obtenerProductoPorId(idProductoRestarCantidad);

		productos = (ArrayList<Producto>) session.getAttribute("carrito");

		if (productos.size() != 0) {
			int a = 0;
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i).getId() == Long.parseLong(idProductoRestarCantidad)) {
					for (Carrito c : carritos) {
						if (c.getP().getId() == producto.getId()) {
							c.setCantidad(c.getCantidad() - 1);
							int cantidad = c.getCantidad();
							if (cantidad <= 0) {
								borrarProducto(idProductoRestarCantidad);
							}
							break;
						}
					}
				}
			}
		}
		
		sumarProductoConIva(carritos, session);
		sumarProductosSinIva(carritos, session);

	}

	private void borrarProducto(String idProducto) {
		HttpSession session = request.getSession();

		Producto producto = LogicaNegocio.obtenerProductoPorId(idProducto);

		productos = (ArrayList<Producto>) session.getAttribute("carrito");

		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getId() == Long.parseLong(idProducto)) {
				for (int a = 0; a < carritos.size(); a++) {
					if (carritos.get(a).getP().getId() == producto.getId()) {
						carritos.remove(carritos.get(a));
						break;
					}
				}
			}
		}

		sumarProductoConIva(carritos, session);
		sumarProductosSinIva(carritos, session);
		productos.remove(producto);
	}

	private void GuardarFacturaEnBD(Factura factura, double totalConIva, double totalSinIva) {

		System.out.println("datos guardados");
		
	}

	private void borrarSesiones(HttpSession session) {
		request.setAttribute("factura", null);
		session.setAttribute("carritos", null);
		session.setAttribute("totalConIva", null);
		session.setAttribute("totalSinIva", null);
	}

	private boolean crearFactura() {

		idFactura++;
		HttpSession session = request.getSession(true);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		com.ipartek.formacion.ejemplocapas.entidades.Usuario u = (com.ipartek.formacion.ejemplocapas.entidades.Usuario) session
				.getAttribute("usuario");

		ArrayList<Carrito> c = (ArrayList<Carrito>) session.getAttribute("carritos");

		if (c == null) {
			return false;
		} else {
			double totalSinIva = (double) session.getAttribute("totalSinIva");
			double totalConIva = (double) session.getAttribute("totalConIva");

			Factura factura = new Factura(idFactura, u, c, date, iva, totalSinIva, totalConIva);

			// set a string session attribute
			// session.setAttribute(FACTURA_JSP, factura);
			request.setAttribute("factura", factura);
			return true;
		}
	}

	private void agregarProductoACarrito(String id) {

		HttpSession session = request.getSession();

		Producto producto = LogicaNegocio.obtenerProductoPorId(id);

		productos = (ArrayList<Producto>) session.getAttribute("carrito");

		if (productos.size() == 0) {
			AnadirCarritoInicio(id, producto, session);
			productos.add(producto);
		} else {
			int a = 0;
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i).getId() == Long.parseLong(id)) {
					sumarCantidad(productos.get(i));
					System.out.println("entra1");
					a++;
					break;
				}
			}
			if (a == 0) {
				AnadirCarritoInicio(id, producto, session);
				productos.add(producto);
			}
		}

		session.setAttribute("carritos", carritos);
		sumarProductosSinIva(carritos, session);
		sumarProductoConIva(carritos, session);

	}

	private void sumarCantidad(Producto producto) {

		for (Carrito c : carritos) {
			if (c.getP().getId() == producto.getId()) {
				c.setCantidad(c.getCantidad() + 1);
			}
		}

	}

	private void sumarProductoConIva(ArrayList<Carrito> carritos2, HttpSession session) {
		double totalConIva = 0;
		if (carritos2.size() != 0) {
			for (Carrito c : carritos2) {
				double p = c.getP().getPrecio().doubleValue();
				double canti = c.getCantidad();
				double sumaPIva = p * iva / 100;
				totalConIva = totalConIva + (p * canti) + sumaPIva;
				session.setAttribute("totalConIva", totalConIva);
			}
		} else {
			session.setAttribute("totalConIva", totalConIva);
		}
	}

	private void sumarProductosSinIva(ArrayList<Carrito> carritos2, HttpSession session) {
		double totalSinIva = 0;
		if (carritos2.size() != 0) {
			for (Carrito c : carritos2) {
				double p = c.getP().getPrecio().doubleValue();
				double canti = c.getCantidad();
				totalSinIva = totalSinIva + (p * canti);
				session.setAttribute("totalSinIva", totalSinIva);
			}
		} else {
			session.setAttribute("totalSinIva", totalSinIva);
		}
	}

	private void AnadirCarritoInicio(String id, Producto p, HttpSession session) {
		idcarrito++;
		Long idC = (long) idcarrito;
		com.ipartek.formacion.ejemplocapas.entidades.Usuario u = (com.ipartek.formacion.ejemplocapas.entidades.Usuario) session
				.getAttribute("usuario");
		Carrito c = new Carrito(idcarrito, p, u, 1);
		carritos.add(c);
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
		} catch (ModeloException me) {
			errores.put("password", me.getMessage());
		}

		com.ipartek.formacion.ejemplocapas.entidades.Usuario usuarioEntidad;
		usuarioEntidad = new com.ipartek.formacion.ejemplocapas.entidades.Usuario(0, null, usuario.getEmail(),
				usuario.getPassword(), null, null);

		if (!LogicaNegocio.esValidoUsuario(usuarioEntidad))
			errores.put("usuario", "No es válido ese email y contrase�a");

		if (errores.size() > 0) {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void fw(String ruta) throws ServletException, IOException {
		request.getRequestDispatcher(ruta).forward(request, response);
	}
}
