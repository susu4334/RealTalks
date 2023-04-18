package com.reeltalks.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("UserDTO")
public class UserDTO {
	private String user_id;
	private String user_name;	
	private LocalDateTime create_at;
	private LocalDateTime update_at;
	
	public UserDTO() {
		super();
	}
	public UserDTO(String user_id, String user_name, LocalDateTime create_at, LocalDateTime update_at) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.create_at = create_at;
		this.update_at = update_at;
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
		return "UserDTO [user_id=" + user_id + ", user_name=" + user_name + ", create_at=" + create_at + ", update_at="
				+ update_at + "]";
	}
}
