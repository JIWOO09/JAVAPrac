<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession"
		import="com.web.account.model.JoinDTO" %>
<%
	JoinDTO dto = new JoinDTO("", "", "");
	if(session.getAttribute("logined") != null) {
		dto = (JoinDTO) session.getAttribute("account_data");
		pageContext.setAttribute("dto", dto);
	}
%>
<!DOCTYPE html>
<html>
<head lang="ko">
    <meta charset="UTF-8">
    <title>메인 화면</title>
    <jsp:include page="/WEB-INF/jsp/include/head1.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="${empty sessionScope.logined ? false : true }" />
		</jsp:include>
	</header>
	<h1>${dto.getUsername() } 님 환영합니다.</h1>
</body>
</html>