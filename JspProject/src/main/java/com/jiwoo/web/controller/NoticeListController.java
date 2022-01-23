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
	
		//notice ��ü�� ������ �ʿ��ϱ� ������ 
		List<Notice> list = new ArrayList<>();
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE"; //���̺� ��ȸ
		
		try {
			//�� 4���� ��ü�� �����ؾ��Ѵ�(new�� ��ü �������� ����) -> ���� �ٲ��� ���� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ù��° �ε� ��ü ����
			//�޸𸮻� ����̹��� �ö�
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//�ι�° ���� ��ü ����
			//���� �Ǹ� ��ü ����
			Statement st = con.createStatement();
			//con���� �̾� �޾� ����° ���� ��ü ����
			//����ڷκ��� �䱸 ���� ���� ����
			ResultSet rs = st.executeQuery(sql);


							
			while(rs.next()) {
				int id = rs.getInt("ID");
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
				
				//�ݺ��� ����� ��ü�� �߰�
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
		
		//���� �� request�� ���
		request.setAttribute("list", list);
		
		//forward : �۾� �̾� �޾� ȭ��ܰ� �����ϱ�
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	}

}
