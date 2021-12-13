package com.web.board.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.model.*;


@WebServlet("/board/add")
public class BoardAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/WEB-INF/jsp/board/add.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher(view).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bid = request.getParameter("bid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO(bid, title, content);
		BoardService service = new BoardService();
		
		boolean res = service.update(dto);
		if(res) {
			response.sendRedirect(request.getContextPath() + "/board");
		} else {
			doGet(request, response);
		}
	}
}


