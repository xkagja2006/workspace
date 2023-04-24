<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="include/head.jsp"%>
</head>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: gray;
}

th, td {
	border: 1px dotted black;
	text-align: center;
}

#selectedDel {
	text-align: right;
}
</style>
<body>
	<%@ include file="include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<h1 id="head">출결 관리 - 리스트</h1>
		<form method="get" action="">
			<table>
				<tr>
					<th>이슈번호</th>
					<th>아이디</th>
					<th>날짜</th>
					<th>사유</th>
					<th>삭제</th>
				</tr>
				<c:forEach var="p" items="${attendances}">
					<tr>
						<td><a href="/board/product/detail?ano=${p.ano}">${p.ano}</a></td>
						<td>${p.userid}</td>
						<td>${p.issuedate}</td>
						<td>${p.issue}</td>
						<td><input type="checkbox" name="check"></td>
					</tr>
				</c:forEach>
			</table>
			</form>
			<input type="submit" value="선택항목삭제">
	</div>

	<%@ include file="include/footer.jsp"%>