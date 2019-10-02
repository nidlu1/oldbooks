package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDAO;
import com.dto.ProductDTO;

@Service
public class ProductService {
	@Autowired
	ProductDAO dao;
	@Transactional
	public void productInsert(ProductDTO pDTO) {
		dao.productInsert(pDTO);		
	}
	public List<ProductDTO> selectList_Product_OrderByDate() {
		List<ProductDTO> productList = dao.selectList_Product_OrderByDate();
		return productList;
	}

}
