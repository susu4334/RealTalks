package com.reeltalks.dto;

import java.util.List;

public class BoxOfficeDTO {
	// 제목 = title
	private String title;
	// 영화id = movie_id
	private String movie_id;
	// 이미지 = /app/web/images/Movie_id.png // movie_id 필요
	private String imageLink;
	// 감독이름
	private String director_Nm;
	// 배우이름 3개
	private List<String> actor_Nm_list;
	// 카테고리 3개
	private List<String> category_Id_list;
	// 개봉일 YYYY-MM-DD
	private String release_Date;

	public BoxOfficeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxOfficeDTO(String title, String movie_id, String imageLink, String director_Nm, List<String> actor_Nm_list,
			List<String> category_Id_list, String release_Date) {
		super();
		this.title = title;
		this.movie_id = movie_id;
		this.imageLink = imageLink;
		this.director_Nm = director_Nm;
		this.actor_Nm_list = actor_Nm_list;
		this.category_Id_list = category_Id_list;
		this.release_Date = release_Date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getDirector_Nm() {
		return director_Nm;
	}

	public void setDirector_Nm(String director_Nm) {
		this.director_Nm = director_Nm;
	}

	public List<String> getActor_Nm_list() {
		return actor_Nm_list;
	}

	public void setActor_Nm_list(List<String> actor_Nm_list) {
		this.actor_Nm_list = actor_Nm_list;
	}

	public List<String> getCategory_Id_list() {
		return category_Id_list;
	}

	public void setCategory_Id_list(List<String> category_Id_list) {
		this.category_Id_list = category_Id_list;
	}

	public String getRelease_Date() {
		return release_Date;
	}

	public void setRelease_Date(String release_Date) {
		this.release_Date = release_Date;
	}

	@Override
	public String toString() {
		return "BoxOfficeDTO [title=" + title + ", movie_id=" + movie_id + ", imageLink=" + imageLink + ", director_Nm="
				+ director_Nm + ", actor_Nm_list=" + actor_Nm_list + ", category_Id_list=" + category_Id_list
				+ ", release_Date=" + release_Date + "]";
	}

}
