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
	<div>
		<ul class ="nav nav-tabs nav-pills">
		<%--반복문 사용 --%>
		 <c:forEach var="cat" items="${category}">
		 	<li class="nav-item"> 
		 	<a class="nav-link ${type eq cat.getId() ? 'active' : '' }"
						href="/board?type=${cat.getId()}">${cat.getName()}게시판</a></li>
						
		 </c:forEach>	
		</ul>
	</div>
	<div>
		<button type="button" onclick="location.href='/board/add'">글쓰기</button>
	</div>
	<div>
		<table>
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
			<%-- 반목문 적용하기 --%>
				<c:forEach var="data" items="${datas}" >
					<tr onclick="location.href='/board/detail?id=${data.getTitle()}'">						
						<td>${data.getId()}</td>
						<td>${data.getTitle()}</td>
						<td>${data.getWriter()}</td>
						<td>${data.getCreateDate()}</td>
						<td>${data.getViewCount()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>