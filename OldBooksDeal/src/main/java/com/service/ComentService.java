package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ComentDAO;
import com.dto.ComentDTO;

@Service
public class ComentService {

	@Autowired
	ComentDAO dao;
	
	public List<ComentDTO> cAllList(int no) {
		List<ComentDTO> cList = dao.cAllList(no);
		return cList;
	}

	@Transactional
	public ComentDTO inOutPut(Map<String, String> map) {
		ComentDTO cDTO = dao.inOutPut(map);
		return cDTO;
	}

	public void delComent(Map<String, String> map) {
		dao.delComent(map);
		
	}

	public void goodUpdate(Map<String, String> map) {
		dao.goodUpdate(map);
		
	}

	public ComentDTO selectOne(Map<String, String> map) {
		
		return null;
	}


	
	
}
