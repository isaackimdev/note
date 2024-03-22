<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${su} > 0) {
		alert("삭제성공");
	} else {
		alert("삭제실패");
	}
	location.href="imageboardList?pg=${pg}";
</script>
</head>
<body>

</body>
</html>