package com.sensedia.movies.suggestion.model.movies;

import java.util.List;

import com.omertron.themoviedbapi.model.media.Video;

public class MovieSuggestionBuilder {

	private MovieSuggestion movieSuggestion;

	public MovieSuggestionBuilder() {
		movieSuggestion = new MovieSuggestion();
	}

	public MovieSuggestionBuilder withTitle(String title) {
		this.movieSuggestion.setTitle(title);
		return this;
	}

	public MovieSuggestionBuilder withGenres(List<Integer> genreIds) {
		this.movieSuggestion.setGenres(genreIds);
		return this;
	}

	public MovieSuggestionBuilder withTrailer(Trailer trailer) {
		this.movieSuggestion.setTrailer(trailer);
		return this;
	}

	public MovieSuggestionBuilder withTrailer(Video video) {
		this.movieSuggestion.setTrailer(new Trailer("https://www.youtube.com/watch?v=" + video.getKey()));
		return this;
	}

	public MovieSuggestionBuilder withId(Integer id) {
		this.movieSuggestion.setId(id);
		return this;
	}

	public MovieSuggestion build() {
		return this.movieSuggestion;
	}

}
