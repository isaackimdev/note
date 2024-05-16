function signUp() {
	var form = document.signupForm;
	if(form.name.value == "") {
		alert("이름 확인");
		form.name.focus();
	} else if (form.id.value == "") {
		alert("id 확인");
		form.id.focus();
	} else if (form.pwd.value == "") {
		alert("password를 입력하세요.");
		form.pwd.focus();
	} else if (form.pwd.value != form.pwd2.value) {
		alert("비밀번호가 일치하지 않습니다.");
	} else {
		form.submit();
	}
}

function login() {
	console.log("login");
	var form = document.loginForm;
	if(form.id.value == "") {
		alert("id check");
		form.id.focus();
	} else if (form.pwd.value == "") {
		alert("pw check");
		form.pwd.focus();
	} else {
		form.submit();
	}
	
}


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

