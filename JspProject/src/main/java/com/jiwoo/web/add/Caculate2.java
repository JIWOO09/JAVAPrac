package com.jiwoo.web.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Caculate2 extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		//�ռ� ���� ������ �ӽ� �����
		//��������
		ServletContext application = request.getServletContext();
		
		//���� ��ü ����� ����ȭ�ϱ�
		HttpSession session = request.getSession();
		
		//��Ű
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		int v = 0; //�⺻��
	
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		//�����ڿ� ����
		//����ϱ�
		if(op.equals("=")) { //=�� ������ �����ϸ� ����� ���
					//����Ŭ���� | ����ҿ� ��� �� ��������
			//int x = (Integer)application.getAttribute("value");
			int x = (Integer)session.getAttribute("value");
			int y = v;
			//String operator = (String) application.getAttribute("op"); //���� app ����ҿ��� �о�;��Ѵ�.
			String operator = (String) session.getAttribute("op"); //���� app ����ҿ��� �о�;��Ѵ�.
			
			int result = 0;
				if(operator.equals("+")) //������ + �� ����, - �� ����
					result = x + y;
				else
					result = x - y;
				
				response.getWriter().printf("result is %d\n", result);
		} else {
			//=�� ������ ������ �Է��� �� �����ϱ�
				//���÷���, Ű�� �� | ����ҿ� �� ���
		//application.session.setAttribute("value", v);
		//application.session.setAttribute("op", op);
		session.setAttribute("value", v);
		session.setAttribute("op", op);
		
		}
		
		int result = 0;
	}
}
