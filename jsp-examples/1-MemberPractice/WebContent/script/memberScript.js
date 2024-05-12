function checkId() {
	// 입력된 아이디 값 체크 하기
	var sId = document.writeForm.id.value;
	
	if(sId =="" ) {
		alert("먼저 아이디를 입력하세요.");
		document.writeForm.id.focus();
	} else {
		window.open("checkId.jsp?id=" + sId, "window_name",
		"width=350, height=100, left=500 top=200, status=no, scrollbars=yes");
	}
}

