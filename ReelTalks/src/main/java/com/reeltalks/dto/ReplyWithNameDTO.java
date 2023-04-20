package com.reeltalks.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("ReplyWithNameDTO")
public class ReplyWithNameDTO {
	private int post_id;
	private String movie_id;
	private String user_id;
	private String user_name;
	private int reply_id;
	private int parent_reply_id;
	private String reply_contents;
	private LocalDateTime create_at;
	private LocalDateTime update_at;
	private int depth;
	
	public ReplyWithNameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReplyWithNameDTO(int post_id, String movie_id, String user_id, String user_name, int reply_id,
			int parent_reply_id, String reply_contents, LocalDateTime create_at, LocalDateTime update_at, int depth) {
		super();
		this.post_id = post_id;
		this.movie_id = movie_id;
		this.user_id = user_id;
		this.user_name = user_name;
		this.reply_id = reply_id;
		this.parent_reply_id = parent_reply_id;
		this.reply_contents = reply_contents;
		this.create_at = create_at;
		this.update_at = update_at;
		this.depth = depth;
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public int getParent_reply_id() {
		return parent_reply_id;
	}
	public void setParent_reply_id(int parent_reply_id) {
		this.parent_reply_id = parent_reply_id;
	}
	public String getReply_contents() {
		return reply_contents;
	}
	public void setReply_contents(String reply_contents) {
		this.reply_contents = reply_contents;
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
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "ReplyWithNameDTO [post_id=" + post_id + ", movie_id=" + movie_id + ", user_id=" + user_id
				+ ", user_name=" + user_name + ", reply_id=" + reply_id + ", parent_reply_id=" + parent_reply_id
				+ ", reply_contents=" + reply_contents + ", create_at=" + create_at + ", update_at=" + update_at
				+ ", depth=" + depth + "]";
	}

}
