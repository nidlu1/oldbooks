package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UsersDAO;
import com.dto.UsersDTO;

@Service
public class UsersService {

	@Autowired
	UsersDAO dao;
	
	public void sighUp(UsersDTO usersDTO) {
		dao.sighUp(usersDTO);
	}

	public UsersDTO login(HashMap<String, String> map) {
		UsersDTO user = dao.login(map);
		return user;
	}

	public void userUpdate(UsersDTO uDTO) {
		dao.userUpdate(uDTO);
	}

	public UsersDTO idchecked(Map<String, String> userid) {
		UsersDTO user = dao.idchecked(userid);
		return user;
	}

}
