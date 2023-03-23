<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ssafy.todo.model.Todo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<head>
<meta charset="utf-8">
<title>TodoMVC</title>
<link rel="stylesheet" href="${root}/css/todo/base.css">
<link rel="stylesheet" href="${root}/css/todo/index.css">
<link rel="stylesheet" href="${root}/css/todo/app.css">
</head>
<body>
	<section class="todoapp">
		<header class="header">
			<h1>오늘의 할일</h1>
			<form action="${root}/todo" method="post">
				<input type="hidden" name="action" value="regist" /> <input
					type="text" class="new-todo" placeholder="오늘의 할일을 적으세요!"
					name="content" autofocus>
			</form>
		</header>
		<section class="main">
			<ul class="todo-list">
				<c:forEach var="todo" items="${todoList }">
					<li>
						<div class="view">
							<input type="hidden" name="action" value="delete" /> 
							<label>${todo.content}</label>
							<a href="${root}/todo?action=delete&no=${todo.no}" class="destroy"></a>
						</div> <input class="edit" value="오늘">
					</li>
				</c:forEach>
			</ul>
		</section>
		<footer class="footer">
			<span class="todo-count">전체 <strong>${todoList.size()}</strong>개
			</span> <a href="${root}/todo?action=clear" class="clear-completed">전체 지우기</a>
		</footer>
	</section>
</body>
</body>
</html>