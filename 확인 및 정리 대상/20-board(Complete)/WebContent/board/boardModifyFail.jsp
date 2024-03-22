<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${err_no == 1}) {
		alert("수정 실패");
	} else if(${err_no == 2}) {
		alert("수정할 권한이 없습니다.");
	}
	location.href="boardDetail.do?board_num=${board_num}&page=${page}";
</script>
</head>
<body>

</body>
</html>




