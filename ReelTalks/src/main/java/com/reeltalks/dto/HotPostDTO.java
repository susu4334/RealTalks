package com.reeltalks.dto;

public class HotPostDTO {
	private String post_Id;
	private String post_Title;
	private int reply_Count;

	public HotPostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotPostDTO(String post_Id, String post_Title, int reply_Count) {
		super();
		this.post_Id = post_Id;
		this.post_Title = post_Title;
		this.reply_Count = reply_Count;
	}

	public String getPost_Id() {
		return post_Id;
	}

	public void setPost_Id(String post_Id) {
		this.post_Id = post_Id;
	}

	public String getPost_Title() {
		return post_Title;
	}

	public void setPost_Title(String post_Title) {
		this.post_Title = post_Title;
	}

	public int getReply_Count() {
		return reply_Count;
	}

	public void setReply_Count(int reply_Count) {
		this.reply_Count = reply_Count;
	}

	@Override
	public String toString() {
		return "HotPostDTO [post_Id=" + post_Id + ", post_Title=" + post_Title + ", reply_Count=" + reply_Count + "]";
	}

}
