package com.jiwoo.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiwoo.web.entity.Notice;


@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		//ID 넘겨받기
		int id = Integer.parseInt(request.getParameter("id"));
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID=?"; //특정 ID 게시글 조회
		
		//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//첫번째 로드 객체 생성
			//메모리상에 드라이버가 올라감
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//두번째 연결 객체 생성
			//연결 되면 객체 참조
			PreparedStatement st = con.prepareStatement(sql);
			//con으로 이어 받아 세번째 실행 객체 생성
			
			//첫번째 아이디
			st.setInt(1, id);
			//사용자로부터 요구 받은 쿼리 실행
			ResultSet rs = st.executeQuery();
			
			rs.next();

			//화면단 HTML에서 사용할 변수를 만들자 -> model
			String title = rs.getString("TITLE");
			Date regdate = rs.getDate("REGDATE");
			String writerid = rs.getString("WRITER_ID");
			String hit = rs.getString("HIT");
			String files = rs.getString("FILES");
			String content = rs.getString("CONTENT");
			
			//notice객체그릇에 데이터(속성들)담기, 생성자와 순서 동일하게
			Notice notice = new Notice(
								id,
								title,
								regdate,
								writerid,
								hit,
								files,
								content
								);
			request.setAttribute("n", notice);
			
			//만든 변수들의 저장소(데이터 담기)
//			request.setAttribute("title", title);
//			request.setAttribute("regdate", regdate);
//			request.setAttribute("writerid ",  writerid );
//			request.setAttribute("hit", hit);
//			request.setAttribute("files", files);
//			request.setAttribute("content", content);
			
		 	rs.close();
		 	st.close();
		 	con.close();
		 	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
		//forward : 작업 이어 받아 화면단과 공유하기
		request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);
	
	}

}
