package prueba.pruebahibernate;

import javax.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuario {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "passwd")
	private String passwd;
	
	public Usuario(int id, String nombre, String passwd) {
		this.id = id;
		this.nombre = nombre;
		this.passwd = passwd;
	}
	
	public Usuario(String nombre, String passwd) {
		this.nombre = nombre;
		this.passwd = passwd;
	}
	
	public Usuario() {}

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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
