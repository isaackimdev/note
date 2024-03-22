<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>
	<img alt="" src="../image/lion.jpg" width="50" height="50">
	Spring을 이용한 미니 프로젝트
</h1>

<c:if test="${memId != null }">
	<a href="/springBoard2_1/board/boardWriteForm.do">글쓰기</a>&emsp;
</c:if>
	<a href="/springBoard2_1/board/boardList.do?pg=1">목록</a><br>&emsp;
