package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ComentDTO;

@Repository
public class ComentDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<ComentDTO> cAllList(int no) {
		List<ComentDTO> list = template.selectList("mpComent.cAllList",no);
		return list;
	}
	
	
}
