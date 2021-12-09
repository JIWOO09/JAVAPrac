<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"
		import="com.web.account.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	boolean isError = false;
	boolean logined = false;
	String errMsg = "";
	
	JoinDTO dto = new JoinDTO("", "", "");
	
	if(request.getAttribute("error") != null) {
		isError = true;
		errMsg = (String) request.getAttribute("error");
		dto = (JoinDTO) request.getAttribute("account_data");
		
	} else if (session.getAttribute("logined") != null) {
		logined = (boolean) session.getAttribute("logined");
		dto = (JoinDTO) session.getAttribute("account_data");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입 폼</title>
	<jsp:include page="/WEB-INF/jsp/include/head1.jsp" flush="false" />
	<script type="text/javascript" src="/static/js/join.js"></script>
</head>
<c:url var="ajax_url" value="/account/ajax/join" />
<script type="text/javascript">
function isDuplication(e){ //e : 이벤트 관련 object를 받는 argument
	$.ajax({
		type: "post",
		url: "${ajax_url}",
		data: {
			username: e.value
		},
		dataType: "json",
		success: function(data, status) {
			e.classList.add("is-valid");
			e.classList.remove("is-invalid");
			
			e.nextElementSibling.classList.add("valid-feedback");			
			e.nextElementSibling.classList.remove("invalid-feedback");
			e.nextElementSibling.innerText = data.msg;
		},
		error: function(data, status) {
			e.classList.add("is-invalid");
			e.classList.remove("is-valid");
			
			e.nextElementSibling.classList.add("invalid-feedback");			
			e.nextElementSibling.classList.remove("valid-feedback");
			e.nextElementSibling.innerText = "중복 아이디가 있습니다.";
		}
	});
}
</script>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="<%=logined %>" />
		</jsp:include>
	</header>
	<section class="container">
		<h2>Ajax 로 아이디 중복 체크하기.</h2>
		<div class="card border-dark">
			<div class="card-body text-dark">
				<form action="./join" method="post">
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label" for="id_username">아이디</label>
						<div class="col-sm-10">
							<input class="form-control" type="text"
								name="username" value="<%=dto.getUsername() %>" oninput="isDuplication(this);" required>
							<div class=""></div>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label" for="id_password">패스워드</label>
						<div class="col-sm-10">
							<input class="form-control" type="password" id="id_password"
								name="password" required>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label" for="id_passcheck">확인</label>
						<div class="col-sm-10">
							<input class="form-control" type="password" id="id_passcheck"
								name="password" required>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label" for="id_email">E-Mail</label>
						<div class="col-sm-10">
							<input class="form-control" type="email" id="id_email"
								name="email" value="<%=dto.getEmail() %>" required>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-11 col-form-label"></label>
						<div class="col-sm-1 text-end">
							<button class="btn btn-outline-primary" type="submit">가입</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>