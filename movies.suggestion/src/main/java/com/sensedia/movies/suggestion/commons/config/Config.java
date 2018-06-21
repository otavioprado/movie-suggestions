package com.sensedia.movies.suggestion.commons.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Value("${themoviedb.api_key:}")
	public String movieDbApiKey;

	@Value("${openweathermap.api_key:}")
	public String weatherApiKey;

	public String getMovieDbApiKey() {
		return movieDbApiKey;
	}

	public String getWeatherApiKey() {
		return weatherApiKey;
	}
}
