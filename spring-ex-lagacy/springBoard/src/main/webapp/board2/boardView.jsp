<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
</head>
<body>
<table border="1" cellpadding="5">
	<tr>	
		<td colspan="3">
			<font size="5">${boardDTO.subject}</font>
		</td>
	</tr>
	<tr align="center">	
		<td width="150">글번호 : ${boardDTO.seq}</td>
		<td width="150">작성자 : ${boardDTO.name}</td>
		<td width="150">조회수 : ${boardDTO.hit}</td>
	</tr>
	<tr>	
		<td colspan="3" height="200" valign="top">
			<pre>${boardDTO.content}</pre>
		</td>
	</tr>
</table>
<input type="button" value="목록" onclick="location.href='boardList.do?pg=${pg}'">

<c:if test="${memId == boardDTO.id}">
	<input type="button" value="글수정" 
		onclick="location.href='boardModifyForm.do?seq=${seq}&pg=${pg}'">
	<input type="button" value="글삭제" onclick="location.href='boardDelete.do?seq=${seq }'">
</c:if>


</body>
</html>











