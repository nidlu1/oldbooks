<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
.cComent
{
	width: 200px;
}
</style>

<div>
	댓글리스트(게시판 들어달 때 댓글도 불러오는 트랜잭션 처리)<br>
	<span id="test1"></span><br>
	<span id="test2"></span><br>
	<span id="test3"></span><br>
	<table border="1">
		<thead>
			<tr>
				<td>작성자</td>
				<td class="cComent">내용</td>
				<td>좋아요<br>작성날짜</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${comentList}" var="com">
			<tr>
				<td>${com.username}</td>
				<td class="cComent">${com.content}</td>
				<td>${com.goods}<br>${com.writeday }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<c:if test="${empty Userlogin}">
	로그인 해야 댓글을 달 수 있습니다	
</c:if>
<c:if test="${!empty Userlogin}">
	<div>
		<table></table>
		<input type="text" id="cInput" placeholder="댓글작성시 배려를 담아주세요">
		<button type="button" id="cWrite">등록</button>
	</div>
</c:if>

<script type="text/javascript">
	$(document).ready(function()
	{
		
		$("#cWrite").on("click",function()
		{
			var comm = $("#cInput").val();
			var cId = "${Userlogin.id}";
			var cbno = ${boardRetrieve.no};
			uAjax2("post",
					"commentInput",
					{'Content-Type':'application/json'},
					JSON.stringify( {c:comm, id:cId, bno : cbno } ),
					"json",
					function(data)
					{
						console.log(data);
						$("#test1").html(data);
					
						$("#test3").html(data.idCheck);
					},
					function(error)
					{
						console.log(error);
					});
		});
	});
</script>
