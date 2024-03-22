<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화</title>
</head>
<body>
	<h1>이름과 전화번호를 입력하세요</h1>
	
	<form action="exam6Pro.jsp" method="post">
	이름 : <input type="text" name="name">	<br>
	전화번호 :	<select name="areaNum">
			<option value="031">경기</option>
			<option value="02">서울</option>		
		</select>
		-<input type="text" name="tel">	<br>
		<input type="submit" value="제출">
		<input type="reset" value="다시 작성">
	</form>
</body>
</html>