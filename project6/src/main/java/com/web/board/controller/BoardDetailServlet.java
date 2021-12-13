package com.web.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.model.BoardDTO;
import com.web.board.model.BoardService;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/WEB-INF/jsp/board/detail.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("id");
		
		BoardDTO dto = new BoardDTO(Integer.parseInt(bid));
		BoardService service = new BoardService();
		
		dto = service.getData(dto);
		System.out.println(dto.getContent());
		request.setAttribute("data", dto);
		request.getRequestDispatcher(view).forward(request, response);
	}

}