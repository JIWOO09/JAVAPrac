package com.web.board.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.web.board.model.*;


@WebServlet("/board/ajax/add")
public class BoardAjaxAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 //request.setCharacterEncoding("utf-8"); 필터 만들었으니까 모든 요청 주석처리
		response.setContentType("application/json; charset=utf-8");
		
		String bid = request.getParameter("bid");
		String title = request.getParameter("title");
		
		if(bid.equals("")) {
			bid = "0";
		}
		
		BoardDTO dto = new BoardDTO(bid, title);
		BoardService service = new BoardService();
		
		boolean res = service.create(dto);
		
		JSONObject json = new JSONObject();
		if(res) {
			json.put("bid", dto.getId());
			json.put("message", "저장됨!");
			json.put("status", "success");
		} else {
			json.put("bid", "");
			json.put("message", "저장실패!");
			json.put("status", "fail");
		}
		
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		out.flush();
	}
}