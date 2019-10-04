package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ProductComentDTO;
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

	public List<ProductDTO> selectList_Product_OrderByViews() {
		List<ProductDTO> productList = template.selectList("mpProduct.selectList_Product_OrderByViews");
		return productList;
	}

	public ProductDTO productDetail(String pno) {
		ProductDTO product = template.selectOne("mpProduct.productDetail",pno);
		return product;
	}

	public void insertProductComent(HashMap<String, String> map) {
		template.insert("mpProduct.insertProductComent",map);
	}

	public List<ProductComentDTO> comentList(String pno) {
		List<ProductComentDTO> comentList = template.selectList("mpProduct.comentList",pno);
		return comentList;
	}

	public void deleteProductComent(int pno) {
		template.delete("mpProduct.deleteProductComent",pno);
	}

	public void isSellProductBoard(int pno) {
		template.update("mpProduct.isSellProductBoard",pno);
	}

	public List<ProductDTO> productBoardListById(Map<String, String> map) {
		List<ProductDTO> productList = template.selectList("mpProduct.productBoardListById",map);
		return productList;
	}
}
