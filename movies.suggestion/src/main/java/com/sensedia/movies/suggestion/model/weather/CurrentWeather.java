package com.sensedia.movies.suggestion.model.weather;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CurrentWeather implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private List<Weather> weather;
	private String name;
	private Integer cod;
	private Main main;
	
	public List<Weather> getWeather() {
		return weather;
	}

	public String getName() {
		return name;
	}

	public Integer getCod() {
		return cod;
	}

	public Main getMain() {
		return main;
	}

	public String getId() {
		return id;
	}

}