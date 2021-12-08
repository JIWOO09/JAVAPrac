<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession"
		import="com.web.account.model.JoinDTO" %>
<%
	JoinDTO dto = new JoinDTO("", "", "");
	//boolean logined = false; 이걸로 인해 필요없어짐 -> ${empty sessionScope.logined

	if(session.getAttribute("logined") != null) {
		//logined = (boolean) session.getAttribute("logined");
		dto = (JoinDTO) session.getAttribute("account_data");
		
		pageContext.setAttribute("dto", dto);
		
		
		//scope 정의
		//현재 jsp 페이지에서만 유효하게 사용할 경우 pageContext
		//pageContext.setAttribute("username", dto.getUsername());
		//pageContext.setAttribute("logined", logined);
		
		//사용자 요청을 모두 처리할 때 까지 유효하게 사용할 경우
		//request.setAttribute("username", dto.getUsername());
		//request.setAttribute("logined", logined);
	
		//사용자의 세션이 만료 될 때까지 유효하게 사용할 경우
		//session.setAttribute("username", dto.getUsername());
		//session.setAttribute("logined", logined);
	
		//웹어플리케이션이 종료 될 때까지 유효하게 사용할 경우
		//controller에 작성
		//application.setAttribute("username", dto.getUsername());
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