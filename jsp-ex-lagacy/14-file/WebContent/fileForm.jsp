<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 실제 저장 폴더 찾기 
	String realFolder = request.getServletContext().getRealPath("/storage");
	System.out.println("realFolder =" + realFolder);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일</title>
</head>
<body>
<!-- 파일을 전송할때는 반드시 post 방식, 문자열은 2kb를 보내는 get방식 -->
<!-- 넘어온 데이터를 어떻게 끄집어내는지가 핵심 -->
<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">	
	<table border="1">
		<tr>
			<th width="50">제목</th>
			<td><input type="text" name="subject" size="50"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="15" cols="45"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="file" name="upload1" size="50">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="file" name="upload2" size="50">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="파일업로드">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>

</body>
</html>