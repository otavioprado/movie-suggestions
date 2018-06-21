package com.sensedia.movies.suggestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omertron.themoviedbapi.MovieDbException;
import com.sensedia.movies.suggestion.model.movies.MovieSuggestion;
import com.sensedia.movies.suggestion.service.MovieSuggestionService;

@RestController
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MovieController {

	@Autowired
	private MovieSuggestionService movieService;

	@RequestMapping(value = "/movie/suggestions", method = RequestMethod.GET)
	public List<MovieSuggestion> getMovieSuggestions(@RequestParam(name = "temperatureInCelsius") Integer temperatureInCelsius)
			throws MovieDbException {
		return movieService.getMovieSuggestions(temperatureInCelsius);
	}
}
