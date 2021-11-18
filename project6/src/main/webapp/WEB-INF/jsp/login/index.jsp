<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<form action="./login" method = "post">
		<div>
		
		<%
			String login_error = "";
			if(request.getAttribute("login_error") != null) {
				login_error = (String)request.getAttribute("login_error");
			}
		%>
		<div>
			<%
				if(!login_error.isEmpty()) {
			%>
				<input type="text" name="username" value="<%=request.getParameter("username") %>" placeholder="아이디">
			<%
				} else {
			%>
				<input type="text" name="username" placeholder="아이디">
			<%
				}
			%>
		</div>
		<div>
			<input type="password" name="password" placeholder="패스워드">
		</div>
		<%
			if(!login_error.isEmpty()) {
		%>
			<div>
				<label><%=login_error %></label>
			</div>
		<%
			}
		%>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
</body>
</html>