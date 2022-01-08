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
		
		//null ������ ������ �ʵ���
		//��ȿ���� �ʴ� �ӽú����� ��� (�̸� �ڿ� ����� ���)
		String count_ = request.getParameter("count");
		
		int count = 100;//�⺻�� ����
		//null�� �ƴϸ� | ���ڿ��� �ƴϸ� : �ӽú����� �⺻������ ��ü�Ѵ�.
		if(count_ != null && !count_.equals(""))
			count = Integer.parseInt(count_);
			//�ӽú����� �⺻������ ��ü�Ѵ�.
		
		for(int i = 0; i < count; i++)
		{
		out.println((i+1) + ": �ȳ� Servlet<br>");
		}
	}	
}


