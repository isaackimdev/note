function checkImageboardWrite() {
	if(document.imageboardWriteForm.imageId.value == "") {
		alert("상품코드를 입력하세요.");
		document.imageboardWriteForm.imageId.focus();
	} else if(document.imageboardWriteForm.imageName.value == "") {
		alert("상품명을 입력하세요.");
		document.imageboardWriteForm.imageName.focus();
	} else if(document.imageboardWriteForm.imagePrice.value == "") {
		alert("단가를 입력하세요.");
		document.imageboardWriteForm.imagePrice.focus();
	} else if(document.imageboardWriteForm.imageQty.value == "") {
		alert("개수를 입력하세요.");
		document.imageboardWriteForm.imageQty.focus();
	} else if(document.imageboardWriteForm.imageContent.value == "") {
		alert("내용을 입력하세요.");
		document.imageboardWriteForm.imageContent.focus();
	} else {		
		document.imageboardWriteForm.submit();
	}  
}






