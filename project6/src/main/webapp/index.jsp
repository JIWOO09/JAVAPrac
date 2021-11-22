<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<!DOCTYPE html>
<html>
<head lang = "ko">
<meta charset="UTF-8">
<title>메인 화면</title>
</head>

<% 
	Cookie[] cookie = request.getCookies();
	boolean logined = false;
	String username = "";
	
	for(Cookie c: cookie) {
		if(c.getName().equals("login_name")) {
			logined = true;
			username = c.getValue();
		}
	}



%>
<body>
	<ul>
		<li><a href="/guest">방명록</a></li>
		
			<!-- 로그인 상태가 맞는 경우 -->
		<% 
			if(logined) {
		%>
			<li><a href="/info">내정보</a></li>
			<li><a href="/logout">로그아웃</a></li>
		<% } else { %>
			<!-- 로그인 상태가 아닌 경우 -->
			<li><a href="/join">회원가입</a></li>
			<li><a href="/login">로그인</a></li>
		<% } %>
	</ul>
		<%
			if(logined) {
		%>
			<h1>Cookie -> <%=username %> 님 환영합니다.</h1>
		<%
			}
		%>
		
		<%
			if(session.getAttribute("login_name") != null) {
		%>
			<h1>Session -> <%=(String)session.getAttribute("login_name") %>님 환영합니다.</h1>
		<% 
			}
		%>
</body>
</html>