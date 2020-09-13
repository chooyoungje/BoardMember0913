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
${sessionScope.loginid}님이 작성한 글 갯수 : ${bcount}개
<table border=1>
	<tr>
	<th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th><th>글수정</th><th>글삭제</th></tr>
	
		<c:forEach var="blist" items="${blist}">
	<tr>
		<td>${blist.bnumber}</td> 
		<td><a href="boardview?bnumber=${blist.bnumber}">${blist.btitle}</a></td>
		<td>${blist.bwriter} </td>
		<td>${blist.bdate} </td>
		<td>${blist.bhits} </td>
		<td><button onclick="location.href='boardupdate?bnumber='+${blist.bnumber}">글 수정</button></td>
		<td><button onclick="location.href='boarddelete?bnumber='+${blist.bnumber}">글 삭제</button></td>
		</tr>
		</c:forEach>
</table>
<button onclick="location.href='memberupdate'">회원정보수정</button>
</body>
</html>