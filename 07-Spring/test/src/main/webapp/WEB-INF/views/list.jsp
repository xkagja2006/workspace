<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="include/head.jsp"%>
</head>
<body>
	<%@ include file="include/nav.jsp"%>
	<table>
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>상품가격</th>
		</tr>
		<%-- 페이지만의 내용 --%>
		<c:forEach var="data" items="${list}">
			<tr>
				<td>${data.code}</td>
				<td>${data.model}</td>
				<td>${data.price}</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="include/footer.jsp"%>