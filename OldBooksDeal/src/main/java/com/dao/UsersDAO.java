package com.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.UsersDTO;

@Repository
public class UsersDAO {
	
	@Autowired
	SqlSessionTemplate template;
	
	public void sighUp(UsersDTO usersDTO) {
		template.insert("mpUsers.sighUp", usersDTO);
	}

	public UsersDTO login(HashMap<String, String> map) {
		UsersDTO user = template.selectOne("mpUsers.login", map);
		return user;
	}

	public void userUpdate(UsersDTO uDTO) {
		template.update("mpUsers.userUpdate", uDTO);
	}

}
