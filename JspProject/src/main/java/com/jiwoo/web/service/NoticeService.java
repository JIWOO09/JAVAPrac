package com.jiwoo.web.service;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jiwoo.web.entity.Notice;
import com.jiwoo.web.entity.NoticeView;

public class NoticeService {

	//함수메소드는 꼭 반환 타입, 아니면 void
	//클래스는 캡슐화, 제공되는 서비스는 public
	
	//관리자가 쓸 수 있는 메소드 
	//일괄 삭제 모든 아이디니까 배열에 담기
	public int removeNoticeAll(int[] ids){
		return 0;
	}
	//일괄 공개
	public int pubNoticeAll(int[] ids){
		return 0;
	}
	//글 등록					Notice 객체를 전달 받는다
	public int insertNotice(Notice notice){
		return 0;
	}

	//글 삭제
	public int deleteNotice(int id){
		return 0;
	}
	//글 수정저장
	public int updateNotice(Notice notice){
		return 0;
	}
	//최신 공지사항
	List<Notice> getNoticeNewesList(){
		return null;
	}
	
		//List컬랙션을 이용해 Notice를 반환한다
	//공지사항 첫페이지
	public List<NoticeView> getNoticeList() {
		return getNoticeList("title", "", 1);
	}						//field, query,기본 시작page
	
	//페이지 번호 눌렀을 때				페이지 인자 받기
	public List<NoticeView> getNoticeList(int page) {
		return getNoticeList("title", "", page);
							//field, query,page
	}
	
	//메소드 이름이 같은 경우 중복되니까 -> 인자가 많은 메소드만 살려서 구현
	//제목, 이름, 등으로 검색했을 때
	public List<NoticeView> getNoticeList
		(String field/*TITLE, WRITER_ID*/, String query/*A*/, int page) {
		
		//controller에 있던 코드 가져오기
		//notice 객체가 여러개 필요하기 때문에 
		List<NoticeView> list = new ArrayList<>();
		
		//SQL문장을 이걸 쓸것이다
		String sql = "SELECT * FROM (" +
				"	SELECT ROWNUM NUM, N. *" +		//TITLE	  //qeury패턴비교
				"	FROM (SELECT * FROM NOTICE_VIEW_ WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N"+
				"	) " +
				"	WHERE NUM BETWEEN ? AND ? ";
				//1, 11, 21,31 ..->an = 1+(page-1)*10
				//10, 20, 30..->page*10
		
				String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
				
				try {
					//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//첫번째 로드 객체 생성
					//메모리상에 드라이버가 올라감
					Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
					//두번째 연결 객체 생성
					//연결 되면 객체 참조
					//Statement st = con.createStatement();
					//con으로 이어 받아 세번째 실행 객체 생성
					//사용자로부터 요구 받은 쿼리 실행
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, "%"+query+"%");
					st.setInt(2, 1+(page-1)*10);
					st.setInt(3, page*10);
					
					ResultSet rs = st.executeQuery();


									
					while(rs.next()) {
						int id = rs.getInt("ID");
						String title = rs.getString("TITLE");
						Date regdate = rs.getDate("REGDATE");
						String writerid = rs.getString("WRITER_ID");
						String hit = rs.getString("HIT");
						String files = rs.getString("FILES");
						//String content = rs.getString("CONTENT"); 뷰에서 지움
						int cmtCount = rs.getInt("CMT_COUNT");
						
						//notice객체그릇에 데이터(속성들)담기, 생성자와 순서 동일하게
						NoticeView notice = new NoticeView(
											id,
											title,
											regdate,
											writerid,
											hit,
											files,
											//content,
											cmtCount
											);
						list.add(notice);
					
						}
				    	rs.close();
				    	st.close();
				        con.close();
				        
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
				return list;
		
	}
	
	//현재 페이지 알려주는 숫자 1/5 page 이런식
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	//현재 페이지 알려주는 숫자 1/5 page 이런식
	public int getNoticeCount(String field, String query) {
		
		//기본값 설정
		int count = 0;
		
		//SQL문장을 이걸 쓸것이다
		String sql = "SELECT COUNT(ID) COUNT FROM (" +
				"	SELECT ROWNUM NUM, N. *" +
				"	FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N"+
				"	) ";
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//첫번째 로드 객체 생성
			//메모리상에 드라이버가 올라감
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//두번째 연결 객체 생성
			//연결 되면 객체 참조
			//Statement st = con.createStatement();
			//con으로 이어 받아 세번째 실행 객체 생성
			//사용자로부터 요구 받은 쿼리 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			
			ResultSet rs = st.executeQuery();

			if(rs.next())
				//목록이 아닌 집계 카운트값
				count = rs.getInt("count");				
			
		    	rs.close();
		    	st.close();
		        con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//공시사항 자세한 페이지 -> ID로 받기
	public Notice getNotice(int id) {
		
		Notice notice = null;
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//첫번째 로드 객체 생성
			//메모리상에 드라이버가 올라감
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//두번째 연결 객체 생성
			//연결 되면 객체 참조
			//Statement st = con.createStatement();
			//con으로 이어 받아 세번째 실행 객체 생성
			//사용자로부터 요구 받은 쿼리 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			
			
			ResultSet rs = st.executeQuery();


							
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerid = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				//notice객체그릇에 데이터(속성들)담기, 생성자와 순서 동일하게
				notice = new Notice(
									nid,
									title,
									regdate,
									writerid,
									hit,
									files,
									content
									);
				
				}
		    	rs.close();
		    	st.close();
		        con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return notice;
	}
	
	//다음글 -> ID로 받기 : 다음이 뭔지 알아야한다
	//ID가 3인 현재글에서 다음글 가져오기 , 
	//목록은 계속해서 수정되기 때문에 날짜로 기준 잡아서  -> 현재보다 큰 날짜면 ROWNUM1인 다음글 
	public Notice getNextNotice(int id) {
		Notice notice = null;
		String sql = "SELECT * FROM NOTICE WHERE ID = (" +
			    "	SELECT ID FROM NOTICE " +
			    "	WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID =?) " +
			    "	AND ROWNUM = 1 " +
			    "	)";
String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//첫번째 로드 객체 생성
			//메모리상에 드라이버가 올라감
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//두번째 연결 객체 생성
			//연결 되면 객체 참조
			//Statement st = con.createStatement();
			//con으로 이어 받아 세번째 실행 객체 생성
			//사용자로부터 요구 받은 쿼리 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			
			
			ResultSet rs = st.executeQuery();


							
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerid = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				//notice객체그릇에 데이터(속성들)담기, 생성자와 순서 동일하게
				notice = new Notice(
									nid,
									title,
									regdate,
									writerid,
									hit,
									files,
									content
									);
				
				}
		    	rs.close();
		    	st.close();
		        con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return notice;
	}
	//이전글 -> ID로 받기 : 이전이 뭔지 알아야한다
	public Notice gePrevtNotice(int id) {
		Notice notice = null;
		String sql = "SELECT * FROM NOTICE WHERE ID = (" +
				"	SELECT ID FROM NOTICE" +  
			    "	WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID =?)"+
			    "	AND ROWNUM = 1";
		
String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//첫번째 로드 객체 생성
			//메모리상에 드라이버가 올라감
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//두번째 연결 객체 생성
			//연결 되면 객체 참조
			//Statement st = con.createStatement();
			//con으로 이어 받아 세번째 실행 객체 생성
			//사용자로부터 요구 받은 쿼리 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			
			
			ResultSet rs = st.executeQuery();


							
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerid = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				//notice객체그릇에 데이터(속성들)담기, 생성자와 순서 동일하게
				notice = new Notice(
									nid,
									title,
									regdate,
									writerid,
									hit,
									files,
									content
									);
				
				}
		    	rs.close();
		    	st.close();
		        con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return notice;
	}

	public int deleteNoticeAll(int[] ids) {

		//몇개 삭제 했는지
		int result = 0;
		String params = "";
				//ids 갯수만큼 반복
		for(int i = 0; i<ids.length; i++) {
			params += ids[i];
			if(i < ids.length-1)//마지막엔 구분자 안들어감
				params += ",";//구분자
		}								//id 여러개여서 in
		String sql = "SELETE NOTICE WHERE ID IN("+params+")";
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//첫번째 로드 객체 생성
			//메모리상에 드라이버가 올라감
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//두번째 연결 객체 생성
			//연결 되면 객체 참조
			Statement st = con.createStatement();
			//con으로 이어 받아 세번째 실행 객체 생성
			//사용자로부터 요구 받은 쿼리 실행
			//PreparedStatement st = con.prepareStatement(sql);
			
			//ResultSet rs = st.executeQuery();
			result = st.executeUpdate(sql);

		    st.close();
		    con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
