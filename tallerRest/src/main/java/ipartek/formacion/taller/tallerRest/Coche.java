package ipartek.formacion.taller.tallerRest;

public class Coche {

	private int id;
	private String marca, modelo, cv, matricula,anios;
	private Usuario u;
	private Mecanico[] mecanicos;
	
	
	public Coche(int id, String marca, String modelo, String cv, String matricula, String anios, Usuario u,
			Mecanico[] mecanicos) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cv = cv;
		this.matricula = matricula;
		this.anios = anios;
		this.u = u;
		this.mecanicos = mecanicos;
	}


	public Coche(int id, String marca, String modelo, String cv, String matricula, String anios, Usuario U) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cv = cv;
		this.matricula = matricula;
		this.anios = anios;
		this.u = U;
	}
	
	
	public Coche() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getAnios() {
		return anios;
	}


	public void setAnios(String anios) {
		this.anios = anios;
	}


	public Usuario getU() {
		return u;
	}


	public void setU(Usuario u) {
		this.u = u;
	}


	public Mecanico[] getMecanicos() {
		return mecanicos;
	}


	public void setMecanicos(Mecanico[] mecanicos) {
		this.mecanicos = mecanicos;
	}
	
	
	
	
	
	
}
