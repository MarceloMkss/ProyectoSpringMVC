package com.twt.curso.AccesoDatos;

public class AccesoDatosException extends RuntimeException{

	
	private static final long serialVersionUID = 6809366359417367685L;

	public AccesoDatosException() {
		super();
		
	}

	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccesoDatosException(String message) {
		super(message);
		
	}

	public AccesoDatosException(Throwable cause) {
		super(cause);
	
	}

	
}
