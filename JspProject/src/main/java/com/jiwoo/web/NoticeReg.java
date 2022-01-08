package com.jiwoo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); //����ڿ��� ��������  
		response.setContentType("text/html; charset=UTF-8"); //���� ������ ��� �ؼ��Ұ�����
								//html�� UTF-8�� �ؼ���!
		//request.setCharacterEncoding("UTF-8");
		
		
		PrintWriter out = response.getWriter();
		
		// ������ �� �ޱ�
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		//����ڿ��� �����ֱ�
		out.println(title);
		out.println(content);
	}	
}


