<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 상세보기</title>
<style type="text/css">
#articleForm {
	border:1px solid red;
	width:500px;
	height:100%;
	margin:auto;
}
#header{height:25%; text-align:center;}
#section { height:70%; text-align:center; overflow: auto;}
#foot{text-align: center; margin:auto; clear:both;}
</style>
</head>
<body>
<div id="articleForm">
	<div id="header">
		<h2>글 내용 상세 보기</h2>
		제목 : ${boardBean.board_subject } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		첨부파일 : <a href="#">${boardBean.board_file }</a>
	</div>
	
	<div id="section">
		<pre>${boardBean.board_content }</pre>
	</div>
	
	<div id="footer">
	</div>
</div>

<div id="foot">
	<a href="boardReplyForm.do?page=${page }&board_num=${boardBean.board_num}">[답변]</a>
	<a href="boardModifyForm.do?page=${page }&board_num=${boardBean.board_num}">[수정]</a>
	<a href="boardDeleteForm.do?page=${page }&board_num=${boardBean.board_num}">[삭제]</a>
	<a href="boardList.do?page=${page }">[목록]</a>
</div>

</body>
</html>