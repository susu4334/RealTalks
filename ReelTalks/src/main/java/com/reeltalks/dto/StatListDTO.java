package com.reeltalks.dto;

import java.util.List;

public class StatListDTO {
	// 일간 각 영화의 게시물 개수
	private List<StatDTO> post;
	// 일간 각 영화의 댓글 개수
	private List<StatDTO> reply;
	// 월간 각 영화의 게시물 + 댓글 개수
	private List<StatDTO> genre;

	public StatListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatListDTO(List<StatDTO> post, List<StatDTO> reply, List<StatDTO> genre) {
		super();
		this.post = post;
		this.reply = reply;
		this.genre = genre;
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
		return "StatListDTO [post=" + post + ", reply=" + reply + ", genre=" + genre + "]";
	}

}
