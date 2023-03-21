<%@page import="java.util.List"%>
<%@page import="com.ssafy.board.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<BoardDto> list = (List<BoardDto>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>사용자</th>
			<th>제목</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<%
			for (BoardDto board : list) {
		%>
		<tr>
			<td><%=board.getArticleNo()%></td>
			<td><%=board.getUserId()%></td>
			<td><a href="<%=request.getContextPath()%>/board/view?articleNo=<%=board.getArticleNo()%>"><%=board.getSubject()%></a></td>
			<td><%=board.getHit()%></td>
			<td><%=board.getRegisterTime()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>