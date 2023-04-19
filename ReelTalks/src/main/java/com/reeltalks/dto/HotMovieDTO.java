package com.reeltalks.dto;

public class HotMovieDTO {
	private String movie_id;
	private String title;

	public HotMovieDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotMovieDTO(String movie_id, String title) {
		super();
		this.movie_id = movie_id;
		this.title = title;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "HotMovieDTO [movie_id=" + movie_id + ", title=" + title + "]";
	}

}
