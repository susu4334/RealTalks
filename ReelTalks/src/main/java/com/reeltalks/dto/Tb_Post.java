package com.reeltalks.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("Tb_Post")
public class Tb_Post {

	int post_id;
	String movie_id;
	String user_id;
	String post_title;
	String content;
	double star_rate;
	int view_count;
	int comment_count;
	LocalDateTime create_at;
	LocalDateTime update_at;
	public Tb_Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tb_Post(int post_id, String movie_id, String user_id, String post_title, String content, double star_rate,
			int view_count, int comment_count, LocalDateTime create_at, LocalDateTime update_at) {
		super();
		this.post_id = post_id;
		this.movie_id = movie_id;
		this.user_id = user_id;
		this.post_title = post_title;
		this.content = content;
		this.star_rate = star_rate;
		this.view_count = view_count;
		this.comment_count = comment_count;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", movie_id=" + movie_id + ", user_id=" + user_id + ", post_title="
				+ post_title + ", content=" + content + ", star_rate=" + star_rate + ", view_count=" + view_count
				+ ", comment_count=" + comment_count + ", createat=" + create_at + ", updateat=" + update_at + "]";
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getStar_rate() {
		return star_rate;
	}
	public void setStar_rate(double star_rate) {
		this.star_rate = star_rate;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
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
	
	
	
	
}
