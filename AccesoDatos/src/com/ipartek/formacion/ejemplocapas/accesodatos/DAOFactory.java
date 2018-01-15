package com.ipartek.formacion.ejemplocapas.accesodatos;

public class DAOFactory {
	private final String motor, url;

	public DAOFactory(String motor, String url) {
		super();
		this.motor = motor;
		this.url = url;
	}

	public DAOUsuario getDAOUsuario() {
		switch(motor) {
		case "jdbc": return new DAOUsuarioJDBC(url);
		case "arraylist": return new DAOUsuarioArrayList();
		default: throw new AccesoDatosException("No conozco el motor");
		}
	}
	
	public DAOProducto getDAOProducto() {
		switch(motor) {
		case "arraylist": return new DAOProductoArrayList();
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
