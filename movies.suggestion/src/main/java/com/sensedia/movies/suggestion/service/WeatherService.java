package com.sensedia.movies.suggestion.service;

import com.sensedia.movies.suggestion.commons.rest.exceptions.WeatherException;
import com.sensedia.movies.suggestion.model.weather.CurrentWeather;

public interface WeatherService {
	CurrentWeather getTemperature(String city, String country) throws WeatherException;
}
