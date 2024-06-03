<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판 수정하기</title>
<style type="text/css">
#boardform {
	width: 500px;
	height: 400px;
	border: 1px solid lightgray;
	margin: auto
}
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 450px;
}
.td_left {
	width: 150px;
	background: orange;
}
.td_right {
	width: 300px;
	background: skyblue;
}
</style>
</head>
<body>
<h2>게시판 글 수정</h2>		<!-- 선생님 풀이 방식 boardModifyPro.do?page=${page}  -->
<form action="boardModifyPro.do" method="post" 
	  enctype="multipart/form-data" name="boardform" id="boardform"> <!-- 선생님은 name, id를 modify form 으로 지칭 -->
																	<!-- 문자열 전달 방식으로 진행하기에 multipart/form-data를 지움 -->
																	<!-- 파일 수정 항목 자체를 삭제 (선생님 풀이 방식) -->  
	  <input type="hidden" name="board_num" value="${boardBean.board_num }">
	  <!-- input type="hidden" name="board_pass" value="${boardBean.board_pass }">  -->
	  <input type="hidden" name="page" value="${page}">
	
	<table>
		<tr>
			<td class="td_left"><label>글쓴이</label></td>
			<td class="td_right"><input type="text" name="board_name" 
					   id="board_name" required="required" value="${boardBean.board_name }"></td>
		</tr>
		<tr>
			<td class="td_left"><label>비밀번호</label></td>
			<td class="td_right"><input type="password" name="board_pass" 
					   id="board_pass" required="required" value="${boardBean.board_pass }"></td>	<!-- 선생님 풀이 비밀번호 value 값 얻지 않음 -->
		</tr>
		<tr>
			<td class="td_left"><label>제목</label></td>
			<td class="td_right"><input type="text" name="board_subject" 
					   id="board_subject" required="required" value="${boardBean.board_subject }"></td>
		</tr>
		<tr>
			<td class="td_left"><label>내용</label></td>
			<td class="td_right">
				<pre><textarea name="board_content" 
					id="board_content" cols="40" rows="15" required="required">${boardBean.board_content }</textarea></pre>
			</td>
		</tr>
		<tr>
			<td class="td_left"><label>파일첨부</label></td>
			<td class="td_right"><input type="file" name="board_file" 
					   id="board_file" required="required" ></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정"> 
				<input type="button" value="뒤로" onclick="history.go(-1)">
			</td>
		</tr>
	</table>

</form>
</body>
</html>













