package com.sensedia.movies.suggestion.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.omertron.themoviedbapi.MovieDbException;
import com.sensedia.movies.suggestion.model.movies.Genre;
import com.sensedia.movies.suggestion.model.movies.MovieSuggestion;
import com.sensedia.movies.suggestion.service.MovieSuggestionService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MovieControllerTest {

	private static final int SUPER_QUENTE = 41;
	private static final int QUENTE = 38;
	private static final int AMENO = 22;
	private static final int WINTER_IS_COMING = 2;
	private static final int FRIO_POLAR = -10;

	@Autowired
	private MovieSuggestionService movieSuggestionService;

	@Test
	public void testActionMovies() throws MovieDbException {
		List<MovieSuggestion> result = movieSuggestionService.getMovieSuggestions(SUPER_QUENTE);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.ACTION.getId()));
	}

	@Test
	public void testComedyMovies() throws MovieDbException {
		List<MovieSuggestion> result = movieSuggestionService.getMovieSuggestions(QUENTE);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.COMEDY.getId()));
	}

	@Test
	public void testAnimationMovies() throws MovieDbException {
		List<MovieSuggestion> result = movieSuggestionService.getMovieSuggestions(AMENO);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.ANIMATION.getId()));
	}

	@Test
	public void testThrillerMovies() throws MovieDbException {
		List<MovieSuggestion> result = movieSuggestionService.getMovieSuggestions(WINTER_IS_COMING);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.THRILLER.getId()));
	}

	@Test
	public void testDocumentaryMovies() throws MovieDbException {
		List<MovieSuggestion> result = movieSuggestionService.getMovieSuggestions(FRIO_POLAR);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.DOCUMENTARY.getId()));
	}
}
