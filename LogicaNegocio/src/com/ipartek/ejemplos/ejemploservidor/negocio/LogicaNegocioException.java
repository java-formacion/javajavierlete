package com.ipartek.ejemplos.ejemploservidor.negocio;

public class LogicaNegocioException extends RuntimeException {

	private static final long serialVersionUID = -4354437912854576027L;

	public LogicaNegocioException() {
		super();
		
	}

	public LogicaNegocioException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public LogicaNegocioException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public LogicaNegocioException(String message) {
		super(message);
		
	}

	public LogicaNegocioException(Throwable cause) {
		super(cause);
	}

	
}
