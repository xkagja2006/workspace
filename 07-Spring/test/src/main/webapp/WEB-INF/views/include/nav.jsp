<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
span {
	color: white;
}
</style>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link"
			href="${root}/product/list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link"
			href="${root}/product/writePage">상품 정보 등록</a></li>

		<c:if test="${empty userInfo}">
			<form method="post" action="${root}/user/login">
				<input type="text" name="id" /> <input type="password"
					name="password" />
				<button>로그인</button>

			</form>
		</c:if>
		<c:if test="${not empty userInfo}">
			<span>${userInfo.name}님 환영합니다!~~!</span>
			<a href="${root}/user/logout">로그아웃</a>
		</c:if>

	</ul>
</nav>

