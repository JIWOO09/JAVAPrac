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
		
		response.setCharacterEncoding("UTF-8"); //사용자에게 보여지는  
		response.setContentType("text/html; charset=UTF-8"); //받은 정보를 어떻게 해석할것인지
								//html을 UTF-8로 해석해!
		PrintWriter out = response.getWriter();
		
		//null 에러가 나오지 않도록
		//유효하지 않는 임시변수에 담기 (이름 뒤에 언더바 사용)
		String count_ = request.getParameter("count");
		
		int count = 100;//기본값 셋팅
		//null이 아니면 | 빈문자열이 아니면 : 임시변수를 기본값으로 대체한다.
		if(count_ != null && !count_.equals(""))
			count = Integer.parseInt(count_);
			//임시변수를 기본값으로 대체한다.
		
		for(int i = 0; i < count; i++)
		{
		out.println((i+1) + ": 안녕 Servlet<br>");
		}
	}	
}


