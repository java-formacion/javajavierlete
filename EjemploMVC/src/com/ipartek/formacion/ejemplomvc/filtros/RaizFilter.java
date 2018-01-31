package com.ipartek.formacion.ejemplomvc.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class RaizFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());

		if (path.startsWith("/css") || 
				path.startsWith("/js") ||
				path.startsWith("/fonts") ||
				path.startsWith("/imgs") ||
				path.startsWith("/fotos") ||
				path.startsWith("/error")) {
		    chain.doFilter(request, response); // Goes to default servlet.
		} else {
		    request.getRequestDispatcher("/frontcontroller" + path).forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

}
