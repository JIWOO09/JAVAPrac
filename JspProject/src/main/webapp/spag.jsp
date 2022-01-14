<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 저장소 역할 하는 객체 -->
<% 
pageContext.setAttribute("result", "hello");
%>

	<!-- result에 담긴 값 꺼내어 출력 -->
	<%= request.getAttribute("result") %> 입니다.<br>

	${requestScope.result} 입니다~ <br>
	${names[0]}<br>
	${notice.title}<br>
	${result}<br>
	${header.accept}<br>
	${empty param.n}<br>
	${param.n == null ||param.n == ''} <br>
	${empty param.n?'값이 비어있습니다.' : param.n}<br>
	${param.n/2}
	
</body>
</html>