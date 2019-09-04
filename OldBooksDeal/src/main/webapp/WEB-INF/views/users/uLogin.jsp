<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<h1>로그인화면입니다</h1><br><br>
<div>
	<form id="uLoginForm">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"></td>
			</tr>
		</table>
		<br>
		<button style="font-size: 10px;" id="loginStart" type="submit">로그인</button>&nbsp;
		<button style="font-size: 10px;" id="findIdAndpw">아이디/비밀번호찾기</button>
	</form>
</div>
<script type="text/javascript">
	$(document).ready(function()
	{
		$("#loginStart").on("click",function()
		{
			$("#uLoginForm").attr("action","login")
		});
	});
	
</script>