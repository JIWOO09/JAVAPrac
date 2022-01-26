package com.jiwoo.web.service;

import java.util.List;

import com.jiwoo.web.entity.Notice;

public class NoticeService {

	//함수메소드는 꼭 반환 타입, 아니면 void
	//클래스는 캡슐화, 제공되는 서비스는 public
	
		//List컬랙션을 이용해 Notice를 반환한다
	//공지사항 첫페이지
	public List<Notice> getNoticeList() {
		return getNoticeList("title", "", 1);
	}						//field, query,기본 시작page
	
	//페이지 번호 눌렀을 때				페이지 인자 받기
	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title", "", page);
							//field, query,page
	}
	
	//메소드 이름이 같은 경우 중복되니까 -> 인자가 많은 메소드만 살려서 구현
	//제목, 이름, 등으로 검색했을 때
	public List<Notice> getNoticeList(String field, String query, int page) {
		
		//SQL문장을 이걸 쓸것이다
		String sql = "SELECT * FROM (" +
				"	SELECT ROWNUM NUM, N. *" +
				"	FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N"+
				"	) " +
				"	WHERE NUM BETWEEN 6 AND 10; ";
		
		return null;
	}
	
	//현재 페이지 알려주는 숫자 1/5 page 이런식
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	//현재 페이지 알려주는 숫자 1/5 page 이런식
	public int getNoticeCount(String field, String query) {
		//SQL문장을 이걸 쓸것이다
		String sql = "SELECT * FROM (" +
				"	SELECT ROWNUM NUM, N. *" +
				"	FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N"+
				"	) " +
				"	WHERE NUM BETWEEN 6 AND 10;";
		return 0;
	}
	
	//공시사항 자세한 페이지 -> ID로 받기
	public Notice getNotice(int id) {
		String sql = "SELECT * FROM nOTICE WHERE ID=?";
		
		return null;
	}
	
	//다음글 -> ID로 받기 : 다음이 뭔지 알아야한다
	//ID가 3인 현재글에서 다음글 가져오기 , 
	//목록은 계속해서 수정되기 때문에 날짜로 기준 잡아서  -> 현재보다 큰 날짜면 ROWNUM1인 다음글 
	public Notice getNextNotice(int id) {
		String sql = "SELECT * FROM NOTICE WHERE ID = (" +
			    "	SELECT ID FROM NOTICE " +
			    "	WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID =13) " +
			    "	AND ROWNUM = 1 " +
			    "	)";
		return null;
	}
	//이전글 -> ID로 받기 : 이전이 뭔지 알아야한다
	public Notice gePrevtNotice(int id) {
		String sql = "SELECT * FROM NOTICE WHERE ID = (" +
				"	SELECT ID FROM NOTICE" +  
			    "	WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID =13)"+
			    "	AND ROWNUM = 1";
		return null;
	}
	
	
}
