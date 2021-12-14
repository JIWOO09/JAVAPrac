package com.web.main.controller;

import java.io.IOException;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.account.model.*;


@WebServlet("")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/WEB-INF/jsp/index.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(view).forward(request, response);
		
//		JoinDAO dao = new JoinDAO();
//		JoinDTO data = new JoinDTO();
//		System.out.println("id : " + data.getId());
//		System.out.println("username : " + data.getUsername());
//		System.out.println("password : " + data.getPassword());
//		System.out.println("email : " + data.getEmail());
//		System.out.println("joindate : " + data.getJoinDate());
//		System.out.println("logindate : " + data.getLoginDate());
//		dao.close();
	}
}