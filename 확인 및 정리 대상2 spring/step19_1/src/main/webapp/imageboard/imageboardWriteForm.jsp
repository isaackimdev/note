<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 등록</title>
<script type="text/javascript">
function imageboardCheck() {
	if(document.imageboardWriteForm.imageId.value=="") {
		alert("상품코드를 입력해주세요.");
		document.imageboardWriteForm.imageId.focus();
	} else if(document.imageboardWriteForm.imageName.value=="") {
		alert("상품명을 입력해주세요.");
		document.imageboardWriteForm.imageName.focus();
	} else if(document.imageboardWriteForm.imagePrice.value=="") {
		alert("단가를 입력해주세요.");
		document.imageboardWriteForm.imagePrice.focus();
	} else if(document.imageboardWriteForm.imageQty.value=="") {
		alert("상품 개수를 입력해주세요.");
		document.imageboardWriteForm.imageQty.focus();
	} else if(document.imageboardWriteForm.imageContent.value=="") {
		alert("내용을 입력해주세요.");
		document.imageboardWriteForm.imageContent.focus();
	} else if(document.imageboardWriteForm.image.value=="") {
		alert("파일을 등록해주세요.");
	} else {
		document.imageboardWriteForm.submit();
	}
}
</script>
</head>
<body>

<h3>이미지 등록</h3>

<form action="imageboardWrite" method="post" name="imageboardWriteForm"
	enctype="multipart/form-data">
<table border="1" cellpadding="3">
	<tr>
		<td width="70">상품 코드</td>
		<td width="230">
			<input type="text" name="imageId" value="img_" id="imageId" size="45">
		</td>
	</tr>
	<tr>
		<td>상품명</td>
		<td>
			<input type="text" name="imageName" id="imageName" size="50">
		</td>
	</tr>
	<tr>
		<td>단가</td>
		<td>
			<input type="text" name="imagePrice" id="imagePrice">
		</td>
	</tr>
	<tr>
		<td>개수</td>
		<td>
			<input type="text" name="imageQty" id="imageQty">
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea rows="15" cols="45" name="imageContent" id="imageContent"></textarea>
		</td>
	</tr>
	<tr> <!-- name="image" 는 ImageboardDTO의 image1과 똑같은 이름을 쓰면 안된다. 에러발생 // 이유는 모르겠음.. 두번째 제약조건 -->
		<td colspan="2">	<!-- MultipartFile 클래스 변수와 name 을 통일시켜야 한다. -->
			<input type="file" size="50" name="image" id="image">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="이미지 등록">
			<input type="reset" value="다시작성">
		</td>
	</tr>
</table>
</form>
<a href="imageboardList?pg=1">목록</a>
<!-- 
<input type="button" value="이미지 등록" onclick="ageboardCheck()">
 -->
 
</body>
</html>