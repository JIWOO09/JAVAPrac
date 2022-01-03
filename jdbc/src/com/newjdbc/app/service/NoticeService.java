package com.newjdbc.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newjdbc.app.entity.Notice;

public class NoticeService {
	private String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String uid = "NEWJDBC";
	private String pwd = "1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	//목록 반환 구조 만들기
	public List<Notice> getList() throws ClassNotFoundException, SQLException{
								//예외 던지기
		String sql = "SELECT * FROM NOTICE"; //테이블 조회
		

		//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
		Class.forName(driver);
		//첫번째 로드 객체 생성
		//메모리상에 드라이버가 올라감
		Connection con = DriverManager.getConnection(url,"uid","pwd");
		//두번째 연결 객체 생성
		//연결 되면 객체 참조
		Statement st = con.createStatement();
		//con으로 이어 받아 세번째 실행 객체 생성
		//사용자로부터 요구 받은 쿼리 실행
		ResultSet rs = st.executeQuery(sql);
		//st으로 이어 받아 네번째 결과 받는 객체 생성
		//레코드 단위로 하나씩 받을 수 있음
		
		
		//반환하기 위한 준비
		List<Notice> list = new ArrayList<Notice>();
		
		
		//반복문 while -> 빈 레코드가 나올 때까지 반복하는 false를 만나면 멈춘다.
		while(rs.next()) { //가져오고 다음 레코드로 커서 이동
			int id = rs.getInt("ID"); //아이디 주세요
			String title = rs.getString("TITLE"); //타이틀 주세요
			String writerid = rs.getString("WRITER_ID");//작성자 주세요
			Date regDate =rs.getDate("REGDATE");//날짜 주세요
			String content = rs.getString("CONTENT"); //내용 주세요
			int hit = rs.getInt("HIT"); //조회수 주세요
			String files = rs.getString("FILES"); //내용 주세요

			//객체 생성
			Notice notice = new Notice(
					id, 
					title, 
					writerid,
					regDate,
					content,
					hit, 
					files);
			
			//목록에 하나씩 담긴다.
			list.add(notice);
			
		
		}
		//자원 끊을때는 반대로 실행
		rs.close();
		st.close();
		con.close();

		return list;
	} 

	
	//3가지 함수 생성 반환은 int형
	public int insert (Notice notice) throws SQLException, ClassNotFoundException {
										//예외던지기
		//notice를 통해 데이터 입력
		String title =notice.getTitle();
		String writerid =notice.getWriterid();
		String content =notice.getContent();
		String files = notice.getFiles() ;
		
		
		String sql = "INSERT INTO notice ( " + 
					    " title," +
					    " writer_id," +
					    " content," +
					    " files" +
					    " ) VALUES (?, ?, ?, ?) " ;

		//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
		Class.forName(driver);
		//첫번째 로드 객체 생성
		//메모리상에 드라이버가 올라감
		Connection con = DriverManager.getConnection(url,"uid","pwd");
		//두번째 연결 객체 생성
		//연결 되면 객체 참조
		
		//Statement st = con.createStatement();
		//con으로 이어 받아 세번째 실행 객체 생성
		//사용자로부터 요구 받은 쿼리 실행
		
		PreparedStatement pst = con.prepareStatement(sql); 
		//미리 쿼리에 값을 넣어 준비해서 바로 쓸 수 있게 
		
		pst.setString(1, title); //앞 숫자리는 넣을 테이터 값 인자들의 갯수 1부터 시작
		pst.setString(2, writerid);
		pst.setString(3, content);
		pst.setString(4, files);
		
		int result = pst.executeUpdate();
		//PreparedStatement는 sql로 넘기면 오류남
		//결과집합이 없는 insert, update, delete 결과가 몇개인지를 반환하는 int를 사용
		
		//ResultSet은 SELECT문에서 사용
		//ResultSet rs = st.executeUpdate(sql);
		//st으로 이어 받아 네번째 결과 받는 객체 생성
		//레코드 단위로 하나씩 받을 수 있음
		
		
		
		pst.close();
		con.close();
		
		return result;
	}

	public int update (Notice notice) throws SQLException, ClassNotFoundException {
		String title = notice.getTitle();
		String content =notice.getContent();
		String files =notice.getFiles();
		int id = notice.getId();
		
		//String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "UPDATE NOTICE "
						+ "SET"
						+ " TITLE =?,"
						+ " CONTENT=?,"
						+ " FILES= ? "
						+ "WHERE ID = ?";


		//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
		Class.forName(driver);
		//첫번째 로드 객체 생성
		//메모리상에 드라이버가 올라감
		Connection con = DriverManager.getConnection(url,"uid","pwd");
		//두번째 연결 객체 생성
		//연결 되면 객체 참조
		
		//Statement st = con.createStatement();
		//con으로 이어 받아 세번째 실행 객체 생성
		//사용자로부터 요구 받은 쿼리 실행
		
		PreparedStatement pst = con.prepareStatement(sql); 
		//미리 쿼리에 값을 넣어 준비해서 바로 쓸 수 있게 
		
		pst.setString(1, title); //앞 숫자리는 넣을 테이터 값 인자들의 갯수 1부터 시작
		pst.setString(2, content);
		pst.setString(3, files);
		pst.setInt(4, id);
		
		int result = pst.executeUpdate();
		//PreparedStatement는 sql로 넘기면 오류남
		//결과집합이 없는 insert, update, delete 결과가 몇개인지를 반환하는 int를 사용
		
		//ResultSet은 SELECT문에서 사용
		//ResultSet rs = st.executeUpdate(sql);
		//st으로 이어 받아 네번째 결과 받는 객체 생성
		//레코드 단위로 하나씩 받을 수 있음
		
				
		pst.close();
		con.close();
		
		return result;
	}
	
	public int delete (int id) throws ClassNotFoundException, SQLException {
		
		//String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE NOTICE WHERE ID = ?";
		

		//총 4개의 객체를 생성해야한다(new로 객체 생성하지 않음) -> 거의 바뀌지 않음 
		Class.forName(driver);
		//첫번째 로드 객체 생성
		//메모리상에 드라이버가 올라감
		Connection con = DriverManager.getConnection(url,"uid","pwd");
		//두번째 연결 객체 생성
		//연결 되면 객체 참조
		
		//Statement st = con.createStatement();
		//con으로 이어 받아 세번째 실행 객체 생성
		//사용자로부터 요구 받은 쿼리 실행
		
		PreparedStatement pst = con.prepareStatement(sql); 
		//미리 쿼리에 값을 넣어 준비해서 바로 쓸 수 있게 
		
	
		pst.setInt(1, id);
		
		int result = pst.executeUpdate();
		//PreparedStatement는 sql로 넘기면 오류남
		//결과집합이 없는 insert, update, delete 결과가 몇개인지를 반환하는 int를 사용
		
		//ResultSet은 SELECT문에서 사용
		//ResultSet rs = st.executeUpdate(sql);
		//st으로 이어 받아 네번째 결과 받는 객체 생성
		//레코드 단위로 하나씩 받을 수 있음
		
			
		pst.close();
		con.close();
		
		return result;
	}
}
