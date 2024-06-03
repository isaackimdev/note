<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<script type="text/javascript" 	src="script/memberScript.js?v=1">
</script>
</head>
<body>
<form action="modify.do" name="modifyForm" method="post">
	<table border="1">
		<tr>
			<td width="70" align="center">이름</td>
			<td>
				<input type="text" name="name" value="${memberDTO.name}" placeholder="이름 입력">
			</td>
		</tr>
		<tr>
			<td width="70" align="center">아이디</td>
			<td>
				<input type="text" name="id" value="${memberDTO.id}" >
			</td>
		</tr>
		<tr>
			<td width="70" align="center">비밀번호</td>
			<td><input type="password" name="pwd" value="${memberDTO.pwd}" ></td>
		</tr>
		<tr>
			<td width="70" align="center">재확인</td>
			<td><input type="password" name="repwd" value="${memberDTO.pwd}" ></td>
		</tr>
		<tr>
			<td width="70" align="center">성별</td>
			<td>
			<c:if test="${memberDTO.gender == '0'}">			
				<input type="radio" name="gender" value="0" checked>남
				<input type="radio" name="gender" value="1">여
			</c:if>				
			<c:if test="${memberDTO.gender != '0'}">
				<input type="radio" name="gender" value="0">남
				<input type="radio" name="gender" value="1" checked>여
			</c:if>	
			</td>
		</tr>
		<tr>
			<td width="70" align="center">이메일</td>
			<td>
				<input type="text" name="email1" value="${memberDTO.email1}">@
				<input type="text" name="email2" value="${memberDTO.email2}">
			</td>
		</tr>
		<tr>
			<td width="70" align="center">핸드폰</td>
			<td>
				<input type="text" name="tel1" style="width: 70px;" 
						value="${memberDTO.tel1}">-
				<input type="text" name="tel2" size="10" value="${memberDTO.tel2}">-
				<input type="text" name="tel3" size="10" value="${memberDTO.tel3}">
			</td>
		</tr>
		<tr>
			<td width="70" align="center">주소</td>
			<td>
				<input type="text" name="addr"  value="${memberDTO.addr}">
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
</body>
</html>










