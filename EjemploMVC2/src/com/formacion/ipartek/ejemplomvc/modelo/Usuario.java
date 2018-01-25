package com.formacion.ipartek.ejemplomvc.modelo;

public class Usuario {
	
	private String email, password;
	
	public Usuario() {}
	
	public Usuario(String email, String password) {
		setEmail(email);
		setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email == null)
			throw new ModeloException("El email no puede ser nulo");
		
		if(email.trim().isEmpty())
			throw new ModeloException("El email no puede estar vacío");
		
		if(!email.matches("\\w+\\@\\w+\\.\\w+"))
			throw new ModeloException("El email no es válido");
			
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password == null)
			throw new ModeloException("El password no puede ser nulo");
		
		if(password.trim().isEmpty())
			throw new ModeloException("El password no puede estar vacío");
		
		this.password = password;
	}
	
	

}
