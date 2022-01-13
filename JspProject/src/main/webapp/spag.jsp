<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	int num = 0;
	String num_ = request.getParameter("n");
	if(num_ != null && !num_.equals(""))
		num = Integer.parseInt(num_);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 많은 코드블럭으로 인해 스파게티 코드가 될 수 있다. -->
<% 	if(num %2 == 0)  { %>
	짝수입니다.
	<% }  else  { %>
	홀수입니다.
	<% } %>
	
	
</body>
</html>