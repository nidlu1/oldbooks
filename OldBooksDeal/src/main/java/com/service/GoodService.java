package com.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.GoodDAO;
import com.dto.GoodDTO;

@Service
public class GoodService {

	@Autowired
	GoodDAO dao;
	
	public void goodInsert(GoodDTO parameter) {
		dao.goodInsert(parameter);
	}

	public GoodDTO goodSelect(GoodDTO parameter) {
		GoodDTO gDTO = dao.goodSelect(parameter);
		return gDTO;
	}
	
	@Transactional
	public void goodUpdate(GoodDTO parameter) {
		dao.goodUpdate(parameter);
		
	}

}
