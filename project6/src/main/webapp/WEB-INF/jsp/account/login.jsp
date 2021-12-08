<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"
		import="com.web.account.model.JoinDTO" %>
		
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	JoinDTO dto = new JoinDTO("", "", "");
		boolean logined = false;
	
	
	if(session.getAttribute("logined") != null) {
		logined = (boolean) session.getAttribute("logined");
		dto = (JoinDTO) session.getAttribute("account_data");
	}
	
	pageContext.setAttribute("isError", false);
		if(request.getAttribute("error") != null) {
			pageContext.setAttribute("isError", true);
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<jsp:include page="/WEB-INF/jsp/include/head1.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="${empty sessionScope.logined ? false : true}" />
		</jsp:include>
	</header>
	<c:url var="login_url" value="/login" />
	<form action="${login_url}" method="post">
		<div>
			<input type="text" name="username" value="${param.username}" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="password" placeholder="패스워드">
		</div>
			<c:if test="${isError}">
				<div>
					<lable>${error}</lable>
				</div>
			</c:if>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
</body>
</html>