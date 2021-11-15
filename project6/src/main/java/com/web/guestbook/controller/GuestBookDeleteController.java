package com.web.guestbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.guestbook.model.GuestBookDTO;
import com.web.guestbook.model.GuestBookService;

@WebServlet("/guest/delete")
public class GuestBookDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		String id = request.getParameter("id");
		
		GuestBookService service = new GuestBookService();
		GuestBookDTO dto = new GuestBookDTO();
		dto.setId(id);
		
		if(service.delete(dto)) {
			response.sendRedirect("../guest");
		} else {
			response.sendRedirect("../guest");
		}
	}

}
