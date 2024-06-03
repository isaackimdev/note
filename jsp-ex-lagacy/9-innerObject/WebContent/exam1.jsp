<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학번, 이름 , 학년, 선택과목을 입력하는 폼</h1>
	<form action="exam1Pro.jsp" method="post" enctype="application/x-www-form-urlencoded">
	학번 : <input type="text" name="hak_num"><br>
	이름 : <input type="text" name="name"><br>
	학년 : <input type="radio" name="hak" value="1">1학년&nbsp;
		<input type="radio" name="hak" value="2">2학년&nbsp;
		<input type="radio" name="hak" value="3">3학년&nbsp;
		<input type="radio" name="hak" value="4">4학년<br>
	선택과목 : <select name="subject">
		<option value="java">Java</option>
		<option value="css">CSS</option>
		<option value="jsp">JSP</option>
	</select><br>
	<input type="submit" value="입력 완료 ">
	</form>
	
	
</body>
</html>