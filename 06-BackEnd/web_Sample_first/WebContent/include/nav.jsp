<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link"
			href="${root}/product?action=list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link"
			href="${root}/product?action=registForm">상품 정보 등록</a></li>
		<c:if test="${not empty userInfo}">
		<ul class="nav-item ms-auto text-white">
			<li class="nav-item">${userInfo.name} 님 환영합니다.</a></li>
			<a class="btn btn-primary" href="${root}/product?action=logout">로그아웃</a>
		</ul>
		</c:if>

	</ul>
</nav>