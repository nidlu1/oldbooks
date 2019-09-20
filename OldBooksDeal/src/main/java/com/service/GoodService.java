package com.service;

import java.util.List;
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

	public List<GoodDTO> gListAll(int no) {
		List<GoodDTO> list = dao.gListAll(no);
		return list;
	}

	public GoodDTO selectCheck(Map<String, String> map) {
		GoodDTO gDTO = dao.selectCheck(map);
		return gDTO;
	}

}
