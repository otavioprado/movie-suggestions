package com.sensedia.movies.suggestion.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sensedia.movies.suggestion.model.weather.CurrentWeather;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WeatherControllerTest {
	
	private static final String BRASIL = "bra";
	private static final String BASE_PATH = "http://localhost:8888/{country}/{city}/temperature";
	private static final RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testWeatherInCampinas() {
		CurrentWeather currentWeather = getCurrentWeather(BRASIL, "campinas");

		Assert.assertEquals("Campinas", currentWeather.getName());
		Assert.assertEquals(Integer.valueOf(200), currentWeather.getCod());
		Assert.assertNotNull(currentWeather.getMain().getTemp());
	}
	
	@Test
	public void testWeatherInSaoPauloWithEncodedUrlFormat() {
		CurrentWeather currentWeather = getCurrentWeather(BRASIL, "são paulo");

		Assert.assertEquals("São Paulo", currentWeather.getName());
		Assert.assertEquals(Integer.valueOf(200), currentWeather.getCod());
		Assert.assertNotNull(currentWeather.getMain().getTemp());
	}
	
	private CurrentWeather getCurrentWeather(String country, String city) {
		String uri = UriComponentsBuilder.fromHttpUrl(BASE_PATH).buildAndExpand(country, city).toUriString();

		ResponseEntity<CurrentWeather> currentWeather = restTemplate.getForEntity(uri, CurrentWeather.class);
		
		return currentWeather.getBody();
	}
}
