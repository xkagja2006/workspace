<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="include/head.jsp" %>
</head>
<body>
	<%@ include file="include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	<h1 id="head">출결 이슈 - 출결 이슈 등록</h1>
	<form id="registForm" method="post" action="regist">
		<label for="ano" class="inputtitle">이슈 번호</label>
		<input type="text" name="ano" id="ano">
		<br>
		<label for="userid" class="inputtitle">아이디</label>
		<c:if test="${position eq true}">
		<input type="text" name="userid" id="userid">
		</c:if>
		<c:if test="${position eq false}">
		<li>${userInfo.userid}</li>
		<input type="hidden" name="userid" id="userid" value="${userInfo.userid}">
		</c:if>
		<br>
		<label for="issuedate" class="inputtitle">날짜</label>
		<input type="date" name="issuedate" id="issuedate">
		<br>
		<label for="issue" class="inputtitle">사유</label>
		<input type="text" name="issue" id="issue" >
		<br>
		<button id="regist">출결 이슈 등록</button>
		<a class="btn btn-secondary" href="/board/product/list" >취소</a>
	</form>
	</div>
	<%-- --%>

<%@ include file="include/footer.jsp" %>