<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<div>
	댓글리스트
</div>

<div>
	<input type="text" id="cInput"><button type="button" id="cWrite">댓글입력</button>
</div>

<script type="text/javascript">
	$(document).ready(function()
	{
		
		$("#cWrite").on("click",function()
		{
			var comm = $("#cInput").val();
			var cId = "${Userlogin.id}"
			uAjax2("post",
					"commentInput",
					{'Content-Type':'application/json'},
					JSON.stringify( {c:comm, boardNo:${b.no}, id:cId} ),
					"text",
					function(data)
					{
						console.log(data);
					},
					function(error)
					{
						console.log(error);
					});
		});
	});
</script>
