<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.join.model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<script type="text/javascript" src="/static/js/join.js"></script>
</head>
<body>
	<%
		JoinDTO initData = new JoinDTO();
		if(request.getAttribute("initData") != null) {
			initData = (JoinDTO) request.getAttribute("initData");
		}
	%>
	<form action="./join" method="post"> <!-- 보여지지 않게 post -->
		<div>
			<input type="text" name="username" value="<%=initData.getUsername() %>" placeholder="아이디" required>
		</div>
		<div>
			<input type="password" id="id_pass1" name="password" placeholder="패스워드" required>
		</div>
		<div>
			<input type="password" id="id_pass2" name="password_check" placeholder="패스워드 확인" required>
			<div><label></label></div>
		</div>
		<div>
			<input type="email" name="email" value="<%=initData.getEmail() %>" placeholder="이메일" required>
		</div>
		<div>
			<button type="submit">가입</button>
		</div>
	</form>
</body>
</html>