package com.dao;

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

}
