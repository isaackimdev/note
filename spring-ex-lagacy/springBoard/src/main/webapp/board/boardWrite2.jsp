<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<c:if test="${su > 0 }">
	<p>작성하신 글을 저장하였습니다.</p>
</c:if>
<c:if test="${su == 0 }">
	<p>작성하신 글을 저장하지 못했습니다.</p>
</c:if>
<a href="../main/index">메인화면</a>
<a href="boardList?pg=1">목록</a>
</body>
</html>









