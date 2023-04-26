package com.reeltalks.dto;

import org.apache.ibatis.type.Alias;

@Alias("MovieJoinDTO")
public class MovieJoinDTO {
	
	private String movie_id;
	private String category_id;
	private String title;
	private String release_date;
	private double star_avg_rate;
	
	
	
	public MovieJoinDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MovieJoinDTO(String movie_id, String category_id, String title, String release_date, double star_avg_rate) {
		super();
		this.movie_id = movie_id;
		this.category_id = category_id;
		this.title = title;
		this.release_date = release_date;
		this.star_avg_rate = star_avg_rate;
	}



	public String getMovie_id() {
		return movie_id;
	}



	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}



	public String getCategory_id() {
		return category_id;
	}



	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getRelease_date() {
		return release_date;
	}



	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}



	public double getStar_avg_rate() {
		return star_avg_rate;
	}



	public void setStar_avg_rate(double star_avg_rate) {
		this.star_avg_rate = star_avg_rate;
	}



	@Override
	public String toString() {
		return "MovieJoinDTO [movie_id=" + movie_id + ", category_id=" + category_id + ", title=" + title
				+ ", release_date=" + release_date + ", star_avg_rate=" + star_avg_rate + "]";
	}




	
}
