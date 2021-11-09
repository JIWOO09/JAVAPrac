<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.account.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 진행 결과</title>
</head>
<body>
    <section>
        <h1>회원 가입 진행 결과</h1>
        <%
            request.setCharacterEncoding("UTF-8");
            /* 유효성 검사.... 진행
                   1. 아이디가 회사 정책에 위반하는지 검사하는 것(자릿수, 제한된 특수 문자 등)
                   2. 패스워가 회사 정책에 위반하는지 검사하는 것(자릿수, 제한된 특수 문자 등)
                   3. 1번 2번 외의 사용자 입력들이 정책에 위한 하는지 검사
                   
               - 문제가 있는 경우
                   문제가 있는 데이터를 사용자에게 다시 보내서 수정하도록 유도.
                   패스워드를 제외한 사용자 입력 데이터들은 사용자가 다시 입력하지 않을 수 있게 초기값을
                   설정해서 전달해야 한다.
                   
               - 문제가 없는 경우
                   전달 받은 데이터를 데이터베이스에 저장 후 처리 결과를 알려주도록 해야 함
                   리다이렉트 방식을 사용하여 처리하도록 해야 한다.
            */
            
            String username = request.getParameter("username").toLowerCase();
            String password = request.getParameter("password").toLowerCase();
            
            // 길이 : 4 ~ 16 사이의 문자열
            // 문자 종류(옵션) : 소문자, 숫자, 특수문자(_)
            boolean isUsernameValid = true;
            if(username.length() >= 4 && username.length() <= 16) {
                for(int i = 0; i < username.length(); i++) {
                	System.out.println(isUsernameValid);
	                if(username.charAt(i) >= 'a' && username.charAt(i) <= 'z') {
	                	isUsernameValid = true;
	                } else if(username.charAt(i) >= '0' && username.charAt(i) <= '9') {
	                	isUsernameValid = true;
	                } else if(username.charAt(i) == '_') {
	                	isUsernameValid = true;
	                } else {
	                	isUsernameValid = false;
	                }
	                System.out.println(isUsernameValid + "|" + username.charAt(i));
	                if(!isUsernameValid) {
	                	break;
	                }
                }
            } else {
            	isUsernameValid = false;
            }
            
            // 길이 : 4 ~ 16 사이의 문자열
            // 문자 종류(옵션) : 소문자, 숫자, 특수문자(_)
            boolean isPasswordValid = true;
            if(password.length() >= 4 && password.length() <= 16) {
                for(int i = 0; i < username.length(); i++) {
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
            
            AccountDTO dto = new AccountDTO();
            dto.setUsername(username);
            dto.setPassword(password);
            
            AccountService service = new AccountService(dto);
        %>
        <p>
            <%
                if(!service.isValid()) {
                	//유효성 검사
            %>	
                사용자 계정 및 패스워드가 잘못 되었습니다.<br>
                계정은 4 ~ 16자, 소문자, 숫자, 특수문자(_) 조합만 사용할 수 있습니다.<br>
                패스워드는 4 ~ 16자, 소문자, 숫자, 특수문자(_) 조합만 사용할 수 있습니다.
            <% } else {
                   if(service.join()) {
                       response.sendRedirect("./join_success.jsp");
                   } else {
                	   out.print("저장 과정중에 문제가 발생하였습니다.");
                   }
               }
            %>
        </p>
    </section>
</body>
</html>