package com.reeltalks.login;

public class GoogleAuth {
	private String sub;		//고유한 uuid
	private String email;	//email 값
	
	public GoogleAuth() {
		super();
	}
	public GoogleAuth(String sub, String email) {
		super();
		this.sub = sub;
		this.email = email;
	}
	
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "GoogleAuth [sub=" + sub + ", email=" + email + "]";
	}
}
