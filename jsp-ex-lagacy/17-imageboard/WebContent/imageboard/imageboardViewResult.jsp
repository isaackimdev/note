<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td rowspan="4" width="150">
			<img src="../storage/${imageboardDTO.image1 }" width="150" height="150">
		</td>
		<td width="200"><p>상품명 : ${imageboardDTO.imageName}</p></td>
	</tr>
	<tr>
		<td width="200"><p>단가 : ${imageboardDTO.imagePrice}</p></td>
	</tr>
	<tr>
		<td width="200"><p>개수 : ${imageboardDTO.imageQty}</p></td>
	</tr>
	<tr>
		<td width="200"><p>합계 : ${imageboardDTO.imagePrice * imageboardDTO.imageQty}</p></td>
	</tr>	
	<tr>
		<td colspan="2" height="200" valign="top">
			<pre>${imageboardDTO.imageContent }</pre>
		</td>
	</tr>
</table>
<input type="button" value="목록" onclick="location.href='imageboardList.jsp?pg=${pg}'">
<input type="button" value="수정" 
	onclick="location.href='imageboardModifyFormReady.jsp?seq=${seq}&pg=${pg}'">
<input type="button" value="삭제" onclick="location.href='imageboardDelete.jsp?seq=${seq}'">
</body>
</html>













