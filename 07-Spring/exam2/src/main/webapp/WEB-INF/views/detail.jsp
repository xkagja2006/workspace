<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="include/head.jsp"%>
</head>
<style>
form>label {
	display: inline-block;
	width: 100px;
}

form>:input {
	display: inline-block;
	width: 100px;
}
</style>
<body>
	<%@ include file="include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<h1 id="head">출결 관리 - 이슈 조회</h1>
		<form method="post" action="delete">
				<label for="ano" class="inputtitle">이슈 번호</label>
		<input type="text" name="userid" id="userid" value="${attendance.ano}">
		<br>
		<label for="userid" class="inputtitle">아이디</label>
		<input type="text" name="userid" id="userid" value="${attendance.userid}">
		<br>
		<label for="name" class="inputtitle">교육생명</label>
		<input type="text" name="name" id="name" value="${member.name}">
		<br>
		<label for="rclass" class="inputtitle">반</label>
		<input type="number" name="rclass" id="rclass" value="${member.rclass}">
		<br>
		<label for="rname" class="inputtitle">지역</label>
		<input type="text" name="rname" id="rname">
		<br>
		<label for="issuedate" class="inputtitle">날짜</label>
		<input type="text" name="issuedate" id="issuedate" value="${attendance.issuedate}">
		<br>
		<label for="issue" class="inputtitle">사유</label>
		<input type="text" name="issue" id="issue" value="${attendance.issue}">
		<br>
			</form>
			<a href="/board/product/deleteDetail?ano=${p.ano}">삭제</a>
	</div>

	<%@ include file="include/footer.jsp"%>