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
	<th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
	
		<c:forEach var="blist" items="${blistrange}">
	<tr>
		<td>${blist.bnumber}</td> 
		<td><a href="boardview?bnum=${blist.bnumber}">${blist.btitle}</a></td>
		<td>${blist.bwriter} </td>
		<td>${blist.bdate} </td>
		<td>${blist.bhits} </td>
		</tr>
		</c:forEach>
</table>
<button onclick="location.href='boardlistall'">메인</button>
</body>
</html>