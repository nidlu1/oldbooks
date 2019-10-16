<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/signUp/uAjax.js"></script>
<script type="text/javascript" src="js/signUp/uMemberCheck.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="js/signUp/uAdress.js"></script>
<link rel="stylesheet" href="css/users.css">


<h1>올드북스의 회원이 되시는 것을 환영합니다</h1><br><br>
<form id="signUpForm">
	<table border="1">
		<tr>
			<td>*아이디</td>
			<td><input type="text" name="id" id="id"></td>
			<td><button type="button" id="mIdCheckButton" class="signUpBtn">중복확인</button><span id="mIDCheck"></span></td>
		</tr>
		<tr>
			<td>*비밀번호</td>
			<td colspan="2"><input type="password" name="pw" id="pw"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" id="pwConfirm"></td>
			<td>
			<button type="button" id="pwConfirmBtn" class="signUpBtn">일치확인</button>
			<span id="pwCheck"></span></td>
		</tr>
		<tr>
			<td>*닉네임</td>
			<td colspan="2"><input type="text" name="username" id="username"></td>
		</tr>
		<tr>
			<td>*이메일</td>
			<td colspan="2"><input type="text" name="email" id="email"></td>
		</tr>
		<tr>
			<td>*핸드폰</td>
			<td colspan="2"><input type="text" name="phone" id="phone"></td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input type="text" id="sample4_postcode" placeholder="우편번호" name="post" value=""></td>
			<td><input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td colspan="2"><input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="addr1" value=""></td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td colspan="2"><input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="addr2" value="">
							<span id="guide" style="color:#999"></span></td>
		</tr>
	</table>
	<button type="submit" id="PutInForUsers" class="signUpBtn">가입신청</button>&nbsp;&nbsp;<button type="reset" class="signUpBtn">다시작성</button>
</form>
<script> 
uMemberCheck()
</script>
<script> //버튼 클릭 관련 스크립트
	function execDaumPostcode() 
	{		uAdressSearch();	}
	
	$(document).ready(function()
	{
		$("#PutInForUsers").on("click",function()
		{
			//$("#signUpForm").attr("action","PutInForUsers");
		});
	});
	
</script>

<script type="text/javascript">//회원가입 스크립트
	var isAjaxing = false;
	
	/*ID 중복 확인
	*/
	$(document).ready(function()
	{
		$("#mIdCheckButton").on("click", function()
		{
			if(isAjaxing)
			{
				alert("처리중");
				return;
			}
			
			isAjaxing = true;
			var mID = document.getElementById("id").value;
			uAjax2("post",
					"idchecked",
					{'Content-Type':'application/json'},
					JSON.stringify( {userid:mID }),
					"text",
				function(data)
				{
					var dataVal =  Number(data);
					switch (dataVal)
					{
					case 1:
						alert("사용가능");
						IDOverLapCheck = true;
						setTimeout(function(){isAjaxing = false;}, 1000);
						break;
					case 2:
						alert("중복");
						setTimeout(function(){isAjaxing = false;}, 1000);
						break;
					}
				}
				,function(xhr,status,error)
				{
					console.log(error);
				});
		});

		var IDOverLapCheck = false;
		var PwOverLapCheck = false;
		$("#PutInForUsers").on("click",function()
				{
			console.log("111");
					var email = document.getElementById("email").value;
					var emailPattern = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;
					
					var mobile = document.getElementById("phone").value;
					var mobilePattern = /^\d{2,3}-\d{3,4}-\d{4}$/;
					
					if(!document.getElementById("id").value.length>0)
					{
						alert("아이디를 입력하세요");
					}else if(IDOverLapCheck==false)
						{
							alert("아이디중복버튼 확인하세요");
						}else if(!document.getElementById("pw").value.length>0)
							{
								alert("비밀번호를 입력하세요");
							}else if(PwOverLapCheck!=false)
								{
									alert("비밀번호 일치 버튼 확인하세요");
								}else if(!document.getElementById("username").value.length>0)
									{
									alert("닉네임를 입력하세요");
									}else if(!emailPattern.test(email))
										{
										alert("이메일를 입력하세요");
										}else if(!mobilePattern.test(mobile))
											{
											alert("전화번호를 입력하세요");
											}else
											{
												alert("회원가입이 완료되었습니다.");
												$("#signUpForm").attr("action","PutInForUsers");
												$("#signUpForm").submit();
											}
					
				});
		
		
	});
	
	$("#pwConfirmBtn").on("click",function()
	{
		var mPW = document.getElementById("pw").value;
			var mPWOL = document.getElementById("pwConfirm").value;
			if(mPW == mPWOL)
			{
				
				PwOverLapCheck = true;		
				uAjax2("post",
						"pwCheck",
						{'Content-Type':'application/json'},
						JSON.stringify( {userid:1 }),
						"text",

				function(data)
				{
					console.log("일치");
					PwOverLapCheck = true;
					alert("비밀번호 일치")
				},
				function(xhr,status,error)
				{
					console.log("error: ",error);
					console.log("status: ",status);
				});
			}else
			{
				uAjax2("post",
						"pwCheck",
						{'Content-Type':'application/json'},
						JSON.stringify( {userid:1 }),
						"text",
				function(data)
				{
					console.log("불일치");
					alert("불일치")
				},
				function(xhr,status,error)
				{
					console.log("error: ",error);
					console.log("status: ",status);
				});
			}
	});
	
	/*
		아이디나 비밀번호 값이 변경시 다시 중복체크하도록 하는 스크립트
	*/
	function check(_this)
	{
		switch (_this.id) {
		case 'id':
			IDOverLapCheck = false;
			break;
		default:
			PwOverLapCheck = false;
			break;
		}
	}
</script>
