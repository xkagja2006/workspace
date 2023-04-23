<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>index</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<hr>
	<c:if test="${empty userInfo}">
		<form method="post" action="${root}/user/login">
			<input type="text" name="id"/> <input type="password"
				name="password" />
			<button>로그인</button>
		</form>
	</c:if>
</body>
</html>
