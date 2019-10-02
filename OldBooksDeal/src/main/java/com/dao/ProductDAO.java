package com.dao;

import java.util.List;

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

	public List<ProductDTO> selectList_Product_OrderByDate() {
		List<ProductDTO> productList = template.selectList("mpProduct.selectList_Product_OrderByDate");
		return productList;
	}
}
