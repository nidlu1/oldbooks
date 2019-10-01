package com.service;

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

}
