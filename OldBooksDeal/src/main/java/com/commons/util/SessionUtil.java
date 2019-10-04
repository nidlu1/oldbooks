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
		 * {comentList : cList} : 댓글전부를 저장하는 세션
		 * {goodList : gList} : 좋아요 관련 세션 저장
		 * {boardTypeList : boardlistAll} : 게시글 종류 관련 세션
		 * {productList : productList} : 상품등록한 정보 관련 세션
		 * {product : product} : 상품 하나에 관한 정보 관련 세션
		 * {pcomentList : pcomentList} 상품게시판의 댓글 관련 세션
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
