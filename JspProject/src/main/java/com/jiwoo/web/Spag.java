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
			result = "짝수";
		else
			result = "홀수";
		
		//result 값 담기
		request.setAttribute("result", result);
		
		//배열 담기
		String[] names = {"kim","lee"};
		request.setAttribute("names", names);
		
	//Map 담기 : 키는 String 값는 아무거나 다 되는 Ob
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL 단순해서 좋아요");
		request.setAttribute("notice", notice);

		
		
		//redrirect : 새로운 요청
		//forword : controller와 view를 잇는 역할
		RequestDispatcher dispatcher       //JSP지만 Servlet
			= request.getRequestDispatcher("spag.jsp");
		//dispatcher 변수를 통해 포워드 : 요청 응답을 공유한다
		dispatcher.forward(request, response); 
					//request : 포워드 관계에서 공유할 수 있는 저장소
	}
}
