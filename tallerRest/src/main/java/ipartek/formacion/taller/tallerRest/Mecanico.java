package ipartek.formacion.taller.tallerRest;

public class Mecanico {
	
	private int id;
	private String nombre, apellido, experiencia, telefono;
	Coche[] coches;
	
	
	
	public Mecanico(int id, String nombre, String apellido, String experiencia, String telefono, Coche[] coches) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.experiencia = experiencia;
		this.telefono = telefono;
		this.coches = coches;
	}



	public Mecanico(int id, String nombre, String apellido, String experiencia, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.experiencia = experiencia;
		this.telefono = telefono;
	}
	
	public Mecanico() {
		
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



	public String getExperiencia() {
		return experiencia;
	}



	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public Coche[] getCoches() {
		return coches;
	}



	public void setCoches(Coche[] coches) {
		this.coches = coches;
	}
	
	
	
	
	
}
