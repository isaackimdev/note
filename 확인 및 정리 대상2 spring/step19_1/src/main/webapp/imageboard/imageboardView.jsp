<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>

<table border="1">
	<tr>
		<td rowspan="5" width="150">
			<img src="../storage/${imageboardDTO.image1 }" width="150" height="150" >
		</td>
		<td width="100">상품명</td>
		<td width="100">${imageboardDTO.imageName }</td>
	</tr>
	
	<tr>
		<td width="100">번호</td>
		<td width="100"> ${imageboardDTO.seq }</td>
	</tr>
	<tr>
		<td width="100">상품코드</td>
		<td>${imageboardDTO.imageId }</td>
	</tr>
	<tr>
		<td width="100">단가</td>
		<td>${imageboardDTO.imagePrice }</td>
	</tr>
	<tr>
		<td width="100">개수</td>
		<td>${imageboardDTO.imageQty}</td>
	</tr>
	<tr>
		<td colspan="3" height="150" valign="top">
			<pre>${imageboardDTO.imageContent }</pre>
		</td>
	</tr>
	
	<tr>
		<td colspan="3" align="center">
			<input type="button" value="목록" onclick="location.href='imageboardList?pg=${pg}'">
			<input type="button" value="수정" onclick="">
			<input type="button" value="삭제"
				onclick="location.href='imageboardDelete?pg=${pg}&seq=${imageboardDTO.seq}'">
		</td>
	</tr>
</table>

<br><hr><br>
	
<table border="1">	
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