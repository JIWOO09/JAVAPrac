package com.jiwoo.web.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddCaculate extends HttpServlet {
	
	

	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		String op = request.getParameter("op");
		

		int result = 0;
		
		switch(op) {
			case "+" : 	result = x + y; 
			break;
			case "-" : 	result = x - y; 
			break;
			case "*" : 	result = x * y; 
			break;
			case "/" : 	result = x / y; 
			break;
		}
		
		out.print("°á°ú :" + result);
	}
}
