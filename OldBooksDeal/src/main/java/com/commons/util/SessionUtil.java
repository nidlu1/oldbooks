package com.commons.util;

import javax.servlet.http.HttpSession;

import com.dto.UsersDTO;



public class SessionUtil {

	public void setAttribute(String key, Object object, HttpSession session) {
		session.setAttribute(key, object);
		
		/* {Userlogin : UsersDTO} : 로그인 관련 정보를 세션에 세션에 저장
		 * {boardList : boardlistAll} : 보드게시판의 정보 관련 세션
		 * {boardRetrieve : bDTO}	:	게시판 글 내용 관련 세션
		 * {boardSchList : boardlistAll} : 게시판 검색하기 관련 세션
		 * {schWord : schWord} : 게시판 검색어 세션
		 */
	}

	public Object getAttribute(String key, HttpSession session) {
		Object obj = session.getAttribute(key);
		return obj;
	}
	
	public void removeAttribute(String key, HttpSession session) {
		session.removeAttribute(key);
	}
}
