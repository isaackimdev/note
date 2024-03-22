<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 수정 관리 화면</title>
<script type="text/javascript">
function modifyChk() {
	if(document.scoreModifyForm.kor.value=="") {
		alert("수정할 국어 점수를 입력하세요.");
		document.scoreModifyForm.kor.focus();
	} else if(document.scoreModifyForm.eng.value=="") {
		alert("수정할 영어 점수를 입력하세요.");
		document.scoreModifyForm.eng.focus();
	} else if(document.scoreModifyForm.mat.value=="") {
		alert("수정할 수학 점수를 입력하세요.");
		document.scoreModifyForm.mat.focus();
	} else {
		document.scoreModifyForm.submit();
	}
}
</script>
<style type="text/css">
tr {
	background: #ffffcc;
}
#tr_top {
	background: orange;
	text-align: center;
}
</style>
</head>
<body>

<!-- studNo에 vo.studNo 를 써서 전달해도 됨. -->
<form action="scoreModify.do?studNo=${studNo }" method="post" name="scoreModifyForm">	
<table border="1" cellpadding="5">
	<tr id="tr_top">
		<td colspan="6">
			<font size="4">${vo.name}</font>
		</td>
	</tr>
	<tr align="center">
		<td width="100">학번</td>
		<td width="100">국어</td>
		<td width="100">영어</td>
		<td width="100">수학</td>
		<td width="100">총점</td>
		<td width="100">평균</td>
	</tr>
	<tr align="center">
		<td width="100">${vo.studNo}</td>
		<td width="100"><input type="text" size="5" name="kor" value="${vo.kor }"></td>
		<td width="100"><input type="text" size="5" name="eng" value="${vo.eng }"></td>
		<td width="100"><input type="text" size="5" name="mat" value="${vo.mat }"></td>
		<td width="100">${vo.tot}</td>
		<td width="100">${vo.avg}</td>
	</tr>
</table>
</form>

<input type="button" value="뒤로가기" onclick="history.back()">
<input type="button" value="수정하기" onclick="modifyChk()">

</body>
</html>