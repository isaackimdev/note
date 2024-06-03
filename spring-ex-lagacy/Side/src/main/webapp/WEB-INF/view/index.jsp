<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to lawgic</title>
</head>
<body>

<jsp:include page="/cmm/haeder.jsp"/>


<form action="/result" method="post" enctype="application/x-www-form-urlencoded">
	<table border="1">
		<tr>
			<td><input type="number" name="id"></td>
			<td><input type="date" name="d1"></td>
			<td><input type="date" name="d2"></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="전달하기 result.jsp">
			</td>
		</tr>
	</table>
</form>

afag





</body>
</html>