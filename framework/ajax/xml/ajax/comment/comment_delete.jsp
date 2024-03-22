<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String param = request.getParameter("num");
	int num = 0;
	if (param != null) {
		if (!param.equals("")) {
			try {
				num = Integer.parseInt(param);
			} catch (Exception e) {}
		}
	}
	
	// 데이터베이스 연동을 통한 아이디 중복검사 결과를 얻어오는 과정에 대한 가정
	boolean result = false;
	String message = "덧글이 삭제에 실패했습니다.";
	if (num == 4) {
		result = true;
		message = "덧글이 삭제되었습니다.";
	}
%>
<?xml version='1.0' encoding='UTF-8'?>
<comment>
	<result><%=result%></result>
	<message><%=message%></message>
</comment>