package com.sensedia.movies.suggestion.model.movies;

import java.util.List;

public class MovieSuggestion {

	private Integer id;
	private String title;
	private List<Integer> genreIds;
	private Trailer trailer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenres(List<Integer> genreIds) {
		this.genreIds = genreIds;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public Trailer getTrailer() {
		return trailer;
	}

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
