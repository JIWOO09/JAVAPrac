package com.web.error.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view ="/WEB-INF/jsp/error/index.jsp";
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String code = request.getParameter("code");
		
		switch(code) {
			case "100001" :
				request.setAttribute("error_title", "잘못된 접근");
				request.setAttribute("error_msg", "이미 로그인 되어 있습니다.");
				break;
			default :
				request.setAttribute("error_title", "알 수 없음");
				request.setAttribute("error_msg", "에러가 정의 되어 있지 않습니다..");
				
		}
		
			request.getRequestDispatcher(view);
	}

}
