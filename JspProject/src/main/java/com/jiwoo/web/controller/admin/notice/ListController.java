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
		//list.jsp에서 보내는 post값 받기
		//키가 다 같고 값은 다르면 배열로
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		
		//클릭한 버튼에 따른 결과 다르게
		switch(cmd) {
		case "일괄공개" :
			for(String openId : openIds)
			System.out.printf("open id : %s\n", openId);
			break;
		case "일괄삭제" : 
			//기능은 Service에 부탁
			NoticeService service = new NoticeService();
			//id가 정수형으로 되어있으니 String에서 정수형 배열로 바꾸기
			int[] ids = new int[delIds.length];
			for(int i = 0; i < delIds.length; i++)
					ids[i] = Integer.parseInt(delIds[i]);
			
			//삭제 된 갯수 돌려받는
			int result = service.deleteNoticeAll(ids);
			break;
		}
		
		//post 끝난 후 사용자 목록로 다시 돌아갈 수 있도록 
		response.sendRedirect("list");
	}
	
	//404 : url오류
	//405 : 메소드 오류 (get, post)
	//403 : 권한(보안) 오류
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		//값이 NULL일때, 있는지 없는지 모를때 임시변수_에 담아놓기
		//사용자 요청 받기
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		//페이지 준비할 때는 int가 아닌 String : int로 할 경우 null를 받을 수 없기때문에
		String page_ = request.getParameter("p");
		
		//제목을 기본값으로 사용하고 조건처리
		String field ="title"; //빈문자열이 아닌것
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		//쿼리는 입력 받아야하니까 빈문자열
		String query =""; //빈문자열이 아닌것
		if(query_ != null&& !query_.equals(""))
			query = query_;
		
		int page = 1; //빈문자열이 아닌것
		if(page_ != null&& !page_.equals(""))
			page = Integer.parseInt(page_);
		
		NoticeService service = new NoticeService();
		//notice 객체가 여러개 필요하기 때문에 						//1이였던걸 수정
		List<NoticeView> list = service. getNoticeList(field, query, page);
		
		//DB에 레코드 갯수가 몇개인지
		int count = service.getNoticeCount();
		
		//전달 전 request에 담기
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		//forward : 작업 이어 받아 화면단과 공유하기
		request
		.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp")
		.forward(request, response);
	}

}

