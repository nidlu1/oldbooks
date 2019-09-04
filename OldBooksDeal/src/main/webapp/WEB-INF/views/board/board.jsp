<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/board.css">
<h1>게시판</h1>
<form id="boardForm">
	<select name="schType">
		<option selected="selected" value="title">제목</option>
		<option value="author">글쓴이</option>
	</select>
	<input type="text" placeholder="검색단어" name="schWord">
	<button class="boardBtn" id="schBtn">검색하기</button>
	<button class="boardBtn" style="font-size: 10px">추천수 10이상만 보기</button>

	<c:if test="${!empty Userlogin}">
		<button class="boardBtn" id="boardWrite" type="submit">글쓰기</button>
	</c:if>
</form>

<!-- 테이블내용 -->
<div>
	<table class="boardTable">
		<thead>
		<tr class=boardHead>
			<th class="boardId">id</th>
			<th class="boardType">구분</th>
			<th class="boardTitle">제목</th>
			<th class="boardUsername">글쓴이</th>
			<th class="boardGood">추천</th>
			<th class="boardViews">조회</th>
			<th class="boardWritedate">날짜</th>
		</tr>
		</thead>
		<tbody>
		

			<c:forEach items="${boardList}" var="b">
				<tr class="boardContent">	
					<td class="boardId">${b.no}</td>
					<td class="boardType">${b.type}</td>
					<td class="boardTitle"><a href="boardRetrieve/${b.no}">${b.title}</a></td>
					<td class="boardUsername">${b.username}</td>
					<td class="boardGood">${b.good}</td>
					<td class="boardViews">${b.views}</td>
					<td class="boardWritedate">${b.writedate}</td>
				</tr>
			</c:forEach>

		</tbody>
		<tfoot>
		</tfoot>
	</table>
	<div style="margin: 20px; font-size: 30px">	
		<c:if test="${prev}">
			<a href="boardUI/${startPage-1}">[&lt;]</a>
		</c:if>

		<c:forEach begin="${startPage}" end="${endPage}" var="index">
			<a href="boardUI/${index}">[${index}]</a>
		</c:forEach>
		
		<c:if test="${next}">
				<a href="boardUI/${endPage+1}">[&gt;]</a>	
		</c:if>
	</div>
</div>
<script type="text/javascript"> // 버튼클릭 관련 스크립트
	$(document).ready(function()
	{		
		$("#boardWrite").on("click",function()
		{
			$("#boardForm").attr("action","logCheckBoardWriteUI");
		});	
		
		$("#schBtn").on("click",function()
		{
			$("#boardForm").attr("action","schBoardUI/1");
		});	
	});
</script>
