package com.jiwoo.web.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/admin/index")
public class IndexController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//forward : �۾� �̾� �޾� ȭ��ܰ� �����ϱ�
		request
		.getRequestDispatcher("/WEB-INF/view/admin/index.jsp")
		.forward(request, response);
	}

}
