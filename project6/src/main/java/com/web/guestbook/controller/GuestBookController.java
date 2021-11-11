package com.web.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.guestbook.model.*;

@WebServlet("/guest")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	//페이지 전달 + 방명록 조회 목록
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		GuestBookService service = new GuestBookService();
						//조회한 테이블 내용이 담긴다.
		request.setAttribute("datas", service.getList()); //view에 전달
		
		
		
		String view = "/WEB-INF/jsp/guestbook/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}
	//저장 처리와 관련 된
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 요청하는거
		//response.setContentType("text/html; charset=utf-8"); //응답하는거
		
		String context = request.getParameter("context"); 
		String ipaddr = request.getRemoteAddr();
		
		GuestBookDTO dto = new GuestBookDTO(ipaddr, context);
		GuestBookService service = new GuestBookService();
		if(service.add(dto)) {
			//참이면 저장 완료
			response.sendRedirect("/guest");
			
		} else {
			//거짓이면 저장 실패
								//"속성명", "속성값"
			request.setAttribute("init", "dto");
			String view = "/WEB-INF/jsp/guestbook/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		
		//콘솔창 확인용
		//System.out.println(context);
		//System.out.println("IP주소 : " + ipaddr);
		
	
	}

}
