function checkWrite() {
	if(document.writeForm.name.value == "") {
		alert("이름을 입력하세요.");
		document.writeForm.name.focus();
	} else if(document.writeForm.id.value == "") {
		alert("아이디를 입력하세요.");
		document.writeForm.id.focus();
	} else if(document.writeForm.pwd.value == "") {
		alert("비밀번호를 입력하세요.");
		document.writeForm.pwd.focus();
	} else if(document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.")
	} else {
		document.writeForm.submit();
	}
}

function checkModify() {
	if(document.modifyForm.name.value == "") {
		alert("이름을 입력하세요.");
		document.modifyForm.name.focus();
	} else if(document.modifyForm.id.value == "") {
		alert("아이디를 입력하세요.");
		document.modifyForm.id.focus();
	} else if(document.modifyForm.pwd.value == "") {
		alert("비밀번호를 입력하세요.");
		document.modifyForm.pwd.focus();
	} else if(document.modifyForm.pwd.value != document.modifyForm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.")
	} else {
		document.modifyForm.submit();
	}
}

function checkLogin() {
	if(document.loginForm.id.value == "") {
		alert("아이디를 입력하세요.");
		document.loginForm.id.focus();
	} else if(document.loginForm.pwd.value == "") {
		alert("비밀번호를 입력하세요.");
		document.loginForm.pwd.focus();
	} else {
		document.loginForm.submit();
	}
}

function checkId() {
	var sId = document.writeForm.id.value;
	if(sId == "") {
		alert("먼저 아이디를 입력하세요.");
		document.writeForm.id.focus();
	} else {
		window.open("memberCheckId.do?id=" + sId, "", "width=350 height=100 left=500 top=200");
	}
}

















