<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 수정</title>
<script type="text/javascript" src="../script/imageboardScript.js"></script>
</head>
<body>
<h3>이미지 수정</h3>
<form name="imageboardWriteForm" action="imageboardModify.jsp" 
		method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="${seq }">
	<input type="hidden" name="pg" value="${pg }">
	
	<table border="1">
		<tr>
			<th width="100">상품코드</th>
			<td><input type="text" name="imageId" value="${imageboardDTO.imageId}" size="30"></td>
		</tr>
		<tr>
			<th width="100">상품명</th>
			<td><input type="text" name="imageName" value="${imageboardDTO.imageName}"></td>
		</tr>
		<tr>
			<th width="100">단가</th>
			<td><input type="text" name="imagePrice" value="${imageboardDTO.imagePrice}"></td>
		</tr>
		<tr>
			<th width="100">개수</th>
			<td><input type="text" name="imageQty" value="${imageboardDTO.imageQty}"></td>
		</tr>
		<tr>
			<th width="100">내용</th>
			<td><textarea name="imageContent" rows="10" cols="30">${imageboardDTO.imageContent}</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="file" name="image1" size="40" value="${imageboardDTO.image1}">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="이미지수정" onclick="checkImageboardWrite()">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>









