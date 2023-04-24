<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>SSAFY</title>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<h1 id="head">출결 이슈 - 출결 이슈 등록</h1>
	<form id="registForm">
		<label for="ano" class="inputtitle">이슈 번호</label>
		<input type="text" name="ano" id="ano">
		<br>
		<label for="userid" class="inputtitle">아이디</label>
		<input type="text" name="userid" id="userid">
		<br>
		<label for="issuedate" class="inputtitle">날짜</label>
		<input type="date" name="issuedate" id="issuedate">
		<br>
		<label for="issue" class="inputtitle">사유</label>
		<input type="text" name="issue" id="issue" >
		<br>
		<button id="regist">출결 이슈 등록</button>
	</form>

	<fieldset id="result">
		<legend>등록 오류</legend>
		<div ></div>
	</fieldset>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>

</html>