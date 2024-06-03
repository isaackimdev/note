<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	height: 100%;
}
#header {
	width: 100%;
	height: 10%; 
	text-align: center;
	border: 1px solid black;
}
#container {	
	width: 100%;
	height: 500px;
}
#nav {
	width: 20%;
	height: 100%;
	float: left;
	background: orange;
}
#section {
	width: 80%;
	height: 100%;
	float: left;
}
#footer {
	width: 100%;
	height: 10%;
	clear: both;
	text-align: center;
	border: 1px solid black;
}
#main:link {color: black; text-decoration: none;}
#main:visited {color: black; text-decoration: none;}
#main:acheve {color: black; text-decoration: none;}
#main:hover {color: green; text-decoration: underline;}
</style>
</head>
<body>
<div id="header">
	<h1>이미지 게시판</h1>
</div>

<div id="container">
	<div id="nav">
		<h2><a href="http://localhost:8080/17-imageboard/main/index.jsp" id="main">메인 화면</a></h2><br>
<!-- 로그인 전 -->
<c:if test="${sessionScope.memId == null}"> 
		<a href="/17-imageboard/main/index.jsp?req=writeForm">회원가입</a><br>
		<a href="/17-imageboard/main/index.jsp?req=loginForm">로그인</a><br>		
</c:if>		
<!-- 로그인 후 -->
<c:if test="${sessionScope.memId != null}">
		<a href="/17-imageboard/main/index.jsp?req=logout">로그아웃</a><br>
		<a href="/17-imageboard/member/modifyFormReady.jsp">회원정보수정</a><br>
		<a href="#">글쓰기</a><br>
		<a href="/17-imageboard/main/index.jsp?req=imageboardWriteForm">이미지등록</a><br>	
		<a href="#">목록</a><br>
		<a href="/17-imageboard/imageboard/imageboardList.jsp?pg=1">이미지목록</a><br>
</c:if>		
	</div>
	
	<div id="section">
		<c:if test="${param.req == null }">
			<jsp:include page="body.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='imageboardWriteForm' }">
			<jsp:include page="../imageboard/imageboardWriteForm.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='imageboardWriteResult' }">
			<jsp:include page="../imageboard/imageboardWriteResult.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='imageboardListResult' }">
			<jsp:include page="../imageboard/imageboardListResult.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='imageboardViewResult' }">			
			<jsp:include page="../imageboard/imageboardViewResult.jsp"/>			
		</c:if>
		
		<c:if test="${param.req =='imageboardDeleteResult' }">			
			<jsp:include page="../imageboard/imageboardDeleteResult.jsp"/>			
		</c:if>
		
		<c:if test="${param.req =='imageboardModifyForm' }">			
			<jsp:include page="../imageboard/imageboardModifyForm.jsp"/>			
		</c:if>
		
		<c:if test="${param.req =='imageboardModifyResult' }">			
			<jsp:include page="../imageboard/imageboardModifyResult.jsp"/>			
		</c:if>
		<!-- 회원 가입창 -->
		<c:if test="${param.req =='writeForm' }">			
			<jsp:include page="../member/writeForm.jsp"/>			
		</c:if>
		<!-- 회원 가입 결과 -->
		<c:if test="${param.req =='writeResult' }">			
			<jsp:include page="../member/writeResult.jsp"/>			
		</c:if>
		<!-- 로그인 폼 -->
		<c:if test="${param.req =='loginForm' }">			
			<jsp:include page="../member/loginForm.jsp"/>			
		</c:if>
		<!-- 로그인 OK -->
		<c:if test="${param.req =='loginOk' }">			
			<jsp:include page="../member/loginOk.jsp"/>			
		</c:if>
		<!-- 로그인 Fail -->
		<c:if test="${param.req =='loginFail' }">			
			<jsp:include page="../member/loginFail.jsp"/>			
		</c:if>
		<!-- 로그아웃 -->
		<c:if test="${param.req =='logout' }">			
			<jsp:include page="../member/logout.jsp"/>			
		</c:if>
		<!-- 회원정보 수정 -->
		<c:if test="${param.req =='modifyForm' }">			
			<jsp:include page="../member/modifyForm.jsp"/>			
		</c:if>
		<!-- 회원정보 수정 결과 표시 -->
		<c:if test="${param.req =='modifyResult' }">			
			<jsp:include page="../member/modifyResult.jsp"/>			
		</c:if>
	</div>
</div>

<div id="footer">
	<p>KGITBANK</p>
</div>
</body>
</html>








