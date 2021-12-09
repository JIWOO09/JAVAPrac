<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- core 라이브러리 : 변수 설정, 제어문, 반목문의 처리와 관련된 기능 제공  --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- fmt 라이브러리 : 숫자, 날짜 등의 형식과 관련된 기능 제공 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- function 라이브러리 : 문자열 처리와 관련된 함수 기능 제공 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
</head>
<c:url var="ajax_url" value="/board/ajax/add" /><!-- 이 경로에 대한 콘트롤러 생성 -->
<script type="text/javascript">
function sendAjax() {
	$.ajax({
		type: "get",
		url: "${ajax_url}",
		data: {
			val: "데이터 전송 확인!"
		},
		dataType: "json",
		success: function(data, status) {
			// 여기에 기능을 구현.
			// data 인자는 서버가 전송한 데이터 이다.
			// document.getElementById("result").innerText = data.result;
			console.log(data);
			console.log(data.firstName);
			console.log(data.lastName);
			console.log(data.phoneNumbers);
			console.log(data.phoneNumbers[0]);
			console.log(data.phoneNumbers[1]);
			console.log(data.phoneNumbers[1].Home);
		},
		error: function(data, status) {
			// 여기에 기능을 구현.
			// data 인자는 서버가 전송한 데이터 이다.
			console.log("에러");
		}
	});
}
</script>
<body>
	<div>
		<input type="button" value="버튼" onclick="sendAjax();">
	</div>
	<hr>
	<div>
		<span>결과는 여기에 -></span><span id="result"></span>
	</div>
</body>
</html>>