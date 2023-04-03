<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">

		<h2>상품 목록</h2>
		<table>
			<tr>
				<th>코드</th>
				<th>모델명</th>
				<th>가격</th>
			</tr>
			<c:forEach var="p" items="${products}">
				<tr>
					<td>${p.code}</td>
					<td>${p.model}</td>
					<td>${p.price}</td>
				</tr>
			</c:forEach>
		</table>



	</div>
	<%-- --%>
	<%@ include file="/include/footer.jsp"%>