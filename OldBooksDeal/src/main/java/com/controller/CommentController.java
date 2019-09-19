package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.commons.util.SessionUtil;
import com.commons.util.pagingMaker;
import com.dto.BoardDTO;
import com.dto.ComentDTO;
import com.dto.GoodDTO;
import com.dto.PageBoardDTO;
import com.service.BoardService;
import com.service.ComentService;

@Controller
public class CommentController
{
	@Autowired
	BoardService bService;
	@Autowired
	ComentService cService;
	
	@ResponseBody
	@RequestMapping(value = "/commentInput" )
	public ComentDTO commentInput(@RequestBody Map<String, String> map,
										HttpSession session)
	{
		ComentDTO cDTO = cService.inOutPut(map);
		List<ComentDTO> cList = cService.cAllList(Integer.parseInt(map.get("bno")));
		
		SessionUtil su = new SessionUtil();
		su.setAttribute("comentList", cList, session);
		
		return cDTO;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delComent")
	public void delComent(@RequestBody Map<String, String> map)
	{
		cService.delComent(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "/goodUpdate")
	public void goodUpdate(@RequestBody Map<String, String> map)
	{
		//good_db 인설트 및 good과 DB가져오기.
		
		/*
		System.out.println(map);
		ComentDTO cDTO = cService.selectOne(map);
		
		System.out.println(cDTO.getUsername());
		
		cService.goodUpdate(map);
		*/
	}
	
}
