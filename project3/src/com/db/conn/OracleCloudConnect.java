package com.db.conn;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleCloudConnect {
								//DB 접송 문자열
	private final String DB_URL = "jdbc:oracle:thin:@mydb_medium?TNS_ADMIN=c:\\Users\\HP\\Wallet_myDB";
	//private final String USERNAME = "USER1";
	//private final String PASSWORD = "KHpass123456789";
	private Properties info = new Properties();
	private OracleDataSource ods = null;
	private OracleConnection conn = null;
	private Statement stat = null;

	
	
		// 초기화 블럭
		{
			//String userHome = System.getProperty("user.home");
			// 사용자 홈 디렉터리 경로를 알아낸다.
			//info.load(new FileReader(userHome + "/oracle_connection.prop"));
			//위 방법으로 연결 안되어서 userhome 지우고 나니(주석처리한 코드들) 연결 됨.
			try {
				info.load(new FileReader("oracle_connection.prop"));
				} catch (FileNotFoundException e) { //파일을 찾을 수 없다는 에러가 발생하면 예외처리
					System.out.println("oracle_connection.prop 파일을 찾을 수 없습니다.");
					System.out.println("기본 연결 계정을 사용합니다.");
					info.setProperty("user", "user");
					info.setProperty("password", "password");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	
	
	
	public OracleCloudConnect () throws SQLException {
		
		/* JDBC 사용하여 Oracle Database 연결 하기위한 과정
		 * 	1. 데이터베이스 연결 구성 정보 생성
		 * 	2. 연결 구성 정보로 데이터베이스 연결
		 * 	3. Statement 생성
		 * 	4. Query 전송
		 * 	5. 결과 받기
		 * 	6. 모든 자원 반납 -> close()
		 */
		
		//오라클db에 접속하기 위한 설정
		//this.info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, USERNAME);
		//this.info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, PASSWORD);
		this.ods = new OracleDataSource();
		this.ods.setURL(DB_URL);
		this.ods.setConnectionProperties(this.info);
	}
	
	public void connection() throws SQLException {
		this.conn = (OracleConnection) ods.getConnection();
		
	}
	
	public ResultSet sendQuery(String query) throws SQLException {
		//오라클DB에 접속 후 Query 전송
		this.stat = this.conn.createStatement();
		ResultSet rs = this.stat.executeQuery(query);
			return rs; //실행결과로 ResultSet을 받아온다.
	}
	
	public void close() throws SQLException {
		//모든 작업 완료 후에는 자원을 반납하기 위해
		this.stat.close();
	}
	
	public void connectionClose() throws SQLException {
		//모든 작업 완료 후 연결 끊기 위해
		this.conn.close();
	}
	
	public static void main(String[] args) {
		try {
			//System.out.println("연결 정보 생성 중..");
			OracleCloudConnect occ = new OracleCloudConnect();
			
			//System.out.println("연결 시도 중...");
			occ.connection();
			
			ResultSet res = occ.sendQuery(
					"SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES");
			while(res.next()) {
				System.out.println(res.getInt(1) + " | " + res.getString(2));
								//첫번째 칼럼                     두번째 칼럼
								//ID 타입이 넘버타입이라 int , 네임은 문자열이라 String > 타입 맞추기
			}
				
			//System.out.println("연결 완료!");
			res.close();
			occ.close();
			occ.connectionClose();
			
			//System.out.println("연결 해제!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}