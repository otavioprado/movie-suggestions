package com.sensedia.movies.suggestion.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sensedia.movies.suggestion.commons.rest.ResponseError;
import com.sensedia.movies.suggestion.commons.rest.exceptions.WeatherException;

@ControllerAdvice
@Component("serviceExceptionHandlerConfig")
public class ApplicationExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(WeatherException.class)
	@ResponseBody
	private ResponseError buildError(WeatherException e) {
		LOG.error("Handling WeatherException", e);
		
		final ResponseError responseError = new ResponseError();
		responseError.setCode(e.getError());
		responseError.setDescription(e.getErrorDescription());
		return responseError;
	}
}
