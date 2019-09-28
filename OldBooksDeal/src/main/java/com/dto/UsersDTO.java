package com.dto;

import org.apache.ibatis.type.Alias;

@Alias(value = "usersDTO")
public class UsersDTO extends UsersAbstractDTO{
	
	
	public UsersDTO() {
		super();
	}
	public UsersDTO(String id, String pw, String username, String email, String phone, String post, String addr1,
			String addr2) {
		super(id, pw, username, email, phone, post, addr1, addr2);
	}
	
	
}
