<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

		function idcheck1()  {var id=document.getElementById("mid").value;
		var idch=document.getElementById("id01");
		// 조건문을 사용하여 아이디 입력이 없으면 아이디를 입력하세요라는
		//alert 출력
		// 6~10글자가 아니면 6~10글자로 입력하세요라는 alert츨력 
		//6~10글자로 입력했으면 좋아요라는 alert츨력 
		 if(id.length==0)
		    {idch.style.color = "red";
		    idch.style.fontSize= "12px";
		     idch.innerHTML="아이디를 입력하세요"
		    }
		 else
		    {if(id.length>=6 && id.length<=10)
		        {idch.style.color = "green";
		         idch.style.fontSize= "12px";
		         idch.innerHTML="사용가능"
		        }
		     else
		        {idch.style.color = "red";
		         idch.style.fontSize= "12px";
		         idch.innerHTML=" 6~10글자로 입력하세요"
		        }
		    }
		}
		
		function pwdEqFn1()  {var pwd = document.getElementById("mpassword").value;
		 var pwdch = document.getElementById("mpasswordch").value;
		 var eqmsg = document.getElementById("pwdEq");
		 if(pwd==pwdch)
		    {eqmsg.style.color = "green";
		    eqmsg.style.fontSize= "12px";
		    eqmsg.innerHTML="일치";
		    }
		 else
		    {eqmsg.style.color = "red";
		    eqmsg.style.fontSize= "12px";
		    eqmsg.innerHTML="불일치";
		    }
		}
		
		function pwdCheck1() {var exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%#?&])[A-Za-z\d$@$!%#?&]{8,16}$/;
		 //비밀번호 검증을 위한 정규식(어떠한 것이 들어가야만 한다)
		 // 소문자,대문자,숫자,특수문자가 포함되고 자릿수는 8~16[]   
		 var pwd = document.getElementById("mpassword").value;
		 var pwdch=document.getElementById("pwdch");
		 if(pwd.match(exp))
		    {pwdch.style.color="green";
		     pwdch.innerHTML="비밀번호 형식 맞음";
		     pwdch.style.fontSize= "12px";
		    }
		 else
		    {pwdch.style.color="red";
		     pwdch.innerHTML="소문자,대문자,숫자,특수문자가 포함되고 자릿수는 8~16";
		     pwdch.style.fontSize= "12px";
		    }
		}
		
		function phonech()  {var pnum=document.getElementById("mphone").value;
		 var exp = /^\d{3}-\d{4}-\d{4}$/;
		 var num=document.getElementById("pch");
		 if(pnum.match(exp))
		    {num.style.color="green";
		     num.innerHTML="전화번호 형식 맞음";
		     num.style.fontSize= "12px";
		    }
		 else
		    {num.style.color="red";
		     num.style.fontSize= "12px";
		     num.innerHTML="전화번호 형식 안맞음";
		    }
		}
		
		  function emailselFn(emailvalue)  {console.log(emailvalue);
          document.getElementById("memailsel").value=emailvalue;
         }
		  
		  function sample6_execDaumPostcode() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

		                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var addr = ''; // 주소 변수
		                var extraAddr = ''; // 참고항목 변수

		                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
		                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
		                    addr = data.roadAddress;
		                } else { // 사용자가 지번 주소를 선택했을 경우(J)
		                    addr = data.jibunAddress;
		                }

		                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
		                if(data.userSelectedType === 'R'){
		                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
		                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
		                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                        extraAddr += data.bname;
		                    }
		                    // 건물명이 있고, 공동주택일 경우 추가한다.
		                    if(data.buildingName !== '' && data.apartment === 'Y'){
		                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                    }
		                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
		                    if(extraAddr !== ''){
		                        extraAddr = ' (' + extraAddr + ')';
		                    }
		                    // 조합된 참고항목을 해당 필드에 넣는다.
		                    document.getElementById("sample6_extraAddress").value = extraAddr;
		                
		                } else {
		                    document.getElementById("sample6_extraAddress").value = '';
		                }

		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                document.getElementById('sample6_postcode').value = data.zonecode;
		                document.getElementById("sample6_address").value = addr;
		                // 커서를 상세주소 필드로 이동한다.
		                document.getElementById("sample6_detailAddress").focus();
		            }
		        }).open();
		    }
		  
		 function memberjoin(){
			 memberjoinform.submit();
		 }
</script>
</head>
<body>
	<form action="memberjoin" method="post" name="memberjoinform" enctype="multipart/form-data">
	아이디<input type="text" name="mid" id="mid" placeholder="아이디를 입력하세요" onkeyup="idcheck1()" ><br>
	<span id="id01"></span><br>
	
	비밀번호<input type="text" name="mpassword" id="mpassword" placeholder="비밀번호를 입력하세요" onkeyup="pwdCheck1()" ><br>
	<span id="pwdch"></span><br>
	
	비밀번호 확인<input type="text" name="mpassword" id="mpasswordch" placeholder="비밀번호를 입력하세요" onkeyup="pwdEqFn1()" ><br>
	<span id="pwdEq"></span><br>
	
	이름<input type="text" name="mname" id="mname" placeholder="이름" ><br>
	생년월일<input type="date" name="mbirth" id="mbirth" placeholder="생년월일 입력하세요"  ><br>
	이메일<input  type="email" id="memail" name="memail">
            <span>@</span><input type="text" id= "memailsel" name="memail">
            <select  id="emailsel" onchange="emailselFn(this.value)">
                <option value="">직접입력</option>
                <option value="naver.com">naver.com</option>
                <option value="hanmail.com">hanmail.com</option>
                <option value="gmail.com">gmail.com</option>
            </select><br>	
	주소   <br>
		<input type="text" id="sample6_postcode" placeholder="우편번호">
		<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample6_address" placeholder="주소"><br>
		<input type="text" id="sample6_detailAddress" placeholder="상세주소">
		<input type="text" id="sample6_extraAddress" placeholder="참고항목"><br>
	휴대폰<input type="text" name="mphone" id="mphone" onkeyup="phonech()" ><br>
	<span id="pch"></span><br>
	프로필사진<input type="file" name="mphoto" id="mphoto"><br>
	</form>
	<button onclick="memberjoin()">회원가입</button>
</body>
</html>