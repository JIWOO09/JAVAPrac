package com.jiwoo.web.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class AddCaculate2 extends HttpServlet {
	
	

	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
									     //�迭 ������
		String[] num_ = request.getParameterValues("num");
		
		int result = 0;
		
		for(int i = 0; i < num_.length; i++) {
			int num = Integer.parseInt(num_[i]); 
			//�ݺ��� �� ���������� �ݺ����� �ʴ´�(��������). (��, ������ �ݺ�)
			result += num;
		}
	
		
		response.getWriter().printf("result is %d\n", result);
		
	}
}