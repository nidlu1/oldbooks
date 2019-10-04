package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.commons.util.SessionUtil;
import com.dto.ProductComentDTO;
import com.dto.ProductDTO;
import com.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService pService;

	@RequestMapping(value = "/productBoardRegist", method = RequestMethod.POST)
	public String productBoardRegist(ProductDTO pDTO)
	{
		
		//파일을 디렉토리폴더에 저장하는 코드
		CommonsMultipartFile theFile1 = pDTO.getImage1();
		CommonsMultipartFile theFile2 = pDTO.getImage2();
		CommonsMultipartFile theFile3 = pDTO.getImage3();	
		String originalFilename1  = "isEmpty";
		String originalFilename2  = "isEmpty";
		String originalFilename3  = "isEmpty";
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
		for (ProductDTO productDTO : productList) {
			SimpleDateFormat fm = new SimpleDateFormat("E요일 HH시 mm분");
			String uploadTime =  fm.format(productDTO.getResistdate());
			productDTO.setRegistdate(uploadTime);
		}
		su.setAttribute("productList", productList, session);
		return "productListOrderByDateUI";
	}
	
	@RequestMapping(value = "productDetail/{productNo}")
	public String productDetail(	@PathVariable("productNo")String pno,
									HttpSession session,
									RedirectAttributes rda)
	{
		ProductDTO product = pService.productDetail(pno);
		List<ProductComentDTO> pcomentList = pService.comentList(pno);
		SessionUtil su = new SessionUtil();
		su.setAttribute("product", product, session);
		su.setAttribute("pcomentList", pcomentList, session);
		return "redirect:../productDetail";
	}
	
	@RequestMapping(value = "productComent", method = RequestMethod.POST)
	public String productComentInsert(	@RequestParam HashMap<String, String> map,
										HttpSession session)
	{
		pService.insertProductComent(map);
		String pno = map.get("pboardno");
		ProductDTO product = pService.productDetail(pno);
		List<ProductComentDTO> pcomentList = pService.comentList(pno);
		SessionUtil su = new SessionUtil();
		su.setAttribute("product", product, session);
		su.setAttribute("pcomentList", pcomentList, session);
		return "redirect:productDetail";
	}
	
	@RequestMapping(value = "deleteProductBoard/{pno}")
	public String deleteProductBoard(@PathVariable(value = "pno") int pno)
	{
		pService.deleteProductComent(pno);
		return "redirect:../selectList_Product_OrderByDate";
	}
	
	@RequestMapping(value = "isSellProductBoard/{pno}")
	public String isSellProductBoard(@PathVariable(value = "pno") int pno)
	{
		pService.isSellProductBoard(pno);
		return "redirect:../deal";
	}
	
	@RequestMapping(value = "logCheckMyPage/{sell}/{id}")
	public String myPageIsSell(	@PathVariable("sell")String sell,
								@PathVariable("id")String id,
								HttpSession session)
	{

		String n = "0";
		switch (sell) {
		case "isSell":
			n="1";
			break;
		case "isNotSell":
			
			break;

		default:
			break;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("isSell", n);		
		List<ProductDTO> productList = pService.productBoardListById(map);
		SessionUtil su = new SessionUtil();
		su.setAttribute("productList", productList, session);
		return "redirect:../../productListOrderById";
	}
}
