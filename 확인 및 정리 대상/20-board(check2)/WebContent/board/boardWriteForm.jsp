<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
#boardform {
	width: 500px;
	height: 375px;
	border: 1px solid blue;
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
<h2>게시판 글 등록</h2>
<form action="boardWritePro.do" method="post" 
	  enctype="multipart/form-data" name="boardform" id="boardform">
	<table>
		<tr>
			<td class="td_left"><label>글쓴이</label></td>
			<td class="td_right"><input type="text" name="board_name" 
					   id="board_name" required="required"></td>
		</tr>
		<tr>
			<td class="td_left"><label>비밀번호</label></td>
			<td class="td_right"><input type="password" name="board_pass" 
					   id="board_pass" required="required"></td>
		</tr>
		<tr>
			<td class="td_left"><label>제목</label></td>
			<td class="td_right"><input type="text" name="board_subject" 
					   id="board_subject" required="required"></td>
		</tr>
		<tr>
			<td class="td_left"><label>내용</label></td>
			<td class="td_right"><textarea name="board_content" 
					id="board_content" cols="40" rows="15" required="required"></textarea></td>
		</tr>
		<tr>
			<td class="td_left"><label>파일첨부</label></td>
			<td class="td_right"><input type="file" name="board_file" 
					   id="board_file" required="required"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록"> 
				<input type="reset" value="다시쓰기">
			</td>
		</tr>
	</table>

</form>
</body>
</html>













