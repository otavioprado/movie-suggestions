package com.sensedia.movies.suggestion.commons.rest.exceptions;

public class WeatherException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private ApplicationError error;
	private Object[] params;
	
	public WeatherException(ApplicationError error, Object... params) {
		super(error.format(params));
		this.error = error;
		this.params = params;
	}

	public String getError() {
		return error.getErrorCode();
	}
	
	public String getErrorDescription() {
		return error.format(params);
	}
}
