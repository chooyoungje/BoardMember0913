<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<tr>
		
		<td>${bview.bnumber}</td> 
		<td>${bview.btitle} </td>
		<td>${bview.bcontents} </td>
		<td>${bview.bwriter} </td>
		<td>${bview.bdate} </td>
		<td>${bview.bhits} </td>
		<td>${bview.bfile} </td>
		</tr>
</table>
		<button onclick="boardlist()">글 목록</button>

</body>
</html>