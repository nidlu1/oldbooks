package com.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
		String originalFilename1  = null;
		String originalFilename2  = null;
		String originalFilename3  = null;
			if(theFile1!=null)
			{
				originalFilename1  = theFile1.getOriginalFilename();
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
				originalFilename2  = theFile2.getOriginalFilename();
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
				originalFilename3  = theFile3.getOriginalFilename();		
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
			String imageName = pDTO.getId()+":"+originalFilename1+","+originalFilename2+","+originalFilename3;
			pDTO.setImageName(imageName);
			pService.productInsert(pDTO);
			
			
		return "redirect:../deal";
	}
	
	@RequestMapping(value = "/asdasdasd")
	public void asdasd() {
//		새로 들어온 중고품대로 셀렉트리스트 나열하기
	}
}
