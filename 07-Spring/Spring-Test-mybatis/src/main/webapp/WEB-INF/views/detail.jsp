<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
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
</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<h1 id="head">출결 관리 - 이슈 조회</h1>
	<form>
		<label for="ano" class="inputtitle">이슈 번호</label>
		<input type="text" name="ano" id="ano" value="${attendance.ano}">
		<br>
		<label for="userid" class="inputtitle">아이디</label>
		<input type="text" name="userid" id="userid" value="${attendance.userid}">
		<br>
		<label for="name" class="inputtitle">교육생명</label>
		<input type="text" name="name" id="name" value="${attendance.user.name}">
		<br>
		<label for="rclass" class="inputtitle">반</label>
		<input type="number" name="rclass" id="rclass"  value="${attendance.user.rclass}">
		<br>
		<label for="rname" class="inputtitle">지역</label>
		<input type="text" name="rname" id="rname" value="${attendance.user.rname}">
		<br>
		<label for="issuedate" class="inputtitle">날짜</label>
		<input type="text" name="issuedate" id="issuedate" value="${attendance.issuedate}">
		<br>
		<label for="issue" class="inputtitle">사유</label>
		<input type="text" name="issue" id="issue" value="${attendance.issue}">
		<br>

		<%@ include file="/WEB-INF/views/footer.jsp"%>

	</form>
</body>
<script>
	
</script>
</html>