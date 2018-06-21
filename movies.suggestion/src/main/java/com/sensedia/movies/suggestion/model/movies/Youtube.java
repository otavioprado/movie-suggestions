package com.sensedia.movies.suggestion.model.movies;

public class Youtube {
	private String fullUrl;

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}
	
	public Youtube buildYoutube() {
		Youtube youtube = new Youtube();
		youtube.setFullUrl("https://www.youtube.com/watch?v={videoId}");
		
		return youtube;
	}
}
