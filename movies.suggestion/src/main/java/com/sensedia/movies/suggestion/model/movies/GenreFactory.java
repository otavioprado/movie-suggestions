package com.sensedia.movies.suggestion.model.movies;

public class GenreFactory {
	
	private GenreFactory() {
		
	}
	
	public static Genre getGenre(Integer temperatureInCelsius) {
		if (temperatureInCelsius > 40) {
			return Genre.ACTION;
		} else if (temperatureInCelsius >= 36 && temperatureInCelsius <= 40) {
			return Genre.COMEDY;
		} else if (temperatureInCelsius > 20 && temperatureInCelsius <= 35) {
			return Genre.ANIMATION;
		} else if (temperatureInCelsius > 0 && temperatureInCelsius <= 20) {
			return Genre.THRILLER;
		} else {
			return Genre.DOCUMENTARY;
		}
	}
}
