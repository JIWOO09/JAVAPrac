<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.web.guestbook.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
 <script type="text/javascript" src="/static/js/guestScript.js"></script>
</head>
<body>
    <header>
        <h1>네비게이션 메뉴 영역</h1>
    </header>
    <section>
        <section>
            <form action="./guest" method="post">
                <div>
                <%
                    GuestBookDTO dto = new GuestBookDTO();
                    if(request.getAttribute("init") != null) {
                        dto = (GuestBookDTO)request.getAttribute("init");
                    }
                %>
                    <textarea name="context"><%=dto.getContext() %></textarea>
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
                        <th colspan="2">내용</th>
                        <th>날짜</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<GuestBookDTO> datas =
                            (List<GuestBookDTO>) request.getAttribute("datas");
                        for(GuestBookDTO data: datas) {
                    %>
                        <tr>
                            <td><%=data.getId() %></td>
                            <td><%=data.getIpaddr() %></td>
                            <td><%=data.getContext() %></td>
                            <td>
                                <button onclick="guestModify(this.parentElement);">수정</button>
                                <form action = "./guest/delete" method ="post">
                                	<input type="hidden" name ="id" value ="<%=data.getId() %>">
                                <button type="submit">삭제</button>
                                </form>
                            </td>
                            <td><%=data.getDate() %></td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </section>
    </section>
    <footer>
        <h2>사이트 정보 영역</h2>
    </footer>
</body>
</html>