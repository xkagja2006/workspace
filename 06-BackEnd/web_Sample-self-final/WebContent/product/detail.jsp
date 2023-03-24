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
	
	  <h2>상품 정보</h2>
    <div class="form-group">
      <label for="productCode">고유번호</label>
     	<div>${product.code}</div>
    </div>
    <div class="form-group">
      <label for="model">모델명</label>
     	<div>${product.model}</div>
    </div>
    <div class="form-group">
      <label for="price">가격</label>
     	<div>${product.price}</div>
    </div>
    <a class="btn btn-secondary" href="${root}/product?action=delete&code=${product.code}">삭제</a>
    <a class="btn btn-secondary" href="${root}/product?action=list" >목록</a>
	    
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>






