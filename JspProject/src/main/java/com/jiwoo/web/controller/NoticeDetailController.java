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
		
		//ID �Ѱܹޱ�
		int id = Integer.parseInt(request.getParameter("id"));
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID=?"; //Ư�� ID �Խñ� ��ȸ
		
		//�� 4���� ��ü�� �����ؾ��Ѵ�(new�� ��ü �������� ����) -> ���� �ٲ��� ���� 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ù��° �ε� ��ü ����
			//�޸𸮻� ����̹��� �ö�
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//�ι�° ���� ��ü ����
			//���� �Ǹ� ��ü ����
			PreparedStatement st = con.prepareStatement(sql);
			//con���� �̾� �޾� ����° ���� ��ü ����
			
			//ù��° ���̵�
			st.setInt(1, id);
			//����ڷκ��� �䱸 ���� ���� ����
			ResultSet rs = st.executeQuery();
			
			rs.next();

			//ȭ��� HTML���� ����� ������ ������ -> model
			String title = rs.getString("TITLE");
			Date regdate = rs.getDate("REGDATE");
			String writerid = rs.getString("WRITER_ID");
			String hit = rs.getString("HIT");
			String files = rs.getString("FILES");
			String content = rs.getString("CONTENT");
			
			//notice��ü�׸��� ������(�Ӽ���)���, �����ڿ� ���� �����ϰ�
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
			
			//���� �������� �����(������ ���)
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
		
	
		
		//forward : �۾� �̾� �޾� ȭ��ܰ� �����ϱ�
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);
	
	}

}