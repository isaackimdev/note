<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	width:100%;
	height:10%;
	text-align: center;
	border-bottom:1px lightgray solid;
}
#container {
	width: 100%;
	height: 450px;
}
#nav {
	width: 20%;
	height: 100%;
	float:left;
	background:orange;
}
#section {
	width:80%;
	height:100%;
	float:left;
}
#footer {
	width:100%;
	height: 10%;
	clear:both;
	text-align: center;
	border: 1px solid lightgray;
}
#main:link{color:black;text-decoration: none;}
#main:visited{color:black;text-decoration: none;}
#main:active{color:black;text-decoration: none;}
#main:hover{color:green; text-decoration: underline;}
</style>

</head>
<body>

<div id="header">
	<h2><a href="/20-board/index.jsp">게시판</a></h2>
</div>	<!-- header -->

<div id="container">
	<div id="nav">
		<h2><a href="index.jsp" id="main">* 메인 화면 *</a></h2><br><br>
		<a href="boardWriteForm.do">게시판 글쓰기</a><br>
		<a href="boardList.do">게시판 목록</a>
	</div> <!-- nav -->
	
	<div id="section">	
		<!-- 
		
		<c:if test="${param.req_page == null">
			<a href="/20-board/index.jsp"><img alt="" src="image/lion.jpg"></a>
		</c:if>
		
		<c:if test="${param.req_page != null">
			<jsp:include page="${param.req_page}">
		</c:if>
		 -->
		<c:if test="${param.req == null }">
			<a href="/20-board/index.jsp"><img alt="" src="image/lion.jpg"></a>
		</c:if>
		
		<c:if test="${param.req == 'boardWriteForm' }">	
			<jsp:include page="/board/boardWriteForm.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='boardList' }">
			<jsp:include page="/board/boardList.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='boardView' }">
			<jsp:include page="/board/boardView.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='boardReply' }">
			<jsp:include page="/board/boardReply.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='boardModifyFail' }">
			<jsp:include page="/board/boardModifyFail.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='boardModify' }">
			<jsp:include page="/board/boardModify.jsp"/>
		</c:if>
		
		<c:if test="${param.req =='boardDelete' }">
			<jsp:include page="/board/boardDelete.jsp"/>
		</c:if>
		
	</div>	<!-- section -->
</div> <!-- container -->

<div id="footer">
	<h3>isaac</h3>
</div>	<!-- footer -->

</body>
</html>