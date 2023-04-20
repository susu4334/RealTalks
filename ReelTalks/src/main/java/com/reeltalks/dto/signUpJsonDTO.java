package com.reeltalks.dto;

import org.apache.ibatis.type.Alias;

@Alias("signUpJsonDTO")
public class signUpJsonDTO {

	private boolean idOverlapped;
	private String user_id;
	
	public signUpJsonDTO() {
		super();
	}
	public signUpJsonDTO(boolean idOverlapped, String user_id) {
		super();
		this.idOverlapped = idOverlapped;
		this.user_id = user_id;
	}
	
	public boolean isIdOverlapped() {
		return idOverlapped;
	}
	public void setIdOverlapped(boolean idOverlapped) {
		this.idOverlapped = idOverlapped;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "signUpJsonDTO [idOverlapped=" + idOverlapped + ", user_id=" + user_id + "]";
	}
}
