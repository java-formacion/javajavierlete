package com.ipartek.formacion.ejemplocapas.entidades;

public class EntidadesException extends RuntimeException {

	private static final long serialVersionUID = -5893515295549666713L;

	public EntidadesException() {
		
	}

	public EntidadesException(String message) {
		super(message);
		
	}

	public EntidadesException(Throwable cause) {
		super(cause);
		
	}

	public EntidadesException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EntidadesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
