<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("memId");
	MemberDAO memberDAO = new MemberDAO();
	MemberDTO memberDTO = memberDAO.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<script type="text/javascript" 	src="../script/memberScript.js?v=1">
</script>
</head>
<body>
<form action="modify.jsp" name="modifyForm" method="post">
	<table border="1">
		<tr>
			<td width="70" align="center">이름</td>
			<td>
				<input type="text" name="name" value="<%=memberDTO.getName() %>" placeholder="이름 입력">
			</td>
		</tr>
		<tr>
			<td width="70" align="center">아이디</td>
			<td>
				<input type="text" name="id" value="<%=memberDTO.getId() %>" >
			</td>
		</tr>
		<tr>
			<td width="70" align="center">비밀번호</td>
			<td><input type="password" name="pwd" value="<%=memberDTO.getPwd() %>" ></td>
		</tr>
		<tr>
			<td width="70" align="center">재확인</td>
			<td><input type="password" name="repwd" value="<%=memberDTO.getPwd() %>" ></td>
		</tr>
		<tr>
			<td width="70" align="center">성별</td>
			<td>
			<%	if(memberDTO.getGender().equals("0")) { %>
				<input type="radio" name="gender" value="0" checked>남
				<input type="radio" name="gender" value="1">여
			<%	} else { %>
				<input type="radio" name="gender" value="0">남
				<input type="radio" name="gender" value="1" checked>여
			<%	} %>
			</td>
		</tr>
		<tr>
			<td width="70" align="center">이메일</td>
			<td>
				<input type="text" name="email1" value="<%=memberDTO.getEmail1() %>">@
				<input type="text" name="email2" value="<%=memberDTO.getEmail2() %>">
			</td>
		</tr>
		<tr>
			<td width="70" align="center">핸드폰</td>
			<td>
				<input type="text" name="tel1" style="width: 70px;" 
						value="<%=memberDTO.getTel1() %>">-
				<input type="text" name="tel2" size="10" value="<%=memberDTO.getTel2() %>">-
				<input type="text" name="tel3" size="10" value="<%=memberDTO.getTel3() %>">
			</td>
		</tr>
		<tr>
			<td width="70" align="center">주소</td>
			<td>
				<input type="text" name="addr"  value="<%=memberDTO.getAddr() %>">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="회원정보수정" onclick="checkModify()">
				<input type="reset" value="다시 작성">
			</td>
		</tr>
	</table>	
</form>
<a href="../main/index.jsp">메인 화면</a>
</body>
</html>










