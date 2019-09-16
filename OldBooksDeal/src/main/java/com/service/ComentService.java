package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	
	
}
