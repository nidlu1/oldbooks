
uMemberCheck = function()
{
	var IDOverLapCheck = false;
	var PwOverLapCheck = false;
	$("#mPush").on("click",function()
			{
				var email = document.getElementById("mEmail").value;
				var emailPattern = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;
				
				var mobile = document.getElementById("mPhone").value;
				var mobilePattern = /^\d{2,3}-\d{3,4}-\d{4}$/;
				
				if(!document.getElementById("mID").value.length>0)
				{
					alert("아이디를 입력하세요");
				}else if(IDOverLapCheck==false)
					{
						alert("아이디중복버튼 확인하세요");
					}else if(!document.getElementById("mPW").value.length>0)
						{
							alert("비밀번호를 입력하세요");
						}else if(PwOverLapCheck==false)
							{
								alert("비밀번호 일치 버튼 확인하세요");
							}else if(!document.getElementById("mAlias").value.length>0)
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
											$("#mInsertForm").attr("action", "http://localhost:8090/MyNovelSite/Member");
											$("#mInsertForm").submit();
										}
				
			});
}