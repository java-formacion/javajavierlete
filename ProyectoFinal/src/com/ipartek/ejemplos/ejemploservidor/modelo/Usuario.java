package com.ipartek.ejemplos.ejemploservidor.modelo;

public class Usuario {
	private String email, password;

	public Usuario(String email, String password) {
		setEmail(email);
		setPassword(password);
	}
	
	public Usuario() {}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
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
			throw new ModeloException("Debe tener @ y .");
			
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
