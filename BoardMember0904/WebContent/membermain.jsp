<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardwrite(){
		location.href="boardwrite.jsp";
	}
	function boarddelete(bnum){
		location.href="boarddelete?bnumber="+bnum;
	}
	function boardupdate(bnum){
		location.href="boardupdate?bnumber="+bnum;
	}
	function boardsearch(){
		boardsearchform.submit();
	}
	
	
</script>
<script language="javascript">
	function popup(mid){
		var url="memberviewpopup?mid="+mid;
		var name="popup";
		window.open(url,name,"width=400,height=500");
	}
</script>
</head>
<body>
<a href="boardlist">마이 페이지</a>
<table border=1>
	<tr>
	<th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
	
		<c:forEach var="blist" items="${blistall}">
	<tr>
		<td>${blist.bnumber}</td> 
		<td><a href="boardview?bnumber=${blist.bnumber}">${blist.btitle}</a></td>
		<td><a href="#" onclick="popup('${blist.bwriter}')">${blist.bwriter}</a> </td>
		<td>${blist.bdate} </td>
		<td>${blist.bhits} </td>
		<td><button onclick="location.href='boardfile?bnumber='${blist.bnumber}">파일다운로드</button></td>
		<c:if test="${sessionScope.loginid eq 'admin'}">
		<td><button onclick="location.href='boarddelete?bnumber='+${blist.bnumber}">글 삭제</button></td>
		</c:if>
		</tr>
		</c:forEach>
</table>

	<button onclick="boardwrite()">글쓰기</button>
	<button onclick="location.href='boardlistpaging'">페이징 목록</button>
	<button onclick="location.href='boardrange'">글 조회순 정렬</button><br>
	
	<form action="boardsearch" method="get" name="boardsearchform">
	<input type="text" name="bsearch">
	</form>
	<button onclick="boardsearch()">검색(제목,작성자)</button><br>
	
	<button onclick="location.href='memberlogout'">로그아웃</button><br>
	
	
	<c:if test="${sessionScope.loginid eq 'admin'}">
	<button onclick="location.href='memberlistall'">회원 목록 조회</button>
	</c:if>
</body>
</html>