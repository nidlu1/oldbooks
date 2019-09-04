package com.dto;

public abstract class BoardAbstractDTO {
	private String id;
	private String pw;
	private String username;
	private String email;
	private String phone;
	private String post;
	private String addr1;
	private String addr2;
	public BoardAbstractDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardAbstractDTO(String id, String pw, String username, String email, String phone, String post,
			String addr1, String addr2) {
		super();
		this.id = id;
		this.pw = pw;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	@Override
	public String toString() {
		return "BoardAbstractDTO [id=" + id + ", pw=" + pw + ", username=" + username + ", email=" + email + ", phone="
				+ phone + ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + "]";
	}
	
}
