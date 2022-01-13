<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
response.setCharacterEncoding("UTF-8"); //사용자에게 보여지는  
response.setContentType("text/html; charset=UTF-8"); //받은 정보를 어떻게 해석할것인지
						//html을 UTF-8로 해석해!
//이미 있는 내장객체 이기 때문에 없어도 됨. 
//PrintWriter out = response.getWriter();

//null 에러가 나오지 않도록
//유효하지 않는 임시변수에 담기 (이름 뒤에 언더바 사용)
String count_ = request.getParameter("count");

int count = 100;//기본값 셋팅
//null이 아니면 | 빈문자열이 아니면 : 임시변수를 기본값으로 대체한다.
if(count_ != null && !count_.equals(""))
	count = Integer.parseInt(count_);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% for(int i = 0; i < count; i++) {%> <!-- 중괄호 한줄씩 코드블럭 -->
	안녕 Servlet<br>
	<% } %>
	
</body>
</html>