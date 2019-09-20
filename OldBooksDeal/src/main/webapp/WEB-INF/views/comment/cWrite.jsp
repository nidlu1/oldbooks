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

<div id="divComent">
	<div></div>
	<table border="1">
		<thead>
		</thead>
		<tbody id="tbodyComent">
			<c:forEach items="${comentList}" var="com">
			<tr>
				<td>${com.username}</td>
				<td class="cComent" >${com.content}</td>
				<td>
					<div class="comGoods" data-comentno="${com.comentno}">${com.goods}</div><br>
					${com.writeday}</td>
				<td><button class="goodPoint" data-good="${com.comentno}" data-username="${com.username}" >좋아요</button>
				<c:if test="${Userlogin.username==com.username}">
				<button class="delComent" data-num="${com.comentno}" >삭제</button>
				</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div>
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
		$(".goodPoint").on("click",function()
		{
			
			var cgoodVar = $(this).attr("data-good"); //코멘트넘버
			var comentUser = $(this).attr("data-username"); //
			var writeUser = "${Userlogin.username}";
			var id = "${Userlogin.id}"; // ""과 null은 다른의미
			var bno = ${boardRetrieve.no};
			
			console.log(cgoodVar, comentUser, writeUser, id, bno);
				if(id=="")
				{
					alert("로그인해야 좋아요를 누를 수 있습니다.");
				}else if(comentUser==writeUser)
				{
					alert("자신이 쓴 댓글엔 좋아요를 누룰 수 없습니다.");
				}else{
					uAjax2(
							"post",
							"goodUpdate",
							{'Content-Type':'application/json'},
							JSON.stringify( {'cgoodVar':cgoodVar, 'bno':bno, 'id':id} ),
							"text",
							function(_data)
							{
								alert("좋아요가 눌러졌습니다");
								console.log(_data)
								if(true) //_data를 잘못 받아왔음.
								{
									$(".comGoods").html(_data);									
								}
							},
							function(_error)
							{
								
							}
							);				
				}
				
			
		});
		
		
		$(".delComent").on("click",function()
		{
			var cnoVar = $(this).attr("data-num");
			console.log(cnoVar);
			uAjax2(
					"post",
					"delComent",
					{'Content-Type':'application/json'},
					JSON.stringify( {'no':cnoVar} ),
					"text",
					function(_data)
					{
						alert("삭제되었습니다");
						
						$("#divComent").empty();
						$("#divComent").load(location.href+' #divComent');
					},
					function(_error)
					{
						
					}
					);
			
		});
		
		$("#cWrite").on("click",function()
		{
			var comm = $("#cInput").val();
			var cId = "${Userlogin.id}";
			var cbno = ${boardRetrieve.no};
			uAjax2("post",
					"commentInput",
					{'Content-Type':'application/json'},
					JSON.stringify( {content:comm, id:cId, bno : cbno } ),
					"json",
					function(data)
					{		
						var username = data.username;
						var content = data.content;
						var goods = data.goods;
						var writeday = data.writeday;
						
						$("#tbodyComent").append
						/*
						(
							"<tr><td>"+ username + 
							"</td><td>"+content +
							"</td><td>"+goods+"<br>"+writeday+"<br>"+"</td>" +
							"<td><button>좋아요</button> "+
							"<button class='delComent' >삭제</button></td></tr>"

						);*/	
						
						$("#divComent").load(location.href+' #divComent');
			
					},	
					function(error)
					{
						console.log(error);
					});
		});
		
		

	});
</script>
