package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDAO;
import com.dto.ProductComentDTO;
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
	public List<ProductDTO> selectList_Product_OrderByViews() {
		List<ProductDTO> productList = dao.selectList_Product_OrderByViews();
		return productList;
	}
	public ProductDTO productDetail(String pno) {
		ProductDTO product = dao.productDetail(pno);
		return product;
	}
	public void insertProductComent(HashMap<String, String> map) {
		dao.insertProductComent(map);
	}
	public List<ProductComentDTO> comentList(String pno) {
		List<ProductComentDTO> comentList = dao.comentList(pno);
		return comentList;
	}
	public void deleteProductComent(int pno) {
		dao.deleteProductComent(pno);
	}
	public void isSellProductBoard(int pno) {
		dao.isSellProductBoard(pno);
	}
	public List<ProductDTO> productBoardListById(Map<String, String> map) {
		List<ProductDTO> productList = dao.productBoardListById(map);
		return productList;
	}

}
