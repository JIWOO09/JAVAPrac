package com.newjdbc.app.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newjdbc.app.entity.Notice;
import com.newjdbc.app.service.NoticeService;

public class NoticeController {

	//전역 변수
	//데이터 서비스
	private NoticeService service;
	
	//페이지의 현 상태 변수
	private int page;

	private String searchWord;
	private String searchField;

	//게시글의 갯수
	//private int count;
	
	//멤버 변수
	public NoticeController() {
		service = new NoticeService();
		page = 1;
		searchField ="TITLE";
		searchWord = "";
		
		//count = 0;
	}
	
	//지역 변수
	//출력 구현하기
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(page, searchField, searchWord);
		
		//list를 구할 때 마다 값이 다름 -> 전역이 아닌 지역변수로
		int count = service.getCount();
		int lastPage = count/10; //정확하게 떨어지는 경우 100개 -> 마지막 페이지 10, 90 -> 9
		lastPage = count%10>0?lastPage+1:lastPage;
		//나머지가 생기는 경우 잘리지 않게 나머지가 있을 경우 0보다 크다면 +1, 없다면
		
		
		System.out.println("-------------------------------------");
		System.out.printf("<공지사항> 총 %d 게시글\n", count);
		System.out.println("-------------------------------------");
		
		//반복되는 부분
		for(Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n", 
					    //정수, 문자열, 문자열, 날자 문자열로 변환
				n.getId(), n.getTitle(), n.getWriterid(), n.getRegDate());
		}
		
		System.out.println("-------------------------------------");
		System.out.printf("             %d/%d pages \n", page, lastPage);


	}

	public int inputNoticeMenu() {
		//입력 받기 위한 스캐너
		Scanner scan = new Scanner(System.in);
		System.out.printf("< 1. 상세조회 | 2.이전 | 3.다음 | 4.글쓰기 | 5.검색 | 6.종료 >");
		String menu_ = scan.nextLine(); //문자열 받기
			//임시변수
		//정수형으로 변경
		int manu = Integer.parseInt(menu_);
		
		return manu;
	}
	//이전, 다음  메소드
	public void movePrevList() {
		if(page == 1) {
			System.out.println("================");
			System.out.println("이전 페이지가 없습니다.");
			System.out.println("================");

		return;
		}
		page--;
	}

	//지역변수
	public void moveNextList() throws ClassNotFoundException, SQLException {
		//위 지역변수에서 쓴 코드 다시 가져와서 쓰기
		int count = service.getCount();
		int lastPage = count/10; //정확하게 떨어지는 경우 100개 -> 마지막 페이지 10, 90 -> 9
		lastPage = count%10>0?lastPage+1:lastPage;
		//나머지가 생기는 경우 잘리지 않게 나머지가 있을 경우 0보다 크다면 +1, 없다면
		if(page == lastPage) {
			System.out.println("================");
			System.out.println("다음 페이지가 없습니다.");
			System.out.println("================");
		return;
		}
		page++;
	}

	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 범주(title, content,writerid)중 하나를 입력하세요.");
		System.out.println(" > ");
		searchField = scan.nextLine();
		
		System.out.println("검색어 > ");
		searchWord = scan.nextLine();
	}

}
