<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>    
	<div class="container p-4">
		
		<c:choose>
			<c:when test="${empty userInfo}">
				<form method="post" action="${root}/member">
					<input type="hidden" name="action" value="login" />
					<input type="text" name="id" />
					<input type="text" name="password" />
					<button>로그인</button>
				</form>			
			</c:when>
			<c:otherwise>
				안녕하세요. 상품 관리 사이트 입니다.
			</c:otherwise>
		</c:choose>
		
		
		
		
	</div>

<%@ include file="/include/footer.jsp" %>







