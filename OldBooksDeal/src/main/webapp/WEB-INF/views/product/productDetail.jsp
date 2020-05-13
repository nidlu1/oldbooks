<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!-- Link Swiper's CSS -->
  <link rel="stylesheet" href="css/imageSlice.css">
  <c:set value="${product}" var="produ"/>
  <!-- Demo styles -->
  <style>
    html, body {
      position: relative;
      height: 100%;
    }
    body {
      background: #eee;
      font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
      font-size: 14px;
      color:#000;
      margin: 0;
      padding: 0;
    }
    .swiper-container {
      width: 50%;
      height: 100%;
      z-index: 1
    }
    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;
      /* Center slide text vertically */
      display: -webkit-box;
      display: -ms-flexbox;
      display: -webkit-flex;
      display: flex;
      -webkit-box-pack: center;
      -ms-flex-pack: center;
      -webkit-justify-content: center;
      justify-content: center;
      -webkit-box-align: center;
      -ms-flex-align: center;
      -webkit-align-items: center;
      align-items: center;
    }
    
    .inline
	{
	display: grid;
 	grid-template-columns: 1fr 1fr 1fr
	}	
	.bContent
	{
	width: 150px; height: 13px;
	}
  </style>
<br><br><br>
  <!-- Swiper -->
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <c:if test="${produ.originalFilename1 != 'isEmpty'}">
<%--       	<div class="swiper-slide"><img src="../img/${produ.originalFilename1}" style="width: 75%; height: 75%;"></div> --%>
      	<div class="swiper-slide"><img src="image/${produ.originalFilename1}" style="width: 75%; height: 75%;"></div>
      </c:if>
      <c:if test="${produ.originalFilename2 != 'isEmpty'}">
      	<div class="swiper-slide"><img src="image/${produ.originalFilename2}" style="width: 75%; height: 75%;"></div>
      </c:if>
      <c:if test="${produ.originalFilename3 != 'isEmpty'}">
     	 <div class="swiper-slide"><img src="image/${produ.originalFilename3}" style="width: 75%; height: 75%;"></div>
      </c:if>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
  </div>

  <!-- Swiper JS -->
  <script src="js/imageSlice.js"></script>

  <!-- Initialize Swiper -->
  <script>
    var swiper = new Swiper('.swiper-container', {
      pagination: {
        el: '.swiper-pagination',
        dynamicBullets: true,
      },
    });
  </script>


<!-- 글내용 시작 -->

<div class="inline">
	<div></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td >${produ.title}</td>
					<td >${produ.pview}</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="2" style="height: 150px">${produ.pcontents }</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td style="width: 150px">${produ.username }</td>
					<td style="width: 150px">${produ.registdate }</td>
				</tr>
				<tr>
					<td style="width: 150px">${produ.productType }</td>
					<td style="width: 150px">${produ.productLocation }</td>
				</tr>
				<tr>
					<td colspan="2">${produ.price }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div>			
		<button class="boardBtn" id="btnReturn">돌아가기5 </button>			
		<c:if test="${produ.id == Userlogin.id}">
			<button class="boardBtn" id="bUpdate">수정하기</button>
			<button class="boardBtn" id="bDelete">삭제하기</button>
			<button class="boardBtn" id="sellTrue">판매완료</button>
		</c:if>
	</div>
</div>
<br>

<div class="inline">
	<div></div>
	<div>
		<table border="1">
			<c:forEach items="${pcomentList}" var="com">
				<tr>
					<td style="width:150px">${com.content}</td>
					<td style="font-size: 60%;">${com.username}|${com.writeday}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<div class="inline">
	<div></div>
	<div>
		<c:if test="${!empty Userlogin}">
		<div style="display: Inline ;">
			<form method="post" action="productComent">
				<input type="hidden" value="${Userlogin.id}" name="id">
				<input type="hidden" value="${produ.pboard_no }" name="pboardno">
				<input type="text" placeholder="작성시 배려 를 담아주세요" name="ccontent">
				<button type="submit">등록</button>
			</form>
		</div>
	</c:if>
	</div>
</div>

<script>
	$(document).ready(function()
	{
		$("#btnReturn").on("click",function()
		{
			location.href="selectList_Product_OrderByDate";
		});
		
		$("#bDelete").on("click",function()
		{
			var isDelete = confirm("정말로 삭제하시겠습니까?");
			if(isDelete==true)
			{
				location.href="deleteProductBoard/${produ.pboard_no}"
			}
		});

		$("#sellTrue").on("click",function()
		{
			var isDelete = confirm("판매완료 처리를 하시겠습니까?");
			if(isDelete==true)
			{
				location.href="isSellProductBoard/${produ.pboard_no}"
			}
		});
		
		
	});

</script>
