<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>index</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<hr>
	<form action="multi-delete">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
			</tr>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.no}</td>
					<td><a href="detail?no=${board.no}">${board.title}</a></td>
					<td>${board.name}</td>
					<td><input type="checkbox" name="no" value="${board.no}" /></td>
				</tr>
			</c:forEach>
		</table>
		<button>삭제</button>
	</form>
	<c:if test="${not empty userInfo}">
		<a href="write">글쓰기</a>
	</c:if>
</body>
</html>
