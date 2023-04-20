package com.reeltalks.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("Movie")
public class Movie {
	private String movie_id;
	private String title;
	private String release_date;
	private String plot;
	private String rating;
	private String director_nm;
	private String actor_nm;
	private Integer boxoffice_order;
	private double star_avg_rate;
	private LocalDateTime create_at;
	private LocalDateTime update_at;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String movie_id, String title, String release_date, String plot, String rating, String director_nm,
			String actor_nm, Integer boxoffice_order, double star_avg_rate, LocalDateTime create_at,
			LocalDateTime update_at) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.release_date = release_date;
		this.plot = plot;
		this.rating = rating;
		this.director_nm = director_nm;
		this.actor_nm = actor_nm;
		this.boxoffice_order = boxoffice_order;
		this.star_avg_rate = star_avg_rate;
		this.create_at = create_at;
		this.update_at = update_at;
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
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDirector_nm() {
		return director_nm;
	}
	public void setDirector_nm(String director_nm) {
		this.director_nm = director_nm;
	}
	public String getActor_nm() {
		return actor_nm;
	}
	public void setActor_nm(String actor_nm) {
		this.actor_nm = actor_nm;
	}
	public Integer getBoxoffice_order() {
		return boxoffice_order;
	}
	public void setBoxoffice_order(Integer boxoffice_order) {
		this.boxoffice_order = boxoffice_order;
	}
	public double getStar_avg_rate() {
		return star_avg_rate;
	}
	public void setStar_avg_rate(double star_avg_rate) {
		this.star_avg_rate = star_avg_rate;
	}
	public LocalDateTime getCreate_at() {
		return create_at;
	}
	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = create_at;
	}
	public LocalDateTime getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(LocalDateTime update_at) {
		this.update_at = update_at;
	}
	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", title=" + title + ", release_date=" + release_date + ", plot=" + plot
				+ ", rating=" + rating + ", director_nm=" + director_nm + ", actor_nm=" + actor_nm
				+ ", boxoffice_order=" + boxoffice_order + ", star_avg_rate=" + star_avg_rate + ", create_at="
				+ create_at + ", update_at=" + update_at + "]";
	}
	
	
	
}
