package com.commons.intercepter;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class LogCheck extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse response, Object handler
							)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("Userlogin")==null)
		{
			System.out.println("logCheck인터셉터작동");
			
			response.sendRedirect("loginUI");
			return false;
		}else {
			return true;			
		}
	}
}
