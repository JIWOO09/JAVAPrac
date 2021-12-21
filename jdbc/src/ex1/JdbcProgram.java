package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcProgram {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE"; //테이블 조회
		
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
		if(rs.next()) { //가져오고 다음 레코드로 커서 이동
			String title = rs.getString("TITLE"); //타이틀 컬럼 주세요
			System.out.println(title);
		}
		//자원 끊을때는 반대로 실행
		rs.close();
		st.close();
		con.close();
	}
}
