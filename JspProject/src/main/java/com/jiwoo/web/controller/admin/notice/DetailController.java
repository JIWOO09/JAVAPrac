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
		
		//ID 넘겨받기
		int id = Integer.parseInt(request.getParameter("id"));
		
		//사용자 입력과 출력을 위한 service객체
		NoticeService service = new NoticeService();
		//NoticeService의 기능인 getNotice를 사용
		Notice notice = service.getNotice(id);
		//request에 담아서 n을 사용하여 뷰단에 출력
		request.setAttribute("n", notice);
	
		
		//forward : 작업 이어 받아 화면단과 공유하기
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/detail.jsp").forward(request, response);
	
	}

}
