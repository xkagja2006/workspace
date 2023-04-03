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
	<div>
		<c:if test="${empty userInfo}">
			<form method="POST" action="${root}/product">
				<input type="hidden" name="action" value="login"> <label
					id="id">아이디 : </label> <input type="text" name="id" id="id">
				<label id="password">비밀번호 : </label> <input type="password"
					name="password" id="password">
				<button class="btn btn-secondary">로그인</button>
			</form>
		</c:if>
	</div>
	<div class="container p-4">안녕하세요. 상품 관리 사이트 입니다. - 첫번째!!!!!</div>

	<%@ include file="/include/footer.jsp"%>