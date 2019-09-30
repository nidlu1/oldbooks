package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.ProductDTO;

@Controller
public class ProductController {

	@RequestMapping(value = "/productBoardRegist")
	public String productBoardRegist(ProductDTO pDTO)
	{
		//배열로 못받음.
		System.out.println("접속");
		System.out.println(pDTO);
		return "index";
	}
}
