<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>detail</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<hr>
	<form method="post" action="write">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input type="text" name="writer" readonly
					value="${userInfo.id}" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button>등록</button>
				</td>
			</tr>
			<a href="list">목록</a>
		</table>
	</form>
</body>
</html>
