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
									     //배열 받을때
		String[] num_ = request.getParameterValues("num");
		
		int result = 0;
		
		for(int i = 0; i < num_.length; i++) {
			int num = Integer.parseInt(num_[i]); 
			//반복문 안 변수선언은 반복되지 않는다(지역변수). (단, 연산은 반복)
			result += num;
		}
	
		
		response.getWriter().printf("result is %d\n", result);
		
	}
}
