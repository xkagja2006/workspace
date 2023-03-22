<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (cookies != null) {
			for (Cookie c : cookies) {
	%>
	<h2>
		쿠키 이름 :
		<%=c.getName()%>
		, 값 :
		<%=c.getValue()%></h2>
	<%
		}
		} else {
	%>
	<h2>쿠키가 없습니다.</h2>
	<%
		}
	%>

</body>
</html>