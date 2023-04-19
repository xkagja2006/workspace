<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>안녕하세요</h3>
		<a href="${root}/hello">hello spring</a>
		<a href="${root}/single">single parameter</a>
		<a href="${root}/multi">multi parameter</a>
	</div>
</body>
</html>