package com.jiwoo.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiwoo.web.entity.Notice;


@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//notice 객체가 여러개 필요하기 때문에 
		List<Notice> list = new ArrayList<>();
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE"; //테이블 조회
		
		try {
			//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//첫번째 로드 객체 생성
			//메모리상에 드라이버가 올라감
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//두번째 연결 객체 생성
			//연결 되면 객체 참조
			Statement st = con.createStatement();
			//con으로 이어 받아 세번째 실행 객체 생성
			//사용자로부터 요구 받은 쿼리 실행
			ResultSet rs = st.executeQuery(sql);


							
			while(rs.next()) {
				int id = rs.getInt("ID");
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
				
				//반복문 실행시 객체에 추가
				list.add(notice);
				
				}
		    	rs.close();
		    	st.close();
		        con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//전달 전 request에 담기
		request.setAttribute("list", list);
		
		//forward : 작업 이어 받아 화면단과 공유하기
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	}

}
