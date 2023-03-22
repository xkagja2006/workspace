<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="<%=request.getContextPath()%>/login">
		<div>
			아이디 : <input type="text" name="id">
		</div>
		<div>
			패스워드: <input type="text" name="password">
		</div>
		<div><button>로그인</button></div>
	</form>
</body>
</html>