<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>

<table border="1" cellpadding="5">
	<tr>
		<td>번호</td>
		<td>${imageboardDTO.seq }</td>
	</tr>
	<tr>
		<td>상품코드</td>
		<td>${imageboardDTO.imageId }</td>
	</tr>
	<tr>
		<td>상품이름</td>
		<td>${imageboardDTO.imageName }</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>${imageboardDTO.imagePrice }</td>
	</tr>
	<tr>
		<td>개수</td>
		<td>${imageboardDTO.imageQty }</td>
	</tr>
	<tr>
		<td>합계</td>
		<td>${imageboardDTO.imageQty * imageboardDTO.imagePrice }</td>
	</tr>
	<tr>
		<td colspan="2">
			<img width="100" height="100" src="../storage/${imageboardDTO.image1 }">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<pre>${imageboardDTO.imageContent }</pre>
		</td>
	</tr>
</table>


</body>
</html>