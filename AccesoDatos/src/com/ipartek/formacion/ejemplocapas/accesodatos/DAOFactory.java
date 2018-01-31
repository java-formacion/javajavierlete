package com.ipartek.formacion.ejemplocapas.accesodatos;

public class DAOFactory {
	private final String motor, url, usuario, password;

	
	public DAOFactory(String motor, String url, String usuario, String password) {
		super();
		this.motor = motor;
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}

	public DAOUsuario getDAOUsuario() {
		switch(motor) {
		case "jdbc": return new DAOUsuarioJDBC(url, usuario, password);
		case "arraylist": return new DAOUsuarioArrayList();
		default: throw new AccesoDatosException("No conozco el motor");
		}
	}
	
	public DAOProducto getDAOProducto() {
		switch(motor) {
		case "arraylist": return new DAOProductoArrayList();
		case "jdbc":return new DAOProductoJDBC(url, usuario, password);
		default: throw new AccesoDatosException("No conozco el motor");
		}
	}
	
	@Override
	public String toString() {
		return "DAOFactory [motor=" + motor + ", url=" + url + "]";
	}

	public String getMotor() {
		return motor;
	}

	public String getUrl() {
		return url;
	}
}
