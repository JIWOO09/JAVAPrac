<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.web.account.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 진행 절차</title>
</head>
<body>
	<section>
		 <h1>회원가입 진행 절차</h1>

		<%
			request.setCharacterEncoding("UTF-8");
			//한글데이터 입력
			System.out.println(request.getParameter("username"));
			System.out.println(request.getParameter("password"));
			System.out.println(request.getParameter("gender"));
			System.out.println("avd:"); 
			
			if(request.getParameterValues("adv") != null); {
				//null이 아닐 때의 조건문
				String[] adv = request.getParameterValues("adv");
				//배열을 출력하려면 for이 필요 -> 안그럼 참조주소만 나옴 (값을 담을 그릇이 필요하기 때문)
			for(String s : adv) {
				System.out.print(s + " ");
			} 
			}	
			System.out.println();
			
			System.out.println("year : " + request.getParameter("year"));
			System.out.println("month : " + request.getParameter("month"));
			System.out.println("day : " + request.getParameter("day"));
			System.out.println("context : " + request.getParameter("context"));
			%> 
		
		<p>
			<%=request.getParameter("username") %> 정보를 잘 받았습니다.
		</p>
		
	
	</section>
</body>
</html>