package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JdbcProgram {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		//String sql = "SELECT * FROM NOTICE"; //테이블 조회
		
		//데이터 가공처리는 SQL에서 하는것 -> 변수 중복 되니 위에는 주석처리
		String sql = "SELECT * FROM NOTICE WHERE HIT > 10";

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
		ResultSet rs = st.executeQuery(sql);
		//st으로 이어 받아 네번째 결과 받는 객체 생성
		//레코드 단위로 하나씩 받을 수 있음
		
		
		//오류를 발생하지 않으려면 if문
//		if(rs.next()) { //가져오고 다음 레코드로 커서 이동
//			int id = rs.getInt("Id"); //아이디 주세요
//			String title = rs.getString("TITLE"); //타이틀 주세요
//			String writerid = rs.getString("WRITER_ID");//작성자 주세요
//			Date regDate =rs.getDate("REGDATE");//날짜 주세요
//			String content = rs.getString("CONTENT"); //내용 주세요
//			int hit = rs.getInt("HIT"); //추천수 주세요
//			
//			System.out.printf("id: %d, title :%s, writerid: %s,regDate: %s, content: %s, hit: %d\n",
//								id, title, writerid, regDate, content, hit);
//		}
		
		//반복문 while -> 빈 레코드가 나올 때까지 반복하는 false를 만나면 멈춘다.
		while(rs.next()) { //가져오고 다음 레코드로 커서 이동
			int id = rs.getInt("Id"); //아이디 주세요
			String title = rs.getString("TITLE"); //타이틀 주세요
			String writerid = rs.getString("WRITER_ID");//작성자 주세요
			Date regDate =rs.getDate("REGDATE");//날짜 주세요
			String content = rs.getString("CONTENT"); //내용 주세요
			int hit = rs.getInt("HIT"); //조회수 주세요
			
			//조회수가 10인 이상만 출력
			//내가 풀어본것 if(rs.getInt(hit) >= 10) {
			
			
			System.out.printf("id: %d, title :%s, writerid: %s,regDate: %s, content: %s, hit: %d\n",
								id, title, writerid, regDate, content, hit);
		
		}
		//자원 끊을때는 반대로 실행
		rs.close();
		st.close();
		con.close();
	}
}
