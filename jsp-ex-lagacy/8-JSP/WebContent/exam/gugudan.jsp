<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1">	

	<%for(int x=1; x<=9; x++)  {		//1~9	%>
	 <tr align="center" >
		<% for (int y=2; y<=9; ++y ) {	//단 %>
			<td style='padding : 5px;'> <%=y%>*<%=x%>= <%=y*x%> </td>
		<%}	%>
	 </tr>
	<%} %>
	
</table>

</body>
</html>