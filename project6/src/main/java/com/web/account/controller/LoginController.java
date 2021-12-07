package com.web.account.controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.account.model.*;

@WebServlet("/login")

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/WEB-INF/jsp/account/login.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		JoinDTO dto = new JoinDTO(username, password);
		JoinService service = new JoinService(dto);
		
		boolean isRedirect = false;
		switch(service.login()) {
			case 0:
				HttpSession session = request.getSession();
				session.setAttribute("logined", true);
				session.setAttribute("account_data", dto);
				session.setMaxInactiveInterval(60 * 60 * 24 * 7);
				isRedirect = true;
				break;
			case -1:
				request.setAttribute("error", "해당 계정이 존재하지 않습니다.");
				break;
			case -2:
				request.setAttribute("error", "패스워드가 잘못되었습니다.");
				break;
		}
		
		if(isRedirect) {
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			request.getRequestDispatcher(this.view).forward(request, response);
		}
		
	}

}
