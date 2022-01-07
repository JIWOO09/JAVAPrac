package com.jiwoo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Example extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); //����ڿ��� ��������  
		response.setContentType("text/html; charset=UTF-8"); //���� ������ ��� �ؼ��Ұ�����
								//html�� UTF-8�� �ؼ���!
		PrintWriter out = response.getWriter();
		for(int i = 0; i < 100; i++)
		{
		out.println((i+1) + ": �ȳ� Servlet<br>");
		}
	}	
}


