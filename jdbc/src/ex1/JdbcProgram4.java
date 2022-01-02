package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JdbcProgram4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//DELETE 쿼리
		
		//변수선언 : 사용자로부터 입력 받은걸 담는 그릇 만들기
		
		int id = 15;
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE NOTICE WHERE ID = ?";
		
		
//		Statement st = con.createStatement(); 쓸경우 쿼리가 이렇게 작성됨
//					" ) VALUES (   " +
//	    			" '"+title+"'," + //변수 넣기
//	    			" 'new1'," + 
//	    			" '내용1111'," +
//	  				" ' ' " +
//	    			" ) " ;
		
		//데이터 가공처리는 SQL에서 하는것 -> 변수 중복 되니 위에는 주석처리
		//String sql = "SELECT * FROM NOTICE WHERE HIT > 10";

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
		
		
		System.out.println(result);
		
		pst.close();
		con.close();
	}
}
