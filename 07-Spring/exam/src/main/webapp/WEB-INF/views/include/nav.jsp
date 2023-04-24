<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="/board/product/list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="/board/product/registForm">상품 정보 등록</a></li>

		<c:if test="${empty userInfo}">
			<form method="post" action="/board/member/login">
			아이디 : <input type="text" name="userId">
			비밀번호 : <input type="password" name="userPassword">
				<button>로그인</button>
			</form>
		</c:if>
		<c:if test="${not empty userInfo}">
			<li class="nav-item nav-link">${userInfo.userName} 님 환영합니다</li>
			<li class="nav-item"><a class="nav-link" href="/board/member/logout">로그아웃</a></li>
		</c:if>
	</ul>
</nav>