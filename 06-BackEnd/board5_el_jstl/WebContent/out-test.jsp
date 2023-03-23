<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="msg" value="<h2>안녕하세요</h2>"/>
	<c:set var="msg" value="request 안녕하세요" scope="request"/>
	<div>${msg }</div>
	<div><c:out value="${msg }"></c:out></div>
<%-- 	<div><c:out value="${requestScope.msg }"></c:out></div> --%>
</body>
</html>