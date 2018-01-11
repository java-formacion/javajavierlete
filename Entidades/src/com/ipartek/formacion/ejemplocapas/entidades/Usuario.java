package com.ipartek.formacion.ejemplocapas.entidades;

public class Usuario {

	//los id es recomendable poner longs en id (9 trillones de d�gitos)
	private long id;
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private String dni;
	
	
	public Usuario(long id, String email, String password, String nombre, String apellido, String dni) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public Usuario() {
		
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", dni=" + dni + "]";
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email == null)
			throw new EntidadesException("No se admiten emails nulos");
		
		if(!email.matches("\\w+\\@\\w+\\.\\w+"))
				throw new EntidadesException("El email no tiene el formato adecuado");
		
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
