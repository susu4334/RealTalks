package com.reeltalks.dto;

import java.util.List;

public class MainListDTO {
	List<BoxOfficeDTO> boxOffice;

	List<HotMovieDTO> hotMovie;

	List<HotPostDTO> hotPost;

	public MainListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MainListDTO(List<BoxOfficeDTO> boxOffice, List<HotMovieDTO> hotMovie, List<HotPostDTO> hotPost) {
		super();
		this.boxOffice = boxOffice;
		this.hotMovie = hotMovie;
		this.hotPost = hotPost;
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

	@Override
	public String toString() {
		return "MainListDTO [boxOffice=" + boxOffice + ", hotMovie=" + hotMovie + ", hotPost=" + hotPost + "]";
	}

}
