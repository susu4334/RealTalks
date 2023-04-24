package com.reeltalks.dto;

public class BoxOfficeDBDTO {
	// 제목 = title
	private String title;
	// 이미지 = /app/web/images/Movie_id.png // movie_id 필요
	private String imageLink;
	// 감독이름
	private String director_Nm;
	// 배우이름 3개
//	private List<String> actor_Nm_list;
	// DB에서 가져오는 배우이름
	private String actor_Nm;
	// 카테고리 3개
//	private List<String> category_Id_list;
	// DB에서 가져오는 카테고리
	private String category_Id;
	// 개봉일 YYYY-MM-DD
	private String release_Date;

	public BoxOfficeDBDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	// DB에서 데이터 받아오는 생성자
	public BoxOfficeDBDTO(String title, String imageLink, String director_Nm, String actor_Nm, String category_Id,
			String release_Date) {
		super();
		this.title = title;
		this.imageLink = imageLink;
		this.director_Nm = director_Nm;
		this.actor_Nm = actor_Nm;
		this.category_Id = category_Id;
		this.release_Date = release_Date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getActor_Nm() {
		return actor_Nm;
	}

	public void setActor_Nm(String actor_Nm) {
		this.actor_Nm = actor_Nm;
	}

	public String getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(String category_Id) {
		this.category_Id = category_Id;
	}

	public String getRelease_Date() {
		return release_Date;
	}

	public void setRelease_Date(String release_Date) {
		this.release_Date = release_Date;
	}

	// DB에서 가져오는 데이터
	@Override
	public String toString() {
		return "BoxOfficeDTO [title=" + title + ", imageLink=" + imageLink + ", director_Nm=" + director_Nm
				+ ", actor_Nm=" + actor_Nm + ", category_Id=" + category_Id + ", release_Date=" + release_Date + "]";
	}

}
