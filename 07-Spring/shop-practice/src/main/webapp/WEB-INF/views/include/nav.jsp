<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/board/list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/board/regist">상품 정보 등록</a></li>
		<c:if test="${not empty userInfo}">
			<li class="nav-item bg-white">
				<div>${userInfo.userName} 님 안녕하세요.</div>
			</li>
			<li class="nav-item"><a href="${root}/user/logout">로그아웃</a></li>
		</c:if>
		<c:if test="${empty userInfo}">
			<form method="POST" action="${root}/user/login">
				<li class="nav-item">아이디 : <input type="text" id="userId"
					name="userId" placeholder="아이디..." value="${id}" /> 비밀번호 : <input
					type="password" name="password" />
					<button>로그인</button></li>
			</form>
			<li class="nav-item"><a href="${root}/user/logout">로그아웃</a></li>
			</div>
		</c:if>
	</ul>
</nav>