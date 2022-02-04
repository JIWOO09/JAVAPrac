package com.jiwoo.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiwoo.web.entity.Notice;
import com.jiwoo.web.service.NoticeService;

@MultipartConfig(
		//location="/tmp", �ӽ� ���� ���丮 ���� �������ϴ°� ����
		fileSizeThreshold=1024*1024, //�޸𸮿� ����Ǵ� �ӽ����� ũ�� ����
		maxFileSize=1024*1024*5,//���ε��� 1���� ���� �ִ�ũ������
		maxRequestSize=1024*1024*5*5//request�� �ִ� ũŰ ����
		)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//forward : �۾� �̾� �޾� ȭ��ܰ� �����ϱ�
		request
		.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�۵�Ͻ� �� �ޱ�
		String title = request.getParameter("title"); //jsp���� name
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		boolean pub = false; //�⺻��
		
		if(isOpen != null)
			pub = true;
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriterid("new1");
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		response.sendRedirect("list");
		
	}

}
