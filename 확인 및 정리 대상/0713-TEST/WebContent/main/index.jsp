<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sound Shop#</title>
<style type="text/css">
body{margin:auto; padding:0; width:800px;}
#header{border-bottom:1px solid lightgray; text-align:center;}
#header a {	text-decoration: none; color: black;}
#nav{border-right:1px solid lightgray; float:left; width:20%; height:500px;}
#ad{float:left; width:450px; height: 100px;}
#log{border:1px solid lightgray; height:100px; width:23%; float:left;}
#section{float:left; padding:20px;}
#footer{clear:both; text-align:center; border-top:1px solid lightgray;}
</style>
</head>
<body>

<div id="whole">
<div id="header">
<h2><a href="/0713-TEST/main/index.jsp">Sound Shop#</a></h2>
</div>

<div id="container">
	<div id="nav">
		<br><br><br>
		<c:if test="${memId == null }">
			<a href="/0713-TEST/main/index.jsp?req=writeForm">회원가입</a><br>
			<a href="/0713-TEST/main/index.jsp?req=loginForm">로그인</a><br>
		</c:if>
		<c:if test="${memId != null }">
			<a href="/0713-TEST/main/index.jsp?req=logout">로그아웃</a><br>		
		</c:if>
	</div>
	<div id="ad_log">
		<div id="ad">
			<img src="../image/ad.jpg" width="450px" height="100px">
		</div>
		
		<div id="log">
			<c:if test="${memId != null }">
				<img src="../image/prof.png" width="77" height="77">ID : ${memId }<br>
				<Strong>${memName }</Strong>님 어서오세요.
			</c:if>
		</div>
	</div>	<!-- ad_log -->
	<div id="section">
		<!-- Index 기본화면 -->
		<c:if test="${param.req == null }">
			<h2>Welcome!!</h2>
			<a href="http://www.youtube.com">Youtube</a>
			<a href="http://www.google.co.kr">google</a>
			<a href="http://www.naver.com">naver</a>
			<a href="http://www.daum.net">daum</a>
		</c:if>		
		<!-- 회원가입 Form -->
		<c:if test="${param.req == 'writeForm' }">
			<jsp:include page="../member/writeForm.jsp"/>
		</c:if>
		<!-- 회원가입 Result -->
		<c:if test="${param.req == 'writeResult' }">
			<jsp:include page="../member/writeResult.jsp"/>
		</c:if>
		<!-- Login Form -->
		<c:if test="${param.req == 'loginForm' }">
			<jsp:include page="../member/loginForm.jsp"/>
		</c:if>
		<!-- Login Fail -->
		<c:if test="${param.req == 'loginFail' }">
			<jsp:include page="../member/loginFail.jsp"/>
		</c:if>
		<!-- Login Ok -->
		<c:if test="${param.req == 'loginOk' }">
			<jsp:include page="../member/loginOk.jsp"/>
		</c:if>
		<!-- Logout -->
		<c:if test="${param.req == 'logout' }">
			<jsp:include page="../member/logout.jsp"/>
		</c:if>
	</div>
</div>
<div id="footer">
	<p>제작자 : 김이삭</p>
	<p>광고문의 : isaac7263@naver.com</p>
	
</div>
	
</div> <!-- whole -->
</body>
</html>