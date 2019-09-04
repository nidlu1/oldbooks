package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.UsersDTO;
import com.service.UsersService;

@Controller
public class LinkController
{
	@Autowired
	UsersService uService;
	
	@RequestMapping(value = "/")
	public String index()
	{
		return "indexUI";
	}
	
	@RequestMapping(value = "/home")
	public String home()
	{
		return "redirect:../deal";
	}
	
}
