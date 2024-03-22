<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
#boardForm {
	width: 500px;
	heigh: 610px;
	border: 1px solid lightgray;
	margin: auto;
}
table { margin: auto; width:450px;}
.col1 { background-color:orange; width:150px;}
.col2 { background-color:skyblue;widtg:300px;}
</style>
</head>
<body>
<h2 align="center">게시판글등록</h2>
<form action="boardWritePro.do" method="post" enctype="multipart/form-data"
	name="boardForm" id="boardForm">
	<table>
		<tr>
			<td class="col1"><label>글쓴이</label></td>
			<td class="col2"><input type="text" name="board_name" 
								id="board_name" required="required"></td>
		</tr>
		<tr>
			<td class="col1"><label>비밀번호</label></td>
			<td class="col2"><input type="password" name="board_pass" 
								id="board_pass" required="required"></td>
		</tr>
		<tr>
			<td class="col1" ><label>제목</label></td>
			<td class="col2"><input type="text" name="board_subject" 
								id="board_subject" required="required"></td>
		</tr>
		<tr>
			<td class="col1"><label>내용</label></td>
			<td class="col2"><textarea name="board_content"
					id="board_content" cols="40" rows="15" required="required"></textarea></td>
		</tr>
		<tr>
			<td class="col1" ><label>파일첨부</label></td>
			<td class="col2"><input type="file" name="board_file" 
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