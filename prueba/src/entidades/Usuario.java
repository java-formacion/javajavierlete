package entidades;

public class Usuario {

	private int id;
	private String nombre;
	private String apellidos;
	private int tel;
	private String dni;
	
	public Usuario(int id, String nombre, String apellidos, int tel, String dni) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tel = tel;
		this.dni = dni;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
	
}
