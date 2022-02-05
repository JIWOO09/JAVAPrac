package com.jiwoo.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		//글등록시 문자열값 받기
		String title = request.getParameter("title"); //jsp안의 name
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
		
		//여러개의 파일을 받기 위한 컬랙션(JSP에서 이름은 같아도 됨)
		Collection<Part> parts= request.getParts();
		
		//문자열이 1개이상으로 문자열끼리 연결시킬 때
		StringBuilder builder = new StringBuilder();
				
		
		for(Part p : parts) {
			if(p.getName().equals("file")) continue; //파일이 아니면 빠져나감
		
			//Part는 자료형으로 변수선언
			//Part filePart = request.getPart("file"); -> 단일
			Part filePart = p; //-> 다중
			//파일명 얻기
			String fileName = filePart.getSubmittedFileName();	
			builder.append(fileName); //파일명 들어가고
			builder.append(",");//그 다음 구분자
			
			//InputStream을 통해 얻어서 저장할 수 있다.
			InputStream fis = filePart.getInputStream();
			
			//자바에서 제공하는 API는 절대경로를 써야한다.ex : c:/어쩌고/저쩌고
			//상대경로를 절대경로로 바꿔주는 함수가 RealPath
			String realPath = request.getServletContext().getRealPath("/upload");
			System.out.println(realPath);
					
			
			//realPath을 통해 출력 파일경로 + 자바 제공 경로 구분자 + 파일명
			String filePath = realPath + File.separator + fileName;
			
			//출력 스트림
			FileOutputStream fos = new FileOutputStream(filePath);
			
			//read는 1바이트를 얻어주고 정수형으로 반환
			//int b = fis.read();
			
			//여러개 읽기 위해 반복문, for는 횟수 정해짐, 특정을 찾을 때 까지 while
			byte[] buf = new byte[1024];
				//연산자 != 보다 =이 먼저 될 수 있다 괄호로 묶기
							
			int size = 0;   //buf : 여러개 byte
			while((size = fis.read(buf))!= -1) //-1이 아니라면 계속 반복
				fos.write(buf, 0, size);//0부터 size만큼
			
				fos.close();
				fis.close();
				
			
		}		
		//마지막은 구분자 없게, 글자 길이에서 -1
		builder.delete(builder.length()-1, builder.length());//인덱스로 세기
			
		boolean pub = false; //기본값
		
		if(isOpen != null)
			pub = true;
			
			Notice notice = new Notice();
			notice.setTitle(title);
			notice.setContent(content);
			notice.setPub(pub);
			notice.setWriterid("new1");
			notice.setWriterid(builder.toString());
			
			NoticeService service = new NoticeService();
			int result = service.insertNotice(notice);
			
			response.sendRedirect("list");
		
	}

}
