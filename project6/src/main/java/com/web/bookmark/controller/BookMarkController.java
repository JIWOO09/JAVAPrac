package com.web.bookmark.controller;

import java.io.IOException;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.web.bookmark.model.*;

@WebServlet("/bookmark")
public class BookMarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/bookmark/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String name = request.getParameter("bookmark_name");
		String url = request.getParameter("bookmark_url");
		
		BookMarkDTO dto = new BookMarkDTO(name, url);
		
		BookMarkService service = new BookMarkService();
		
		if(service.isValid(dto)) {
			// 유효성 검사 통과한 경우
			if(service.save(dto)) {
				// 저장이 됐을 경우
			} else {
				// 저장이 안 됐을 경우
			}
		} else {
			// 유효성 검사 실패한 경우
		}
		
	}
}