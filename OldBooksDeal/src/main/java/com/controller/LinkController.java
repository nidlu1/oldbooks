package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.commons.util.SessionUtil;
import com.dto.ProductDTO;
import com.dto.UsersDTO;
import com.service.ProductService;
import com.service.UsersService;

@Controller
public class LinkController
{
	@Autowired
	UsersService uService;
	@Autowired
	ProductService pService;
	
	@RequestMapping(value = "/")
	public String index(HttpSession session)
	{
		List<ProductDTO> productList = pService.selectList_Product_OrderByViews();
		SessionUtil su = new SessionUtil();
		su.setAttribute("productList", productList, session);
		for (ProductDTO productDTO : productList) {
			SimpleDateFormat fm = new SimpleDateFormat("E요일 HH시 mm분 ss초");
			Date time = new Date();
			String uploadTime =  fm.format(time);
			productDTO.setRegistdate(uploadTime);
		}
		return "indexUI";
	}
	
	@RequestMapping(value = "/home")
	public String home(HttpSession session)
	{
		List<ProductDTO> productList = pService.selectList_Product_OrderByViews();
		SessionUtil su = new SessionUtil();
		su.setAttribute("productList", productList, session);
		for (ProductDTO productDTO : productList) {
			SimpleDateFormat fm = new SimpleDateFormat("E요일 HH시 mm분 ss초");
			Date time = new Date();
			String uploadTime =  fm.format(time);
			productDTO.setRegistdate(uploadTime);
		}
		return "redirect:../deal";
	}
	
}
