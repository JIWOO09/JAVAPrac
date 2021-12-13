<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${data.getTitle()}</title>
	<jsp:include page="/WEB-INF/jsp/include/head1.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="${empty sessionScope.logined ? false : true}" />
		</jsp:include>
	</header>
	<section class="container">
		<div class="card text-dark bg-light">
			<div class="card-header">
				<h3>${data.getTitle()}</h3>
			</div>
			<div class="card-body">
				${data.getContent()}
			</div>
			<div class="card-footer text-end">
				<button class="btn btn-outline-primary">목록</button>
				<button class="btn btn-outline-success">수정</button>
				<button class="btn btn-outline-danger">삭제</button>
			</div>
		</div>
	</section>
</body>
