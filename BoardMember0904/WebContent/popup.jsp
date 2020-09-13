<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<tr>
	<th>아이디</th><th>이름</th><th>생년월일</th><th>프로필사진</th><th>이메일</th></tr>
	
		
	<tr>
		<td>${mdto.mid}</td> 
		<td>${mdto.mname}</td>
		<td>${mdto.mbirth} </td>
		<td>${mdto.mphoto} </td>
		<td>${mdto.memail} </td>
		</tr>
</table>
</body>
</html>