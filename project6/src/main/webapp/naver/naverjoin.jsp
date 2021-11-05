<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
</head>
<body>
	<section>
		<%
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("userid : " + request.getParameter("userid"));
		System.out.println("password : " + request.getParameter("password"));
		System.out.println("passwordcheck : " + request.getParameter("passwordcheck"));
		System.out.println("username : " + request.getParameter("username"));
		System.out.println("year : " + request.getParameter("year"));
		System.out.println("month : " + request.getParameter("month"));
		System.out.println("day : " + request.getParameter("day"));
		System.out.println("gender : " + request.getParameter("gender"));
		System.out.println("email : " + request.getParameter("email"));
		System.out.println("phone_code : " + request.getParameter("phone_code"));
		System.out.println("phone_number : " + request.getParameter("phone_number"));
		System.out.println("auth_num : " + request.getParameter("auth_num"));
		
		%>
		
		<p>
			<%=request.getParameter("username") %> 님 회원가입을 축하드립니다.
		</p>
	</section>
</body>
</html>