<%@page import="com.ssafy.board.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoardDto board = (BoardDto) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H2>게시판</H2>
	<table>
		<tr>
			<th>번호</th>
			<td><%=board.getArticleNo()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=board.getSubject()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=board.getContent()%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=board.getHit()%></td>
		</tr>
	</table>
		<div>
			<a href="<%=request.getContextPath()%>/board/list">목록 </a>
		</div>
</body>
</html>