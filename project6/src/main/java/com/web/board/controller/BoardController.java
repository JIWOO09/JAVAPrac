package com.web.board.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.model.*;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String view = "/WEB-INF/jsp/board/index.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String search = request.getParameter("search");
		//검색 기능 추가하기
		
		BoardService service = new BoardService();
		List<BoardDTO> datas = null;
		if(type == null && search == null) {
			datas = service.getList();
		} else {
			BoardDTO dto = new BoardDTO();
			if(type != null) {
				dto.setCid(type);
			}
			if(search != null) {
				dto.setTitle(search);
			}
			datas = service.getList(dto);
		}
	
		List<BoardCategoryDTO> category = service.getCategory();
		
		//request.setAttribute("type", type); JSP에서 param써서 주석처리
		request.setAttribute("datas", datas);
		
		//카테고리 조회 결과 request에 담아서 보내주기
		request.setAttribute("category", category);
		
		request.getRequestDispatcher(view).forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
