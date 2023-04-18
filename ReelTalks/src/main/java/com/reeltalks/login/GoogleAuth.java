package com.reeltalks.login;

public class GoogleAuth {
	private String sub;		//고유한 uuid
	private String email;	//고유한 email 값
	private String jti;	// 매번바뀌는 토큰값 => 고유한 JWT ID (JSON Web Token) 의 약자  
	
	public GoogleAuth() {
		super();
	}
	public GoogleAuth(String sub, String email, String jti) {
		super();
		this.sub = sub;
		this.email = email;
		this.jti = jti;
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
	public String getJti() {
		return jti;
	}
	public void setJti(String jti) {
		this.jti = jti;
	}
	
	@Override
	public String toString() {
		return "GoogleAuth [sub=" + sub + ", email=" + email + ", jti=" + jti + "]";
	}
}
