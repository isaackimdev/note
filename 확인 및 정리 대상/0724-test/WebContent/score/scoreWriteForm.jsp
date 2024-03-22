<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력 화면</title>
<style type="text/css">
.td_left {
	text-align: right;
	background-color : lightgray;
	width: 5em;
	color: black;
	font-weight: bold;
}
#scoreWriteForm {
	margin-top: 15px;
	margin-left:15px;
}
</style>
<script type="text/javascript">
function scoreChk() {
	if(document.scoreWriteForm.score_num.value == "") {
		alert("학번을 입력하세요.");
		document.scoreWriteForm.score_num.focus();
	} else if(document.scoreWriteForm.score_name.value == "") {
		alert("이름을 입력하세요.");
		document.scoreWriteForm.score_name.focus();
	} else if(document.scoreWriteForm.score_kor.value == "") {
		alert("국어점수를 입력하세요.");
		document.scoreWriteForm.score_kor.focus();
	} else if(document.scoreWriteForm.score_eng.value == "") {
		alert("영어점수를 입력하세요.");
		document.scoreWriteForm.score_eng.focus();
	} else if(document.scoreWriteForm.score_mat.value == "") {
		alert("수학점수를 입력하세요.");
		document.scoreWriteForm.score_mat.focus();
	} else {
		document.scoreWriteForm.submit();
	}
}
</script>
</head>
<body>

<form action="scoreWrite.do" method="post" name="scoreWriteForm" id="scoreWriteForm">
	<table>
		<tr>
			<td class="td_left"><label for="score_num" style="text-align: right;">학번</label></td>
			<td>
				<input type="text" name="score_num" id="score_num" placeholder="ex)2018001">
			</td>
		</tr>
		
		<tr>
			<td class="td_left"><label for="score_name">이름</label></td>
			<td>
				<input type="text" name="score_name" id="score_name" placeholder="홍길동">
			</td>
		</tr>
		
		<tr>
			<td class="td_left"><label for="score_kor">국어점수</label></td>
			<td>
				<input type="text" name="score_kor" id="score_kor" placeholder="1~100 사이 수 입력">
			</td>
		</tr>
		
		<tr>
			<td class="td_left"><label for="score_eng">영어점수</label></td>
			<td>
				<input type="text" name="score_eng" id="score_eng" placeholder="1~100 사이 수 입력">
			</td>
		</tr>
		
		<tr>
			<td class="td_left"><label for="score_mat">수학점수</label></td>
			<td>
				<input type="text" name="score_mat" id="score_mat" placeholder="1~100 사이 수 입력">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="성적 등록하기" onclick="scoreChk()">
				<input type="reset" value="다시 입력하기">
			</td>
		</tr>
	</table>
</form>

</body>
</html>