package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.GoodDTO;
import com.service.GoodService;



@RestController
public class GoodController
{
	@Autowired
	GoodService gService;
	private GoodDTO gDTO;
	
	@RequestMapping(value = "/goodClick")
	public int goodUpdate(@RequestBody Map<String, String> map)
	{
		System.out.println(map);
		int n = Integer.parseInt(map.get("boardNo"));
		GoodDTO parameter = new GoodDTO();
		parameter.setBoard_no(n);
		parameter.setUsers_id(map.get("usersId"));
		gDTO = null;
		
		if(map.get("usersId")!=null&&map.get("boardNo")!=null)
		{
			gDTO = gService.goodSelect(parameter);
			if(gDTO==null)
			{
				gService.goodInsert(parameter);
				gDTO = gService.goodSelect(parameter);
				if(gDTO.getIdCheck()!='1')
				{
					gService.goodUpdate(parameter);					
					gDTO = gService.goodSelect(parameter);
				}
				//다시 누르면 좋아요 취소하려면 이곳에다가 else{}를 넣어 코드 완성
			}
		}
		int good = gDTO.getGoods();
		return good;
	}
	
	
}
