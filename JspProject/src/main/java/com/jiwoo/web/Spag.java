package com.jiwoo.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num %2 == 0)  
			result = "¦��";
		else
			result = "Ȧ��";
		
		//result �� ���
		request.setAttribute("result", result);
		
		//�迭 ���
		String[] names = {"kim","lee"};
		request.setAttribute("names", names);
		
	//Map ��� : Ű�� String ���� �ƹ��ų� �� �Ǵ� Ob
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL �ܼ��ؼ� ���ƿ�");
		request.setAttribute("notice", notice);

		
		
		//redrirect : ���ο� ��û
		//forword : controller�� view�� �մ� ����
		RequestDispatcher dispatcher       //JSP���� Servlet
			= request.getRequestDispatcher("spag.jsp");
		//dispatcher ������ ���� ������ : ��û ������ �����Ѵ�
		dispatcher.forward(request, response); 
					//request : ������ ���迡�� ������ �� �ִ� �����
	}
}
