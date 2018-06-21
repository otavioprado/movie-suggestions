package com.sensedia.movies.suggestion.commons.rest.exceptions;

public enum ApplicationError {
	APP_ERROR_1("Weather not found for city %s in country %s");

	private String errorMessage;
	
	private ApplicationError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return name();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String format(Object... params) {
		return String.format(errorMessage, params);
	}
}
