<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<div>
	<a href="${root}/board/list">게시판</a>
	<c:if test="${not empty userInfo}">
		<span>${userInfo.name}님 환영합니다</span>
		<a href="${root}/user/logout">로그아웃</a>
	</c:if>
</div>