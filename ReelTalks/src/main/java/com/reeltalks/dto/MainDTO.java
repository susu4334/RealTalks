package com.reeltalks.dto;

import java.util.List;

public class MainDTO {
	// mainContents
	private List<BoxOfficeDTO> boxOffice;
	private List<HotMovieDTO> hotMovie;
	private List<HotPostDTO> hotPost;
	// statistics
	private List<StatDTO> post;
	private List<StatDTO> reply;
	private List<StatDTO> genre;

	public MainDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MainDTO(List<BoxOfficeDTO> boxOffice, List<HotMovieDTO> hotMovie, List<HotPostDTO> hotPost,
			List<StatDTO> post, List<StatDTO> reply, List<StatDTO> genre) {
		super();
		this.boxOffice = boxOffice;
		this.hotMovie = hotMovie;
		this.hotPost = hotPost;
		this.post = post;
		this.reply = reply;
		this.genre = genre;
	}

	public List<BoxOfficeDTO> getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(List<BoxOfficeDTO> boxOffice) {
		this.boxOffice = boxOffice;
	}

	public List<HotMovieDTO> getHotMovie() {
		return hotMovie;
	}

	public void setHotMovie(List<HotMovieDTO> hotMovie) {
		this.hotMovie = hotMovie;
	}

	public List<HotPostDTO> getHotPost() {
		return hotPost;
	}

	public void setHotPost(List<HotPostDTO> hotPost) {
		this.hotPost = hotPost;
	}

	public List<StatDTO> getPost() {
		return post;
	}

	public void setPost(List<StatDTO> post) {
		this.post = post;
	}

	public List<StatDTO> getReply() {
		return reply;
	}

	public void setReply(List<StatDTO> reply) {
		this.reply = reply;
	}

	public List<StatDTO> getGenre() {
		return genre;
	}

	public void setGenre(List<StatDTO> genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "MainDTO [boxOffice=" + boxOffice + ", hotMovie=" + hotMovie + ", hotPost=" + hotPost + ", post=" + post
				+ ", reply=" + reply + ", genre=" + genre + "]";
	}

}
