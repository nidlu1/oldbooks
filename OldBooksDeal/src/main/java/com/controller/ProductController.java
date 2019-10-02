package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.commons.util.SessionUtil;
import com.dto.ProductDTO;
import com.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService pService;

	@RequestMapping(value = "/productBoardRegist", method = RequestMethod.POST)
	public String productBoardRegist(ProductDTO pDTO)
	{
		System.out.println(pDTO);
		//파일을 디렉토리폴더에 저장하는 코드
		CommonsMultipartFile theFile1 = pDTO.getImage1();
		CommonsMultipartFile theFile2 = pDTO.getImage2();
		CommonsMultipartFile theFile3 = pDTO.getImage3();	
		String originalFilename1  = "";
		String originalFilename2  = "";
		String originalFilename3  = "";
		//현재시각 구하기
		SimpleDateFormat fm = new SimpleDateFormat("E요일 HH시mm분ss초");
		Date time = new Date();
		String uploadTime =  fm.format(time);
		
		
		//파일을 디렉토리폴더에 저장하는 코드
			if(theFile1!=null)
			{
				originalFilename1  = pDTO.getId()+"_"+uploadTime+"_"+theFile1.getOriginalFilename();
				File f1 = new File("C:\\obDirectory", originalFilename1);
				try {
					theFile1.transferTo(f1);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(theFile2!=null)
			{
				originalFilename2  = pDTO.getId()+"_"+uploadTime+"_"+theFile2.getOriginalFilename();
				File f2 = new File("C:\\obDirectory", originalFilename2);
				try {
					theFile2.transferTo(f2);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(theFile3!=null)
			{
				originalFilename3  = pDTO.getId()+"_"+uploadTime+"_"+theFile3.getOriginalFilename();		
				File f3 = new File("C:\\obDirectory", originalFilename3);
				try {
					theFile3.transferTo(f3);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//인자값을 DB에 insert하는 코드			
			//originalFilename3
			pDTO.setOriginalFilename1(originalFilename1);
			pDTO.setOriginalFilename2(originalFilename2);
			pDTO.setOriginalFilename3(originalFilename3);
			pService.productInsert(pDTO);
			
		return "redirect:../deal";
	}
	
	@RequestMapping(value = "/selectList_Product_OrderByDate")
	public String asdasd(HttpSession session) {
//		새로 들어온 중고품대로 셀렉트리스트 나열하기, 페이징은 나중에
		List<ProductDTO> productList = pService.selectList_Product_OrderByDate();
		SessionUtil su = new SessionUtil();
		su.setAttribute("productList", productList, session);
		for (ProductDTO productDTO : productList) {
			SimpleDateFormat fm = new SimpleDateFormat("E요일 HH시 mm분 ss초");
			Date time = new Date();
			String uploadTime =  fm.format(time);
			productDTO.setRegistdate(uploadTime);
		}
		return "productListOrderByDateUI";
	}
}
