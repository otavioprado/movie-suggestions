package com.sensedia.movies.suggestion.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sensedia.movies.suggestion.model.movies.Genre;
import com.sensedia.movies.suggestion.model.movies.MovieSuggestion;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MovieControllerTest {

	private static final int SUPER_QUENTE = 41;
	private static final int QUENTE = 38;
	private static final int AMENO = 22;
	private static final int WINTER_IS_COMING = 2;
	private static final int FRIO_POLAR = -10;

	private static final String BASE_PATH = "http://localhost:8888/movie/suggestions?temperatureInCelsius={celsius}";

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testActionMovies() {
		List<MovieSuggestion> result = getMovieSuggestion(SUPER_QUENTE);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.ACTION.getId()));
	}

	@Test
	public void testComedyMovies() {
		List<MovieSuggestion> result = getMovieSuggestion(QUENTE);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.COMEDY.getId()));
	}

	@Test
	public void testAnimationMovies() {
		List<MovieSuggestion> result = getMovieSuggestion(AMENO);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.ANIMATION.getId()));
	}

	@Test
	public void testThrillerMovies() {
		List<MovieSuggestion> result = getMovieSuggestion(WINTER_IS_COMING);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.THRILLER.getId()));
	}

	@Test
	public void testDocumentaryMovies() {
		List<MovieSuggestion> result = getMovieSuggestion(FRIO_POLAR);
		Assert.assertTrue(result.get(0).getGenreIds().contains(Genre.DOCUMENTARY.getId()));
	}

	private List<MovieSuggestion> getMovieSuggestion(int temperature) {
		String uri = UriComponentsBuilder.fromHttpUrl(BASE_PATH).buildAndExpand(temperature).toUriString();

		ResponseEntity<MovieSuggestion[]> responseEntity = restTemplate.getForEntity(uri, MovieSuggestion[].class);
		return Arrays.asList(responseEntity.getBody());
	}

}
