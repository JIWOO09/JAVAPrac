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
		//앞서 받은 값들의 임시 저장소
		//전역변수
		ServletContext application = request.getServletContext();
		
		//세션 객체 만들고 변수화하기
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		int v = 0; //기본값
	
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		//연산자에 따라
		//계산하기
		if(op.equals("=")) { //=이 나오면 연산하면 결과값 출력
					//래퍼클래스 | 저장소에 담긴 값 꺼내오기
			//int x = (Integer)application.getAttribute("value");
			int x = (Integer)session.getAttribute("value");
			int y = v;
			//String operator = (String) application.getAttribute("op"); //위에 app 저장소에서 읽어와야한다.
			String operator = (String) session.getAttribute("op"); //위에 app 저장소에서 읽어와야한다.
			
			int result = 0;
				if(operator.equals("+")) //연산자 + 면 덧셈, - 면 뺄셈
					result = x + y;
				else
					result = x - y;
				
				response.getWriter().printf("result is %d\n", result);
		} else {
			//=이 나오기 전까지 입력한 값 저장하기
				//맵컬랙션, 키와 값 | 저장소에 값 담기
		session.setAttribute("value", v);
		session.setAttribute("op", op);
		
		}
		
		int result = 0;
	}
}
