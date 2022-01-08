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
		
		response.setCharacterEncoding("UTF-8"); //사용자에게 보여지는  
		response.setContentType("text/html; charset=UTF-8"); //받은 정보를 어떻게 해석할것인지
								//html을 UTF-8로 해석해!
		//request.setCharacterEncoding("UTF-8");
		
		
		PrintWriter out = response.getWriter();
		
		// 변수에 값 받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		//사용자에게 돌려주기
		out.println(title);
		out.println(content);
	}	
}


