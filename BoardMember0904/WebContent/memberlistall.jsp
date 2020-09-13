<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function memberview(mid){
		location.href='memberview?mid='+mid;
	}
	
	function memberdelete(mid){
		location.href='memberdelete?mid='+mid;
	}
</script>
</head>
<body>
	<table border=1>
	<tr>
	<th>아이디</th><th>이름</th><th>생년월일</th><th>프로필사진</th><th>회원 정보 조회</th><th>회원 삭제</th></tr>
	
		<c:forEach var="ml" items="${mlist}">
	<tr>
		<td>${ml.mid}</td> 
		<td>${ml.mname}</td>
		<td>${ml.mbirth} </td>
		<td>${ml.mphoto} </td>
		<td><button onclick="memberview('${ml.mid}')">회원 정보 조회</button></td>
		<td><button onclick="memberdelete('${ml.mid}')">회원 삭제</button></td>
		</tr>
		</c:forEach>
</table>

</body>
</html>