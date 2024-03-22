<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- XML 파일 태그 시작전의 공백문자 제거 --%>
<%@ page trimDirectiveWhitespaces="true" %> 
<%
	String user_id = request.getParameter("user_id");
	
	if (user_id == null) {
		user_id = "";
	}
	
	// 데이터베이스 연동을 통한 아이디 중복검사 결과를 얻어오는 과정에 대한 가정
	boolean result = false;
	if (user_id.equals("jquery")) {
		result = true;
	}
%>
<?xml version='1.0' encoding='UTF-8'?>
<id_check>
	<result><%=result%></result>
</id_check>