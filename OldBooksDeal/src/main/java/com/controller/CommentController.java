package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.dto.GoodDTO;
import com.dto.PageBoardDTO;
import com.service.BoardService;

@Controller
public class CommentController
{
	@Autowired
	BoardService bService;
	
	@ResponseBody
	@RequestMapping(value = "/commentInput" )
	public GoodDTO commentInput(@RequestBody Map<String, String> map)
	{
		System.out.println(map);
		//받아온 파라미터를 이용하여 댓글을 저장하고, 댓글을 출력한다.
		GoodDTO dto = new GoodDTO(854, '0', "asd", 251, 6);
		
		return dto;
	}
	
}
