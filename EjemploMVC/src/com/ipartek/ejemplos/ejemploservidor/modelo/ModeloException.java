package com.ipartek.ejemplos.ejemploservidor.modelo;

public class ModeloException extends RuntimeException {

	private static final long serialVersionUID = -409171339864714188L;

	public ModeloException() {
		
	}

	public ModeloException(String message) {
		super(message);
		
	}

	public ModeloException(Throwable cause) {
		super(cause);
		
	}

	public ModeloException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ModeloException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
