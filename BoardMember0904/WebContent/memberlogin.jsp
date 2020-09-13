<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function login(){
		loginform.submit();
	}
	

</script>
</head>
<body>
	<form action="memberlogin" method="post" name="loginform">
	아이디<input type="text" name="mid" id="mid" placeholder="아이디를 입력하세요"><br>
	비밀번호<input type="text" name="mpassword" id="mpassword" placeholder="비밀번호를 입력하세요"><br>
	</form>
	<button onclick="login()">로그인</button>
</body>
</html>