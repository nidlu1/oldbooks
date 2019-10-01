package com.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ProductDTO;

@Repository
public class ProductDAO {
	@Autowired
	SqlSessionTemplate template;

	public void productInsert(ProductDTO pDTO) {
		template.insert("mpProduct.productBoardInsert",pDTO);
	}
}
