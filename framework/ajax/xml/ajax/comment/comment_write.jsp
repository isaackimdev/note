<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	request.setCharacterEncoding("UTF-8");
	String user_name = request.getParameter("user_name");
	String comment = request.getParameter("comment");
	
	user_name = new String(user_name.getBytes(), "UTF-8");
	comment = new String(comment.getBytes(), "UTF-8");
	
	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	String datetime = simpleDate.format(date);
	// DB 처리
	int num = 4;
	boolean result = true;
	String message = "덧글이 등록되었습니다.";	
%>
<?xml version='1.0' encoding='UTF-8'?>
<comment>
	<result><%=result%></result>
	<message><%=message%></message>
	<item>
		<num><%=num%></num>
		<writer><![CDATA[<%=user_name%>]]></writer>
		<content><![CDATA[<%=comment%>]]></content>
		<datetime><![CDATA[<%=datetime%>]]></datetime>
	</item>
</comment>