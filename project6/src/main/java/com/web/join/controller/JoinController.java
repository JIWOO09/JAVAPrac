package com.web.join.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.join.model.*;


@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/join/index.jsp";
		//문자열에 대한 읽기전용 뷰
		RequestDispatcher rp = request.getRequestDispatcher(view);
		rp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//콘솔에서 확인
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String password_check = request.getParameter("password_check");
//		String email = request.getParameter("email");
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(password_check);
//		System.out.println(email);
		
		String password_check = request.getParameter("password_check");//이건 살리고
		//위에 코드  아래 코드로 변경 
		//DTO파일 만든 후 객체 생성해서 담기
		JoinDTO dto = new JoinDTO(
				request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("email"));
		
		JoinService service = new JoinService(dto);
		
		request.setAttribute("initData", dto);
		String view = "/WEB-INF/jsp/join/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		
		
		//유효성 검사
		if(service.isValid() == 0) {//유효성 검사에 이상이 없는 경우
			//패스워드 일치 검사
			if(service.equalPassword(password_check)) {
				//동일한 경우
				//아이디 중복 검사
				if(service.isDuplicated()) {
					//중복된 아이디가 있는 경우 다시하세요~ 이동
					//request.setAttribute("initData", dto);
					//String view = "/WEB-INF/jsp/join/index.jsp";
					//RequestDispatcher rp = request.getRequestDispatcher(view);
					rp.forward(request, response);
				} else {
					//중복된 아이디가 없는 경우 만들수있어요!
					service.createJoin(); 
					//로그인 페이지로 이동
					response.sendRedirect("./login");
				}
			} else { //유효성 검사에 이상이 있는 경우
				//동일하지 않을 경우 다시 하세요~~ 이동
				//request.setAttribute("initData", dto);
				//String view = "/WEB-INF/jsp/join/index.jsp";
				//RequestDispatcher rp = request.getRequestDispatcher(view);
				rp.forward(request, response);
			}
		
		} else { // 유효성 검사에 이상이 있는 경우
			rp.forward(request, response);
		}
		
	}

}
