package com.ipartek.ejemplos.ejemploservidor.controladores;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.ejemploservidor.modelo.Usuario;
import com.ipartek.ejemplos.ejemploservidor.negocio.LogicaNegocio;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = new Usuario();

		usuario.setEmail(request.getParameter("email"));
		usuario.setPassword(request.getParameter("password"));

		String emailEnUrl = URLEncoder.encode(usuario.getEmail(), "UTF-8");
		String errorEnUrl = URLEncoder.encode("El usuario no es válido", "UTF-8");

		if (LogicaNegocio.validarUsuario(usuario))
			response.sendRedirect("ok.jsp?email=" + emailEnUrl);
		else
			response.sendRedirect("index.jsp?email=" + emailEnUrl + "&error=" + errorEnUrl);
		// response.sendRedirect("error.jsp?email=" + emailEnUrl);
	}

}