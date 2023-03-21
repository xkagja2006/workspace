<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String userpwd = request.getParameter("userpwd");
	String[] fruit = request.getParameterValues("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=username%>
	님의 비번은
	<%
		out.print(userpwd);
	%>이고 좋아하는 과일은
	<%
		out.print(fruit);
	%>
	입니다.
</body>
</html>