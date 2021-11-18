package com.web.login.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.login.model.*;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/login/index.jsp";
		//문자열에 대한 읽기전용 뷰
		RequestDispatcher rp = request.getRequestDispatcher(view);
		rp.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//로그인 정보 받기
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//위 정보 DTO에 저장
		LoginDTO dto = new LoginDTO(username, password);
		LoginService service = new LoginService(dto);
		
		String view = "/WEB-INF/jsp/login/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
	
		
		//아이디가 있? 없? 체크
		if(service.isExisted()) {
			//있어
			if(service.confirmPassword()) {
				//패스워드 일치
				response.sendRedirect("/");
				} else {
					//패스워스 틀림 -> 포워드 시키기
					request.setAttribute("login_error", "패스워드를 잘못 입력 하였습니다.");
					System.out.println("패스워드를 잘못 입력했습니다.");
					rp.forward(request, response);
			}
		} else {
			//아이디 틀림
			request.setAttribute("login_error", "아이디가 없습니다.");
			System.out.println("해당 아이디가 없습니다.");
			rp.forward(request, response);
		}
	}

}
