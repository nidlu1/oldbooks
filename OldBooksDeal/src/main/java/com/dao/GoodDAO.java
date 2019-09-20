package com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.GoodDTO;

@Repository
public class GoodDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public void goodInsert(GoodDTO parameter) {
		template.insert("mpGood.goodInsert", parameter);
	}

	public GoodDTO goodSelect(GoodDTO parameter) {
		GoodDTO gDTO = template.selectOne("mpGood.goodSelect", parameter);
		return gDTO;
	}

	public void goodUpdate(GoodDTO parameter) {
		template.update("mpGood.idCheck",parameter);
		template.update("mpGood.viewsPlus",parameter);
	}

	public List<GoodDTO> gListAll(int no) {
		List<GoodDTO> list = template.selectList("mpGood.gListAll",no);
		return list;
	}

	public GoodDTO selectCheck(Map<String, String> map) {
		GoodDTO gDTO = template.selectOne("mpGood.selectCheck",map);
		return gDTO;
	}

}
