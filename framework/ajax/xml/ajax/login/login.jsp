<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String user_id = request.getParameter("user_id");
	String user_password = request.getParameter("user_password");
	
	if (user_id == null) {
		user_id = "";
	}
	
	if (user_password == null) {
		user_password = "";
	}
	
	// 아이디: jquery, 비밀번호: 123qwe 로 설정된 경우 로그인 허용이라고 가정
	// 결과를 얻어내기 위해서 JSP의 DB연동 처리가 필요합니다.
	boolean result = true;
	String message = "안녕하세요. " + user_id + "님!!!";
	
	if (result) {
		if (!user_id.equals("jquery")) {
			result = false;
			message = "가입되지 않은 아이디 입니다.";
		}
	}
	
	if (result) {
		if (!user_password.equals("123qwe")) {
			result = false;
			message = "비밀번호가 잘못되었습니다.";
		}
	}
	
	if (result) {
		// 로그인이 성공되었다면, 세션처리를 수행할 수 있습니다.
	}
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%=result%></result>
	<message><%=message%></message>
</login>