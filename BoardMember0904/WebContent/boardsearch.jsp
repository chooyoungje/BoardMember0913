<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	function boardlist(){
		location.href="boardlistall";
	}
</script>
</head>
<body>
<table border=1>
	<tr>
	<th>글번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일</th><th>조회수</th><th>첨부파일</th></tr>
	
		<c:forEach var="bs" items="${bsearch}">
	<tr>
		<td>${bs.bnumber}</td> 
		<td><a href="boardview?bnum=${bs.bnumber}">${bs.btitle}</a></td>
		<td>${bs.bcontents} </td>
		<td>${bs.bwriter} </td>
		<td>${bs.bdate} </td>
		<td>${bs.bhits} </td>
		<td>${bs.bfile} </td>
		</tr>
		</c:forEach>
</table>
		<button onclick="boardlist()">글 목록</button>
</body>
</html>