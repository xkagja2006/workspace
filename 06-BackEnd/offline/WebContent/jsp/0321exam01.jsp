<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 브라우저에서 주석 처리되어 화면에 표시되지 않는다. -->
	<h2> 주석테스트</h2>
	<%
		// 자바 주석문은 .jsp -> .java 변경될때까지 포함되고 
		// .java -> .class 로 변경될때 포함되지 않아서 사용자 응답에는 내용이 없습니다.
	%>
	<%-- JSP를 서블렛으로 변환하는 과정에서 사라짐 --%>
</body>
</html>