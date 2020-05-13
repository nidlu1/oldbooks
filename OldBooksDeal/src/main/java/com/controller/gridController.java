package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.BoardDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.service.BoardService;

@Controller
public class gridController {
	static final Logger loger = LoggerFactory.getLogger(gridController.class);
	
	@Autowired
	BoardService bService;
	
	@RequestMapping(value = "gridtest")
	public String gridTest() {
		//게시판 리스트 가져오기
		List<BoardDTO> boardlistAll = bService.listAll2();
		System.out.println(boardlistAll);
		
		return "gridTest/gridTest";
	}

}
