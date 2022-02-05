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
		//�۵�Ͻ� ���ڿ��� �ޱ�
		String title = request.getParameter("title"); //jsp���� name
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
		
		//�������� ������ �ޱ� ���� �÷���(JSP���� �̸��� ���Ƶ� ��)
		Collection<Part> parts= request.getParts();
		
		//���ڿ��� 1���̻����� ���ڿ����� �����ų ��
		StringBuilder builder = new StringBuilder();
				
		
		for(Part p : parts) {
			if(p.getName().equals("file")) continue; //������ �ƴϸ� ��������
		
			//Part�� �ڷ������� ��������
			//Part filePart = request.getPart("file"); -> ����
			Part filePart = p; //-> ����
			//���ϸ� ���
			String fileName = filePart.getSubmittedFileName();	
			builder.append(fileName); //���ϸ� ����
			builder.append(",");//�� ���� ������
			
			//InputStream�� ���� �� ������ �� �ִ�.
			InputStream fis = filePart.getInputStream();
			
			//�ڹٿ��� �����ϴ� API�� �����θ� ����Ѵ�.ex : c:/��¼��/��¼��
			//����θ� �����η� �ٲ��ִ� �Լ��� RealPath
			String realPath = request.getServletContext().getRealPath("/upload");
			System.out.println(realPath);
					
			
			//realPath�� ���� ��� ���ϰ�� + �ڹ� ���� ��� ������ + ���ϸ�
			String filePath = realPath + File.separator + fileName;
			
			//��� ��Ʈ��
			FileOutputStream fos = new FileOutputStream(filePath);
			
			//read�� 1����Ʈ�� ����ְ� ���������� ��ȯ
			//int b = fis.read();
			
			//������ �б� ���� �ݺ���, for�� Ƚ�� ������, Ư���� ã�� �� ���� while
			byte[] buf = new byte[1024];
				//������ != ���� =�� ���� �� �� �ִ� ��ȣ�� ����
							
			int size = 0;   //buf : ������ byte
			while((size = fis.read(buf))!= -1) //-1�� �ƴ϶�� ��� �ݺ�
				fos.write(buf, 0, size);//0���� size��ŭ
			
				fos.close();
				fis.close();
				
			
		}		
		//�������� ������ ����, ���� ���̿��� -1
		builder.delete(builder.length()-1, builder.length());//�ε����� ����
			
		boolean pub = false; //�⺻��
		
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
