<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" contentType="text/html; charset=utf-8"%>

<section class="MOD_MENU" data-theme="_bgp">
  <div data-layout="_r" class="nopadding">
    <nav class="MOD_MENU_Nav">
      <p class="MOD_MENU_Title">Menu</p>
      <svg class="MOD_MENU_Button" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="30px" height="30px" viewBox="0 0 30 30" enable-background="new 0 0 30 30" xml:space="preserve">
        <rect width="30" height="6"/>
        <rect y="24" width="30" height="6"/>
        <rect y="12" width="30" height="6"/>
      </svg>
      <ul class="AP_Menu_List">
        <li>
          <a href="home" data-theme="_bgp">HOME</a>
        </li>
        <li>
          <a href="#" data-theme="_bgp">종류</a>
          <ul>
            <li>
              <a href="#" data-theme="_bgpd">가구</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">책</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">차량</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">식료품</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">악세사리</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">의류</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">디지털</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#" data-theme="_bgp">새로 들어온 중고품</a>
        </li>
        <li>
          <a href="boardUI/1" data-theme="_bgp">커뮤니티</a>
          <ul>
            <li>
              <a href="boardFreeUI/1" data-theme="_bgpd">자유게시판</a>
            </li>
            <li>
              <a href="boardRequestUI/1" data-theme="_bgpd">요청게시판</a>
            </li>
            <li>
              <a href="boardAppreciateUI/1" data-theme="_bgpd">감상게시판</a>
            </li>
          </ul>
        </li>
        <c:if test="${!empty Userlogin}">
	        <li>
	          <a href="logCheckProductRegist" data-theme="_bgp">상품 등록하기</a>
	        </li>
	        <li>	
	          <a href="#" data-theme="_bgp">myPage</a>
	        </li>
		</c:if>
      </ul>
    </nav>
  </div>
</section>
<!--
END MODULE AREA 1: Menu 1
-->

