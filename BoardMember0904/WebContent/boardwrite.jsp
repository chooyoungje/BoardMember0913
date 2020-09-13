<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function boardwrite(){
	writeform.submit();
}
</script>
</head>
<body>
	<form action="boardwrite" method="post" enctype="multipart/form-data" name="writeform">
	작성자 <input type="text" name="btitle" id="btitle" readonly value="${sessionScope.loginid}"><br>
	제목<input type="text" name="btitle" id="btitle"><br>
	내용<textarea cols="30" rows="10" name="bcontents" id="bcontents"></textarea>
	파일첨부<input type="file" name="bfile" id="bfile">
	</form>
	<button onclick="boardwrite()">글작성</button>


</body>
</html>