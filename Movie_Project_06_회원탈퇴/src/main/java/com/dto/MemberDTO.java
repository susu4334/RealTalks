package com.dto;

public class MemberDTO {
	
	
	private int num;
	private String username;
	private String userid;
	private String passwd;
	private String ybirth;
	private String mbirth;
	private String dbirth;
	private String gender;
	private String email;
	private String phone;
	
	
	
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MemberDTO(int num, String username, String userid, String passwd, String ybirth, String mbirth,
			String dbirth, String gender, String email, String phone) {
		super();
		this.num = num;
		this.username = username;
		this.userid = userid;
		this.passwd = passwd;
		this.ybirth = ybirth;
		this.mbirth = mbirth;
		this.dbirth = dbirth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}
	
	
	



	@Override
	public String toString() {
		return "MemberDTO [num=" + num + ", username=" + username + ", userid=" + userid + ", passwd=" + passwd
				+ ", ybirth=" + ybirth + ", mbirth=" + mbirth + ", dbirth=" + dbirth + ", gender=" + gender + ", email="
				+ email + ", phone=" + phone + "]";
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public String getYbirth() {
		return ybirth;
	}



	public void setYbirth(String ybirth) {
		this.ybirth = ybirth;
	}



	public String getMbirth() {
		return mbirth;
	}



	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}



	public String getDbirth() {
		return dbirth;
	}



	public void setDbirth(String dbirth) {
		this.dbirth = dbirth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	
}
