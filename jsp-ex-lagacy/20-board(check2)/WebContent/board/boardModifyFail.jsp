<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정실패</title>
<script type="text/javascript">
alert('수정 실패');
location.href="boardList.do";


/*
 	선생님 풀이
 	
 	if(${err_no == 1}) {
 		alert("수정 실패");
 	} else if (${err_no == 2}) {
 		alert("수정할 권한이 없습니다.");
 	}
 	location.href="boardDetail.do?board_num=${board_num}&page=${page}";
 
 
 
 */

</script>
</head>
<body>

</body>
</html>