<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구구단</h2>
	<%
		int dan = Integer.parseInt(request.getParameter("dan"));
		for (int j = 1; j < 10; j++) {
			out.write(dan + " x " + j + " = " + dan * j + " <br/>");
		}
	%>
	<div>
		<a href="0321exam05-input.jsp"> 다시 테스트 </a>
	</div>
</body>
</html>