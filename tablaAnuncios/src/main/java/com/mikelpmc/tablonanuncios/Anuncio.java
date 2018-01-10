package com.mikelpmc.tablonanuncios;

public class Anuncio {
	
	private Integer id;
	private String nombre;
	private String asunto;
	private String comentario;

	public Anuncio() {
		
	}
	
	public Anuncio(Integer id, String nombre, String asunto, String comentario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.asunto = asunto;
		this.comentario = comentario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
