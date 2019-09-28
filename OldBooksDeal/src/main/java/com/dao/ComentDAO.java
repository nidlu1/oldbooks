package com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ComentDTO;
import com.dto.GoodDTO;

@Repository
public class ComentDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<ComentDTO> cAllList(int no) {
		List<ComentDTO> list = template.selectList("mpComent.cAllList",no);
		return list;
	}

	public ComentDTO inOutPut(Map<String, String> map) {
		template.insert("mpComent.insertComent",map);
		ComentDTO cDTO = template.selectOne("mpComent.selectOne", map);
		return cDTO;
	}

	public void delComent(Map<String, String> map) {
		template.delete("mpComent.delComent",map);
		
	}

	public int goodUpdate(Map<String, String> map) {
		template.insert("mpGood.goodInsertComent",map); //넣고
		template.update("mpGood.goodUpdate",map);//수정하고
		template.update("mpGood.idcheckComent",map);//체크로 바꾸고
		int gDTO = template.selectOne("mpGood.goodSelect22",map); //꺼낸다
		return gDTO;
	}

	public ComentDTO selectOne(Map<String, String> map) {
		ComentDTO cDTO = template.selectOne("mpComent.selectOne", map);
		return cDTO;
	}
	
	
}
