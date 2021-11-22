package com.web.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Cookie[] cookie = request.getCookies();
		
		HttpSession session = request.getSession();//세션객체에 생성된 데이터 삭제
		session.invalidate();//세션 객체 만료
		
			for(Cookie c: cookie) {
				if(c.getName().equals("login_name")) {
					c.setMaxAge(0); //만료시간을 0으로 설정하여 제거하도록 한다.
					response.addCookie(c);
					response.sendRedirect("/");
				}
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
