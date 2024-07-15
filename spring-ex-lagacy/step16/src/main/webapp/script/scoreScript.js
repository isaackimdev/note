function checkScoreWrite() {
	if(document.scoreForm.studNo.value=="") {
		alert("학번을 입력하세요.");
		document.scoreForm.studNo.focus();
	} else 	if(document.scoreForm.name.value=="") {
		alert("이름을 입력하세요.");
		document.scoreForm.name.focus();
	} else { 
		document.scoreForm.submit();
	}
}