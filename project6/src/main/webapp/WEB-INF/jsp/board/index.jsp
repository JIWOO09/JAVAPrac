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
		 	<li class="nav-item"> <%--controller에서 setAttribute대신 param  --%>
		 	<a class="nav-link ${param.type eq cat.getId() ? 'active' : '' }"
						href="/board?type=${cat.getId()}">${cat.getName()}게시판</a></li>		
		 </c:forEach>	
		</ul>
	</div>
	<div>
		<%--URL 추가 --%>
		<c:url var="add_url" value="/board/add"/>
		<button type="button" onclick="location.href='${add_url}'">글쓰기</button>
	</div>
	
	<%--
		문자열 처리 함수
	 --%>
	 <c:set var="txt1" value="Hello JSTL"/>
	 <c:set var="txt2" value="JSTL 태그 라이브러리"/>
	문자열 길이 fn:length -> ${fn:length(txt1)}<br>
	문자열 길이 fn:length -> ${fn:length(txt2)}<br>
	대소문자 변환 fn:toUpperCase() -> ${fn:toUpperCase(txt1)}<br>
	대소문자 변환 fn:toLowerCase() -> ${fn:toLowerCase(txt1)}<br>
	문자열 자르기 fn:subString() -< ${fn:substring(txt2, 5, 7)}<br>
	공백 제거 fn:trim() -> ${fn:trim(txt1)}<br>
	문자열 바꾸기 fn:replace() -> ${fn:replace(txt2, "태그", "Tag")}<br>
	문자열 위치 찾기 fn:indexOf() -> ${fn:indexOf(txt2, "태그")}<br>
	문자열 존재 유무 fn:contains() -> ${fn:contains(txt2, "태그")}<br>
	문자열 분리 fn:split() -> ${fn:split(txt2, " ")}<br>
	<%--분리되어 나온 배열 넣어주기 --%>
	<c:set var="space" value=" "/>
	<c:forEach var="t" items="${fn:split(txt2, ' ')}">
		<span>${t}</span> 
	</c:forEach>
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
					<c:url var="detail_url" value="/board/detail">
						<c:param name="id" value="${data.getId()}" />
					</c:url>	
					<tr onclick="location.href='${detail_url}'">						
						<td>${data.getId()}</td>
						<td>${data.getTitle()}</td>
						<td>${data.getWriter()}</td>
						<!-- <td>${data.getCreateDate()}</td> -->
						<td><fmt:formatDate value="${data.getCreateDate()}" pattern="yyyy년 mm월 dd일"/></td>
						<td><fmt:formatNumber value="${data.getViewCount()}" type="number"/></td>
						<!-- <td>${data.getViewCount()}</td>-->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>