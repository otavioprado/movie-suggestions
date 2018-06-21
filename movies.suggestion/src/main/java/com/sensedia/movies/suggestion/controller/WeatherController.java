package com.sensedia.movies.suggestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensedia.movies.suggestion.model.weather.CurrentWeather;
import com.sensedia.movies.suggestion.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/{country}/{city}/temperature", method = RequestMethod.GET)
	public CurrentWeather getTemperature(@PathVariable String country, @PathVariable String city) {
		return weatherService.getTemperature(city, country);
	}
}