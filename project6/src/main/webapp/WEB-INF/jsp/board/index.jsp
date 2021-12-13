<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"
		import="com.web.board.model.*" %>
		
<%-- 구글에서 apache jstl 검색 -> JSP(tm) Standard Tag Library, Standard, Jar Files 다운 -> lib 파일에 4개 Jar Files 넣기 --%>		
<%-- core 라이브러리 : 변수 설정, 제어문, 반목문의 처리와 관련된 기능 제공  --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- fmt 라이브러리 : 숫자, 날짜 등의 형식과 관련된 기능 제공 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- function 라이브러리 : 문자열 처리와 관련된 함수 기능 제공 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
    	<jsp:include page="/WEB-INF/jsp/include/head1.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="${empty sessionScope.logined ? false : true}" />
		</jsp:include>
	</header>
	<section class="container">
		<div>
			<ul class="nav nav-tabs nav-pills">
				<c:forEach var="cat" items="${category}">
					<li class="nav-item">
						<a class="nav-link ${param.type eq cat.getId() ? 'active' : '' }"
							href="/board?type=${cat.getId()}">${cat.getName()}게시판</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="text-end">
			<c:url var="add_url" value="/board/add" />
			<button type="button" class="btn btn-outline-dark btn-sm" onclick="location.href='${add_url}'">글쓰기</button>
		</div>
		<div>
			<table class="table table-hover table-striped">
				<colgroup>
					<col class="col-1">
					<col class="col-6">
					<col class="col-2">
					<col class="col-2">
					<col class="col-1">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="data" items="${datas}">
						<c:url var="detail_url" value="/board/detail" >
							<c:param name="id" value="${data.getId()}" />
						</c:url>
						<tr onclick="location.href='${detail_url}'" style="cursor:pointer;">
							<td class="text-end">${data.getId()}</td>
							<td>${data.getTitle()}</td>
							<td>${data.getWriter()}</td>
							<td><fmt:formatDate value="${data.getCreateDate()}" pattern="YYYY년 MM월 dd일" /></td>
							<td class="text-end"><fmt:formatNumber value="${data.getViewCount()}" type="number" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<c:url var="search_url" value="/board" />
				<form action="${search_url}">
					<div class="input-group w-25">
						<input class="form-control" type="text" name="search" placeholder="제목">
						<button class="btn btn-outline-dark" type="submit">검색</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>