<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<!--style type="text/css">
#wrap {
	padding:0;
	margin:0;
	border:1px solid gray;
}
#header {
	text-align: center;
	border-bottom: 1px solid gray;
	height:120px;
}
#container {
	padding:0;
	margin: 0;
}
#nav {
	float:left;
	border-right: 1px solid gray;
	width:241px;
	height: 370px;
}
#section{
	float: left; 
}
#footer{
	clear:both;
	border-top : 1px solid gray;
}

</style -->
</head>
<body>
<!-- table 작업 -->
<table border="1" width="100%">
	<tr>
		<td colspan="2" align="center">
			<jsp:include page="../template/top.jsp"/>
		</td>
	</tr>
	<tr>
		<td width="290" height="400" align="center" valign="top">
			<jsp:include page="../template/left.jsp"/>
		</td>
		<td align="center">
		<c:if test="${display == null }">
			<jsp:include page="../template/body.jsp"/>
		</c:if>
		<c:if test="${display != null }">
			<jsp:include page="${display }"/>
		</c:if>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<jsp:include page="../template/bottom.jsp"/>
		</td>
	</tr>
</table>

<!-- table 작업 -->
<br>
<hr>
<br>
<!-- 
<div id="wrap">
	<div id="header">
		<h2>
			<img alt="lion" src="../image/lion.jpg" width="50" height="50">Spring을 이용한 미니프로젝트
		</h2>
		
		<c:if test="${sessionScope.memId != null }">	로그인 후
			<a href="../board/boardWriteForm.do">글쓰기</a>
		</c:if>
			<a href="../board/boardList.do?pg=1">목록</a>
	</div>
	
	<div id="nav">
		<c:if test="${sessionScope.memId == null  }">	로그인 전
			<jsp:include page="../member/loginForm.do"/>	로그인 폼 화면
		</c:if>
		
		<c:if test="${sessionScope.memId != null  }">	로그인 후 화면
			<jsp:include page="../member/loginOk.jsp"/>
			<input type="button" value="정보 수정" onclick="location.href='../member/modifyForm.do'">
		</c:if>
	</div>
	
	<div id="section">
		<c:if test="${param.req == null }">	
			<h2>메인 화면</h2>
		</c:if>
		
		
		<c:if test="${param.req == 'writeForm' }">
			<jsp:include page="../member/writeForm.jsp"/>
		</c:if>
		

		<c:if test="${param.req == 'modifyForm' }">
			<jsp:include page="../member/modifyForm.jsp"/>
		</c:if>
		
		
		<c:if test="${param.req == 'boardWriteForm' }">
			<jsp:include page="../board/boardWriteForm.jsp"/>
		</c:if>
		
		
		<c:if test="${param.req == 'boardList' }">
			<jsp:include page="../board/boardList.jsp"/>
		</c:if>
		
		
		<c:if test="${param.req == 'boardView' }">
			<jsp:include page="../board/boardView.jsp"/>
		</c:if>
		
	
		<c:if test="${param.req == 'boardModifyForm' }">
			<jsp:include page="../board/boardModifyForm.jsp"/>
		</c:if>
		
	</div>	
	
	<div id="footer">
		<h3>KGITBANK</h3>
	</div> 
</div>
 -->
</body>
</html>










