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
		//location="/tmp", 임시 저장 디렉토리 지정 설정안하는게 나음
		fileSizeThreshold=1024*1024, //메모리에 저장되는 임시파일 크기 지정
		maxFileSize=1024*1024*5,//업로드할 1개의 파일 최대크기지정
		maxRequestSize=1024*1024*5*5//request시 최대 크키 지정
		)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//forward : 작업 이어 받아 화면단과 공유하기
		request
		.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//글등록시 값 받기
		String title = request.getParameter("title"); //jsp안의 name
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		boolean pub = false; //기본값
		
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
