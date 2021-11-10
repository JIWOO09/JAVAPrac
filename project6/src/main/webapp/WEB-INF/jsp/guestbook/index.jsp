<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.web.guestbook.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<header>
		<h1>네비게이션 메뉴가 위치 할 곳</h1>
	</header>
	<section>
		<section>
			<form action="./guest" method="post">
				<div>
				<% 
					GuestBookDTO dto = new GuestBookDTO();
					if(request.getAttribute("init") != null) {
					dto = (GuestBookDTO)request.getAttribute("init");
				}%>
					<textarea name ="context"><%=dto.getContext()%></textarea>
				</div>
				<div>
					<button type="submit">작성</button>
				</div>
			</form>	
		</section>
			<section>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>IP주소</th>
							<th>내용</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>xxx.xxx.1.1</td>
							<td>방명록 내용</td>
							<td>2021-11-10</td>
						</tr>
						<tr>
							<td>2</td>
							<td>xxx.xxx.1.1</td>
							<td>방명록 내용</td>
							<td>2021-11-12</td>
						</tr>
						<tr>
							<td>3</td>
							<td>xxx.xxx.1.1</td>
							<td>방명록 내용</td>
							<td>2021-11-13</td>
						</tr>
					</tbody>
				</table>
			</section>
				<section>
					<h2>사이트 정보 영역</h2>
				</section>
	</section>
	
</body>
</html>