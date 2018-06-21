package com.sensedia.movies.suggestion.commons.utils;

public class TemperatureUtils {
	
	private TemperatureUtils() {
		
	}

	public static Integer toCelsius(Integer k) {
		return Math.toIntExact(Math.round(k - 273.15));
	}
}
