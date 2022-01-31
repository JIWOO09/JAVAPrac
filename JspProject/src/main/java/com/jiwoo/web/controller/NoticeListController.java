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
		//notice ��ü�� ������ �ʿ��ϱ� ������ 
		List<Notice> list = service.getNoticeList();
				
		//���� �� request�� ���
		request.setAttribute("list", list);
		
		//forward : �۾� �̾� �޾� ȭ��ܰ� �����ϱ�
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	}

}
