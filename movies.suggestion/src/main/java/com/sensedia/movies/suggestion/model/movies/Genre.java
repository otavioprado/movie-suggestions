package com.sensedia.movies.suggestion.model.movies;

public enum Genre {
	ACTION(16), COMEDY(35), ANIMATION(16), THRILLER(53), DOCUMENTARY(99);

	private Integer id;

	Genre(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
