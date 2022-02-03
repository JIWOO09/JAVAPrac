package com.jiwoo.web.controller.admin.notice;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiwoo.web.entity.Notice;
import com.jiwoo.web.entity.NoticeView;
import com.jiwoo.web.service.NoticeService;


@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list.jsp���� ������ post�� �ޱ�
		//Ű�� �� ���� ���� �ٸ��� �迭��
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		
		//Ŭ���� ��ư�� ���� ��� �ٸ���
		switch(cmd) {
		case "�ϰ�����" :
			for(String openId : openIds)
			System.out.printf("open id : %s\n", openId);
			break;
		case "�ϰ�����" : 
			//����� Service�� ��Ź
			NoticeService service = new NoticeService();
			//id�� ���������� �Ǿ������� String���� ������ �迭�� �ٲٱ�
			int[] ids = new int[delIds.length];
			for(int i = 0; i < delIds.length; i++)
					ids[i] = Integer.parseInt(delIds[i]);
			
			//���� �� ���� �����޴�
			int result = service.deleteNoticeAll(ids);
			break;
		}
		
		//post ���� �� ����� ��Ϸ� �ٽ� ���ư� �� �ֵ��� 
		response.sendRedirect("list");
	}
	
	//404 : url����
	//405 : �޼ҵ� ���� (get, post)
	//403 : ����(����) ����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		//���� NULL�϶�, �ִ��� ������ �𸦶� �ӽú���_�� ��Ƴ���
		//����� ��û �ޱ�
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		//������ �غ��� ���� int�� �ƴ� String : int�� �� ��� null�� ���� �� ���⶧����
		String page_ = request.getParameter("p");
		
		//������ �⺻������ ����ϰ� ����ó��
		String field ="title"; //���ڿ��� �ƴѰ�
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		//������ �Է� �޾ƾ��ϴϱ� ���ڿ�
		String query =""; //���ڿ��� �ƴѰ�
		if(query_ != null&& !query_.equals(""))
			query = query_;
		
		int page = 1; //���ڿ��� �ƴѰ�
		if(page_ != null&& !page_.equals(""))
			page = Integer.parseInt(page_);
		
		NoticeService service = new NoticeService();
		//notice ��ü�� ������ �ʿ��ϱ� ������ 						//1�̿����� ����
		List<NoticeView> list = service. getNoticeList(field, query, page);
		
		//DB�� ���ڵ� ������ �����
		int count = service.getNoticeCount();
		
		//���� �� request�� ���
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		//forward : �۾� �̾� �޾� ȭ��ܰ� �����ϱ�
		request
		.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp")
		.forward(request, response);
	}

}
