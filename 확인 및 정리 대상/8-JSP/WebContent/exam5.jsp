<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이름과 성적을 입력하세요</h1>
	<form action="exam5Pro.jsp" method="post">
		이름 : <input type="text" name="name"> <br>
		국어 : <input type="text" name="kor"> <br>
		영어 : <input type="text" name="eng"> <br>
		수학 : <input type="text" name="mat"> <br>
		<input type="submit" value="입력 완료"> 
		<input type="reset" value="다시 작성">
	</form>
</body>
</html>