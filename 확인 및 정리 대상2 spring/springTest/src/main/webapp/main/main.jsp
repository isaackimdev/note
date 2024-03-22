<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>※방명록을 남겨주세요</title>
<script type="text/javascript" src="../script/guestbookScript.js"></script>
<style type="text/css">
* {padding: 0; margin: 0;}

#header {
	text-align: center;
	height: 20%;
	width: 100%;
	border-bottom: 1px solid gray;
	border-left: 10px solid gray;
	padding: 20px 20px;
}
#nav {
	height: 500px;
	width: 100px;
	border-right: 1px solid gray;
	float: left;
	margin-left: 20px;
}
#section {
	float: left;
}

#footer {
	border-top:1px solid gray;
	height:10%;
	clear: both;
	text-align: center;
	vertical-align: middle;
	padding-top: 20px;
}
.bm{text-decoration: none;}
.bm:active {color: black;}
.bm:focus {color:black;}
.bm:visited {color: black;}
.bm:hover {color:blue;}


</style>
</head>
<body>

<div id="wrap">
	<div id="header">
		<h1><a class="bm" href="/springTest/main/main.jsp">방명록</a></h1>
	</div> <!-- header -->
	
	<div id="container">	
		<div id="nav"><br><br><br>
			<a href="../guestbook/guestbookWriteForm">글쓰기</a><br>
			<a href="../guestbook/guestbookList">글목록</a><br>
		</div> <!-- nav -->
		
		<div id="section">
			<c:if test="${param.req== null }">	
				<h2>메인화면</h2><br>
			</c:if>
			
			<c:if test="${param.req == 'guestWriteForm' }">
				<jsp:include page="../guestbook/guestbookWriteForm.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'guestbookWrite' }">
				<jsp:include page="../guestbook/guestbookWrite.jsp"/>
			</c:if>
			
			
		</div> <!-- section -->
	</div>
	
	<div id="footer">
		<h3>제작자 : 김이삭</h3>
	</div> <!-- footer -->
</div> <!-- wrap -->

</body>
</html>