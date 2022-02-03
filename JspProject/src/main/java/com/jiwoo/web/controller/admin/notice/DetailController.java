package com.jiwoo.web.controller.admin.notice;

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
import com.jiwoo.web.service.NoticeService;


@WebServlet("/admin/board/notice/detail")
public class DetailController extends HttpServlet {

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		//ID �Ѱܹޱ�
		int id = Integer.parseInt(request.getParameter("id"));
		
		//����� �Է°� ����� ���� service��ü
		NoticeService service = new NoticeService();
		//NoticeService�� ����� getNotice�� ���
		Notice notice = service.getNotice(id);
		//request�� ��Ƽ� n�� ����Ͽ� ��ܿ� ���
		request.setAttribute("n", notice);
	
		
		//forward : �۾� �̾� �޾� ȭ��ܰ� �����ϱ�
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/detail.jsp").forward(request, response);
	
	}

}
