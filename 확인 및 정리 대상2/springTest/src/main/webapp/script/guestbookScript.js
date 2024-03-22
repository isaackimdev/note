function guestbookCheck() {
	if(document.guestbookForm.guest_writer.value == "") {
		alert("[ 방문자 ]를 입력해주세요.");
		document.guestbookForm.guest_writer.focus();
	} else if(document.guestbookForm.guest_email.value == "") {
		alert("[ 이메일 ]을 입력해주세요.");
		document.guestbookForm.guest_email.focus();
	} else if(document.guestbookForm.guest_subject.value == "") {
		alert("[ 제목 ]을 입력해주세요.");
		document.guestbookForm.guest_subject.focus();
	} else if(document.guestbookForm.guest_content.value == "") {
		alert("[ 내용 ]을 입력해주세요.");
		document.guestbookForm.guest_content.focus();
	} else {
		document.guestbookForm.submit();
	} 
}