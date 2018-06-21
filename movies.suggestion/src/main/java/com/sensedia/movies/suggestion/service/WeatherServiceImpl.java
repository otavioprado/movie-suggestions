package com.sensedia.movies.suggestion.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sensedia.movies.suggestion.commons.config.Config;
import com.sensedia.movies.suggestion.commons.rest.exceptions.ApplicationError;
import com.sensedia.movies.suggestion.commons.rest.exceptions.WeatherException;
import com.sensedia.movies.suggestion.model.weather.CurrentWeather;

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceImpl.class);
	private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
	private static final String WEATHER_URL = BASE_URL + "weather?q={city},{country}?&APPID={appid}";

	@Autowired
	private Config config;

	public CurrentWeather getTemperature(String city, String country) throws WeatherException {
		return getCurrentWeather(city, country);
	}

	private CurrentWeather getCurrentWeather(String city, String country) throws WeatherException {
		LOG.info("Searching for current temperature of the city: " + city + " in " + country);

		String uri = UriComponentsBuilder.fromHttpUrl(WEATHER_URL)
				.buildAndExpand(city, country, config.getWeatherApiKey()).toUriString();

		RestTemplate restTemplate = new RestTemplate();
		
		try {
			return restTemplate.getForObject(uri, CurrentWeather.class);
		} catch(HttpClientErrorException e) {
			LOG.error("no results found for " + uri);
			throw new WeatherException(ApplicationError.APP_ERROR_1, city, country); 
		}
	}

}
