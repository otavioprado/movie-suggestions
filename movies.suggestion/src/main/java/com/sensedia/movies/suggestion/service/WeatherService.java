package com.sensedia.movies.suggestion.service;

import com.sensedia.movies.suggestion.model.weather.CurrentWeather;

public interface WeatherService {
	CurrentWeather getTemperature(String city, String country);
}
