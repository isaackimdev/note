<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<img src="../image/tumi.png" width="30" height="30"
	onclick="location.href='../main/index.do'"
	style="cursor: pointer;">
${memId}님이 로그인	
<br><br>
<input type="button" value="로그아웃" onclick="location.href='logout.do'">
</body>
</html>















