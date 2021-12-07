package com.web.account.controller;

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
		
		HttpSession session = request.getSession();
		if(session.getAttribute("logined") != null) {
			session.invalidate();	// 세션 객체 만료
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			session.setAttribute("error", "url_path");
			response.sendRedirect(request.getContextPath() + "/error");
		}
	}

}