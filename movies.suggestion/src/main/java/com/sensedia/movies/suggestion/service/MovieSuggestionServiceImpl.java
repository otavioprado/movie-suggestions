package com.sensedia.movies.suggestion.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omertron.themoviedbapi.MovieDbException;
import com.omertron.themoviedbapi.TheMovieDbApi;
import com.omertron.themoviedbapi.model.media.Video;
import com.omertron.themoviedbapi.model.movie.MovieBasic;
import com.omertron.themoviedbapi.results.ResultList;
import com.sensedia.movies.suggestion.commons.config.Config;
import com.sensedia.movies.suggestion.model.movies.GenreFactory;
import com.sensedia.movies.suggestion.model.movies.MovieSuggestion;
import com.sensedia.movies.suggestion.model.movies.MovieSuggestionBuilder;

@Service
public class MovieSuggestionServiceImpl implements MovieSuggestionService {

	private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceImpl.class);
	private static final String EN_LANGUAGE = "en";
	private TheMovieDbApi theMovieDbApi;

	@Autowired
	private Config config;

	@Override
	public List<MovieSuggestion> getMovieSuggestions(Integer temperatureInCelsius) throws MovieDbException {
		LOG.debug("Checking movies for temperature" + temperatureInCelsius + "°C");
		theMovieDbApi = new TheMovieDbApi(config.getMovieDbApiKey());

		Integer genreId = GenreFactory.getGenre(temperatureInCelsius).getId();

		ResultList<MovieBasic> listMovieBasic = theMovieDbApi.getGenreMovies(genreId, EN_LANGUAGE,
				new Random().nextInt(50), true, false);

		List<MovieBasic> results = listMovieBasic.getResults();

		return results.stream().map(this::buildMovieSuggestion).collect(Collectors.toList());
	}

	private MovieSuggestion buildMovieSuggestion(MovieBasic c) {
		Optional<Video> youtubeTrailer = getMovieTrailer(theMovieDbApi, c);

		return new MovieSuggestionBuilder().withId(c.getId()).withTitle(c.getTitle()).withGenres(c.getGenreIds())
				.withTrailer(youtubeTrailer.orElse(new Video())).build();
	}

	private Optional<Video> getMovieTrailer(TheMovieDbApi theMovieDbApi, MovieBasic c) {
		Optional<Video> trailer = Optional.empty();
		try {
			trailer = theMovieDbApi.getMovieVideos(c.getId(), c.getOriginalLanguage()).getResults().stream()
					.filter(f -> f.getSite().equals("YouTube")).findAny();
		} catch (MovieDbException e) {
			LOG.error("No video for the movie was found", e);
		}

		return trailer;
	}
}
