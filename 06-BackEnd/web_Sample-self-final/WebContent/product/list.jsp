<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>상품 정보 목록</h2>
	  <table>
	  	<tr>
	  		<th>code</th>
	  		<th>model</th>
	  		<th>price</th>
	  	</tr>
		<c:forEach var="p" items="${products}">
	  	<tr>
	  		<td><a href="${root}/product?action=detail&code=${p.code}">${p.code}</a></td>
	  		<td>${p.model}</td>
	  		<td>${p.price}</td>
	  	</tr>
	  	</c:forEach>
	  </table>
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>















