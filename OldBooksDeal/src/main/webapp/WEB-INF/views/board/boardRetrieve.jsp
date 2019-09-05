<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/board.css">
<script src="js/signUp/uAjax.js"></script>
<style>
.bTitle
{
	width: 75px; height: 13px;
}
.bContent
{
	width: 150px; height: 13px;
}
.inline
{
	display: grid;
 	grid-template-columns: 2fr 100px 1fr;
}
</style>

<c:set value="${boardRetrieve}" var="b"></c:set>


<h1>게시판 보기</h1>
<br>
<div class="inline">
	<div>
		<table border="1">
			<thead>
				<tr>
					<th class="bTitle">제목</th>
					<td class="bContent">${b.title}</td>
					<th class="bTitle">종류</th>
					<td class="bContent">${b.type}</td>				
				</tr>
			</thead>
			<tbody>
				<tr>
					<th class="bTitle">작성자</th>
					<td class="bContent">${b.username}</td>				
					<th class="bTitle">작성일</th>
					<td class="bContent">${b.writedate}</td>				
				</tr>
				<tr>
					<th class="bTitle">조회수</th>
					<td class="bContent">${b.views}</td>
<!-- 					좋아요 링크걸기: ajax사용				 -->
					<th class="bTitle"><button id="btnGood">좋아요</button></th>
					<td class="bContent" id="goodState">${b.good}</td>				
				</tr>
				<tr>
					<th class="bTitle">글내용</th>
					<td colspan="3" style="height: 200px;">${b.content}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<button class="boardBtn">답변하기</button>			
		<button class="boardBtn" id="btnReturn">돌아가기 ${b.id}</button>			
		<c:if test="${b.id == Userlogin.id}">
			<button class="boardBtn" id="bUpdate">수정하기</button>
			<button class="boardBtn" id="bDelete">삭제하기</button>
		</c:if>
	</div>
</div>

<div>
댓글내용
</div>
<div>
댓글입력
</div>
<script	type="text/javascript">//버튼 클릭시 링크이동하는 스크립트
	$(document).ready(function()
	{
		$("#bUpdate").on("click",function()
		{
			location.href="boardRetrieveUpdate";
		});
		$("#bDelete").on("click",function()
		{
			var isDelete = confirm("정말로 삭제하시겠습니까?");
			if(isDelete==true)
			{
				location.href="boardRetrieveDelete/${b.no}"
			}
		});
		$("#btnReturn").on("click",function()
		{
			{
				location.href="boardUI/1"
			}
		});
		
	});
</script>
<script type="text/javascript">
	$(document).ready(function()
	{
		$("#btnGood").on("click",function()
		{
			var idCheck = "${Userlogin.id}";
			var writer = "${b.id}";
			
			if(idCheck==null)
			{
				alert("로그인이 필요한 작업니다");
			}else if(idCheck==writer)
			{
				alert("자기글에 추천할 수 없습니다");
			}else
			{	
				uAjax2
				(
				'post',
				"goodClick",
				{'Content-Type':'application/json'},
				JSON.stringify( {boardNo:${b.no}, usersId: idCheck } ),
				"text",
				function(data,status,xhr)
				{
					$("#goodState").text(data);
				},
				function(xhr,status,error){}
				
				);
			}
			
		});
	});
</script>