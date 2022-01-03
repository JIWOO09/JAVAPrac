package com.newjdbc.app.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newjdbc.app.entity.Notice;
import com.newjdbc.app.service.NoticeService;

public class NoticeController {

	//데이터 서비스
	private NoticeService service;
	

	public NoticeController() {
		service = new NoticeService();
	}
	
	//출력 구현하기
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList();
		
		System.out.println("-------------------------------------");
		System.out.printf("<공지사항> 총 %d 게시글\n", 12);
		System.out.println("-------------------------------------");
		
		//반복되는 부분
		for(Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n", 
					    //정수, 문자열, 문자열, 날자 문자열로 변환
				n.getId(), n.getTitle(), n.getWriterid(), n.getRegDate());
		}
		
		System.out.println("-------------------------------------");
		System.out.printf("             %d/%d pages \n", 1, 2);


	}

	public int inputNoticeMenu() {
		//입력 받기 위한 스캐너
		Scanner scan = new Scanner(System.in);
		System.out.printf("1. 상세조회/ 2.이전/ 3.다음/ 4.글쓰기/ 5.종료>");
		String menu_ = scan.nextLine(); //문자열 받기
			//임시변수
		//정수형으로 변경
		int manu = Integer.parseInt(menu_);
		
		return manu;
	}

}
