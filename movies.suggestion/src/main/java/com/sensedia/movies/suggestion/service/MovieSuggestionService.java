package com.sensedia.movies.suggestion.service;

import java.util.List;

import com.omertron.themoviedbapi.MovieDbException;
import com.sensedia.movies.suggestion.model.movies.MovieSuggestion;

public interface MovieSuggestionService {
	public List<MovieSuggestion> getMovieSuggestions(Integer temperatureInCelsius) throws MovieDbException;
}
