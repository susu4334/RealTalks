package com.reeltalks.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("AwesomeDTO")
public class AwesomeDTO {
	
	private int awe_id;
	private String content;
	private LocalDateTime create_at;
	private LocalDateTime update_at;
	
	public AwesomeDTO() {
		super();
	}
	public AwesomeDTO(int awe_id, String content, LocalDateTime create_at, LocalDateTime update_at) {
		super();
		this.awe_id = awe_id;
		this.content = content;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	
	public int getAwe_id() {
		return awe_id;
	}
	public void setAwe_id(int awe_id) {
		this.awe_id = awe_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
		return "AwesomeDTO [awe_id=" + awe_id + ", content=" + content + ", create_at=" + create_at + ", update_at="
				+ update_at + "]";
	}
}
