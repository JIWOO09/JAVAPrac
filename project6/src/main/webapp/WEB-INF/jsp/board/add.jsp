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
		<jsp:include page="/WEB-INF/jsp/include/head1.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="${empty sessionScope.logined ? false : true}" />
		</jsp:include>
	</header>
	<section class="container">
		<h4>게시판 글작성 기능</h4>
		<ol>
			<li>사용자가 제목을 전부 입력한 후에는 자동으로 제목만 있는 글이 만들어진다.</li>
			<li>제목만 있는 글이 만들어지기 위해 Ajax 를 통해 서버에 제목을 전달하면 서버에서는 해당 제목의 글을 데이터베이스에 생성 후 생성한 글의 ID 를 클라이언트에 전달한다.</li>
			<li>ID를 받은 클라이언트는 페이지 내부에 숨겨진 요소에 ID 값을 저장한다.</li>
			<li>사용자가 글 내용을 작성 후 저장 버튼을 누르면 서버에 ID, 제목, 글 내용 등의 정보를 전달하여 이전에 저장해둔 데이터에 업데이트 처리한다.</li>
		</ol>
		<div class="card text-dark bg-light">
			<div class="card-body">
				<h5 class="row card-title">
					<input form="id_form" class="form-control" type="text"
						name="title" placeholder="제목" value="${param.title}"> <!-- 제목 먼저 저장 -->
				</h5>
				<div class="row mb-3">
					<textarea form="id_form" class="form-control" rows="10"
						name="content" placeholder="내용">${param.content}</textarea>
				</div>
				<div class="mb-3 text-end">
					<button form="id_form" class="btn btn-outline-primary" type="submit">저장</button>
				</div>
				<input form="id_form" type="hidden" name="bid" value="${param.bid}">
			</div>
			<div class="card-footer" id="status">
				<span>글자수 : <label>0</label> 자</span>
				<span><label></label></span>
			</div>
		</div>
		<c:url var="form_url" value="/board/add" />
		<form id="id_form" action="${form_url}" method="post"></form>
	</section>
</body>
<c:url var="ajax_url" value="/board/ajax/add" />
<script type="text/javascript">
	var title = document.getElementsByName("title")[0]; //타이틀 요소찾고
	title.addEventListener("keydown", function(e) { //그 타이틀에 이번트 등록 keydown : 키입력 이벤트
		if(e.keyCode === 13) { //오로지 엔터키만 감지를 뜻하는 코드
 			e.preventDefault();
			document.getElementsByName("content")[0].focus();
		}
	});
	title.addEventListener("blur", function(e) { //포커스 빠져나가는 이벤트
		e.preventDefault();
		saveBoard(this.value); //엔터키 누르면 저장
		document.getElementsByName("content")[0].focus(); //컨텐츠 요소로 이동
	});
	
	function saveBoard(title) {
		$.ajax({
			type: "post",
			url: "${ajax_url}", //페이지 소스로 보기
			data: {
				bid: document.getElementsByName("bid")[0].value, //제목을 도중에 수정하기 위해 bid
				title: title //보낼 테이터
			},
			dataType: "json",
			beforeSend: function() {
				document.getElementById("status").innerText = "저장 처리중...";
			},
			success: function(data, status) {
				if(data.status === "success") {
					document.getElementsByName("bid")[0].value = data.bid;
					document.getElementById("status").innerText = data.message;
				} else {
					document.getElementById("status").innerText = data.message;
				}
			}
		});
	}
	</script>
</html>