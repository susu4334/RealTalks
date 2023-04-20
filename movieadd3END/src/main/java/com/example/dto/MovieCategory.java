package com.example.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("MovieCategory")
public class MovieCategory {
	private String movie_id;
	private String category_id;
	private LocalDateTime create_at;
	private LocalDateTime update_at;
	public MovieCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieCategory(String movie_id, String category_id, LocalDateTime create_at, LocalDateTime update_at) {
		super();
		this.movie_id = movie_id;
		this.category_id = category_id;
		this.create_at = create_at;
		this.update_at = update_at;
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
		return "MovieCategory [movie_id=" + movie_id + ", category_id=" + category_id + ", create_at=" + create_at
				+ ", update_at=" + update_at + "]";
	}
	
}
