<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 쿠키 꺼내기
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(int i=0; i<cookies.length; i++) {
			// 넘어온 데이터가 있으면 계속 출력
			// 필요한 정보를 꺼낼때 정보를 걸러내기 위해 if 사용
			if(cookies[i].getName().equals("id")) {
				out.println("쿠키의 이름은" + cookies[i].getName() + "이고,<br>");
				out.println("쿠키의 값은 " + cookies[i].getValue() + " 입니다." );
			}
			
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 사용</title>
</head>
<body>

</body>
</html>