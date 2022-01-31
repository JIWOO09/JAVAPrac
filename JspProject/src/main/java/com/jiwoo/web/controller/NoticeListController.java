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
import com.jiwoo.web.service.NoticeService;


@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		NoticeService service = new NoticeService();
		//notice 객체가 여러개 필요하기 때문에 
		List<Notice> list = service.getNoticeList();
				
		//전달 전 request에 담기
		request.setAttribute("list", list);
		
		//forward : 작업 이어 받아 화면단과 공유하기
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	}

}
