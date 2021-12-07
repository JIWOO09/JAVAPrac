<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean logined = request.getParameter("logined").equals("true");
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link" href="/">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/guestbook">방명록</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/board">게시판</a>
				</li>
			</ul>
			<div class="d-flex">
				<ul class="navbar-nav">
				<% if(logined) { %>
					<li class="nav-item">
						<a class="nav-link" href="/info">내 정보</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/logout">로그아웃</a>
					</li>
				<% } else { %>
					<li class="nav-item">
						<a class="nav-link" href="/join">회원가입</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/login">로그인</a>
					</li>
				<% } %>
				</ul>
			</div>
		</div>
	</div>
</nav>