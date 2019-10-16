<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/signUp/uAjax.js"></script>
<script type="text/javascript" src="js/signUp/uMemberCheck.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="js/signUp/uAdress.js"></script>
<link rel="stylesheet" href="css/users.css">

<c:set value="${Userlogin}" var="u" />
<h1>회원정보 수정</h1><br><br>
<form id="signUpForm">
<input type="hidden" name="id" value="${u.id}">
	<table border="1">
		<tr>
			<td>*비밀번호</td>
			<td colspan="2"><input type="password" name="pw" id="pw"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" id="pwConfirm"></td>
			<td><button type="button" id="pwConfirmBtn" class="signUpBtn">일치확인</button><span id="pwCheck"></span></td>
		</tr>
		<tr>
			<td>*닉네임</td>
			<td colspan="2"><input type="text" name="username" id="username" value="${u.username}"></td>
		</tr>
		<tr>
			<td>*이메일</td>
			<td colspan="2"><input type="text" name="email" id="email" value="${u.email }"></td>
		</tr>
		<tr>
			<td>*핸드폰</td>
			<td colspan="2"><input type="text" name="phone" id="phone" value="${u.phone }"></td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input type="text" id="sample4_postcode" placeholder="우편번호" name="post" value="${u.post }"></td>
			<td><input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td colspan="2"><input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="addr1" value="${u.addr1 }"></td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td colspan="2"><input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="addr2" value="${u.addr2 }">
							<span id="guide" style="color:#999"></span></td>
		</tr>
	</table>
	<button type="submit" id="PutInForUsers" class="signUpBtn">정보수정하기</button>&nbsp;&nbsp;<button type="reset" class="signUpBtn">다시작성</button>
</form>
<script> 
	
</script>
<script> //버튼 클릭 관련 스크립트
	function execDaumPostcode() 
	{		uAdressSearch();	}
	
	$(document).ready(function()
	{
		$("#PutInForUsers").on("click",function()
		{
			$("#signUpForm").attr("action","userUpdateSend");
		});
		
		$("#pwConfirmBtn").on("click",function()
			{
			var mPW = document.getElementById("pw").value;
				var mPWOL = document.getElementById("pwConfirm").value;
				if(mPW == mPWOL)
				{
					if(mPW == null)
					{
						alert("공란입니다");
					}else{
					alert("비밀번호 일치");
					PwOverLapCheck = true;								
					}
					
				}else
				{
					alert("비밀번호 불일치");
				}
			});
		
	});
	
</script>
