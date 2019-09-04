package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.commons.util.SessionUtil;
import com.dto.UsersDTO;
import com.service.UsersService;

@Controller
public class UsersController
{
	@Autowired
	UsersService uService;
	
	@RequestMapping(value = "/PutInForUsers")
	public String signUp(UsersDTO usersDTO, RedirectAttributes attr)
	{	
		uService.sighUp(usersDTO);			
		attr.addFlashAttribute("sighUpComplete", "회원가입이 완료되었음");
		return "redirect:../deal";
	}
	
	@RequestMapping(value = "/login")
	public String login(@RequestParam HashMap<String, String> map,
						HttpSession session, Model m)
	{	

			UsersDTO user = new UsersDTO();
			user = uService.login(map);
			SessionUtil su = new SessionUtil();
			su.setAttribute("Userlogin",user, session);	
						
			if(user==null)
			{
				m.addAttribute("loginFalse", "로그인정보가 잘못되었습니다. 다시 로그인해주세요");
				return "loginUI";
			}else
			{
				return "redirect:../deal";	
			}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, Model m)
	{
		SessionUtil su = new SessionUtil();
		su.removeAttribute("Userlogin", session);
		return "redirect:../deal";
	}
	
	@RequestMapping(value = "/userUpdateSend")
	public String userUpdate(UsersDTO uDTO, RedirectAttributes rea,
							HttpSession session)
	{
		uService.userUpdate(uDTO);
		rea.addFlashAttribute("uUpdateCom", "회원정보가 변경되었습니다. 다시 로그인하세요");
		SessionUtil su = new SessionUtil();
		su.removeAttribute("Userlogin", session);
		
		return "redirect:../deal";
	}
}
