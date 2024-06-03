<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Exam 2 </title>
</head>
<body>
<font color="red"><b>
<p>exam2.jsp - send.jsp - sendResult.jsp 페이지 이동합니다.</p>
<p>sendRedirest로 이동하므로 데이터는 공유하지 않습니다.</p>
<p>주소는 send Result.jsp가 보입니다.</p>
</b></font>
<hr>

<font color="blue"><b>
<p>exam2.jsp - forward.jsp - forwardResult.jsp 페이지 이동합니다.</p>
<p>sendRedirest로 이동하므로 데이터는 공유합니다.</p>
<p>주소는 forward.jsp가 보이지만, 결과는 forwardResult.jsp가 보입니다.</p>
</b></font>
<hr>

<input type="button" value="sendRedirect" onclick="location.href='send.jsp'">
<input type="button" value="forward" onclick="location.href='forward.jsp'">

</body>
</html>