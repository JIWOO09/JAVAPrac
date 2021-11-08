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
		/*유효성 검사 진행
		1. 아이디가 회사 정책에 위반하는지 검사하는것 (자릿수, 제한된 특수문자 등)
		2. 패스워드가 회사 정책에 위반하는지 검사하는것 (자릿수, 제한된 특수문자 등)
		3. 1번, 2번 외의 사용자 입력들이 정책에 위반하는지 검사
		
		- 문제가 있는 경우
		문제가 있는 데이터를 사용자에게 다시 보내서 수정하도록 유도하기
		패스워드를 제외한 사용자 입력 데이터들은 사용자가 다시 입력하지 않을 수 있게 초기값을 설정해서 전달해야한다.
		
		- 문자가 없는 경우
		전달 받은 데이터를 데이터베이스에 저장 후 처리 결과를 알려주도록 해야한다.
		리다이렉트 방식을 사용하여 처리하도록 한다.
		*/
		
		String userid = request.getParameter("userid").toLowerCase(); //소문자로 
		String password = request.getParameter("password").toLowerCase();
		
		//길이 : 4~16자 사이의 문자열
		// 문자 종류 : 소문자, 숫자, 특수문자(_언더바만 허용)
		
           
            boolean isUseridValid = true;
            if(userid.length() >= 4 && userid.length() <= 16) {
                for(int i = 0; i < userid.length(); i++) {
                	System.out.println(isUseridValid);
	                if(userid.charAt(i) >= 'a' && userid.charAt(i) <= 'z') {
	                	isUseridValid = true;
	                } else if(userid.charAt(i) >= '0' && userid.charAt(i) <= '9') {
	                	isUseridValid = true;
	                } else if(userid.charAt(i) == '_') {
	                	isUseridValid = true;
	                } else {
	                	isUseridValid = false;
	                }
	                System.out.println(isUseridValid + "|" + userid.charAt(i));
	                if(!isUseridValid) {
	                	break;
	                }
                }
            } else {
            	isUseridValid = false;
            }
            
            
            boolean isPasswordValid = true;
            if(password.length() >= 4 && password.length() <= 16) {
                for(int i = 0; i < password.length(); i++) {
	                if(!(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')) {
	                	isPasswordValid = false;
	                }
	                
	                if(!(password.charAt(i) >= '0' && password.charAt(i) <= '9')) {
	                	isPasswordValid = false;
	                }
	
	                if(!(password.charAt(i) == '_')) {
	                	isPasswordValid = false;
	                }
	                if(isPasswordValid == false) {
	                	break;
	                }
                }
            } else {
            	isPasswordValid = false;
            }
            
     
		
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
		
		if(!isUseridValid || isPasswordValid) {
			
		} else {
			
		}
		 %>
        <p>
            <% if(!isUseridValid) { %>
                사용자 계정 및 패스워드가 잘못 되었습니다.<br>
                계정은 4 ~ 16자, 소문자, 숫자, 특수문자(_) 조합만 사용할 수 있습니다.<br>
                패스워드는 4 ~ 16자, 소문자, 숫자, 특수문자(_) 조합만 사용할 수 있습니다.
            <% } else { %>
                회원가입에 성공하였습니다.
                가입된 계정은 <%=userid %> 입니다.
            <% } %>
        </p>
            
	</section>
</body>
</html>