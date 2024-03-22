<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>◈ MVC 성적관리 ◈</title>
<style type="text/css">
body {
	margin:0;
	padding:0;
	width:auto;
}
#header{
	border-bottom: 1px solid lightgray;
	text-align: center;
}
#wrap {
	height:600px ;
}
#nav {
	border-right: 1px solid lightgray;
	float: left;
	width:20%;
	height:100%;
	background-color:lightgray;
}
#section {
	float: left;
	width: 79%;
	height:100%;
}

#footer {
	clear:both;
	border-top: 1px solid lightgray;
	text-align: center;
}
.black:link {text-decoration: none; color:black;}
.black:active {text-decoration: none; color:black;}
.black:hover {text-decoration: none; color:black;}
.black:visited {text-decoration: none; color:black;}

</style>
</head>
<body>

<div id="header">
	<h2><a href="index.jsp" class="black">MVC TEST 성적관리</a></h2>
</div> <!-- header -->

<div id="wrap">
	<div id="nav">
		▶<a href="scoreWriteForm.do" class="black">성적입력</a><br>
		▶<a href="scoreList.do" class="black">성적목록</a><br>
	</div>
	
	<div id="section">
		<c:if test="${req_page != null}">
			<jsp:include page="${req_page }"/>
		</c:if>
	</div>
</div> <!-- wrap -->

<div id="footer">
	<h3>제작자 : 김이삭</h3>
	<p>isaac7263@naver.com</p>
</div>

</body>
</html>