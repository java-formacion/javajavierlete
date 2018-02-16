package ipartek.formacion.taller.tallerRest;

public class Usuario {

	
	
	private int id;
	private String nombre, apellido, email, telefono;
	private Coche[] coches;
	
	
	
	public Coche[] getCoches() {
		return coches;
	}


	public void setCoches(Coche[] coches) {
		this.coches = coches;
	}


	public Usuario() {
		
		
	}
	
	
	public Usuario(int id, String nombre, String apellido, String email, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	
	
	


	public Usuario(int id, String nombre, String apellido, String email, String telefono, Coche[] coches) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.coches = coches;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
	
	
}
