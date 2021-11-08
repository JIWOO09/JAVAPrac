package com.db.conn;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleCloudConnect {
	private final String DB_URL = "jdbc:oracle:thin:@mydb_medium?TNS_ADMIN=C:\\Users\\HP\\Wallet_myDB";
	private Properties info = new Properties();
	private OracleDataSource ods = null;
	private OracleConnection conn = null;
	private Statement stat = null;
	
	// 초기화 블럭
	{
		// 사용자 홈 디렉터리 경로를 알아낸다.
		//String userHome = System.getProperty("user.home");
		try {
			info.load(new FileReader("oracle_connection.prop"));
		} catch (FileNotFoundException e) {
			System.out.println("oracle_connection.prop 파일을 찾을 수 없습니다.");
			System.out.println("기본 연결 계정을 사용합니다.");
			info.setProperty("user", "user");
			info.setProperty("password", "password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public OracleCloudConnect() throws SQLException {
		/* JDBC 사용하여 Oracle Database 연결 하기위한 과정
		 * 	1. 데이터베이스 연결 구성 정보 생성
		 * 	2. 연결 구성 정보로 데이터베이스 연결
		 * 	3. Statement 생성
		 * 	4. Query 전송
		 * 	5. 결과 받기
		 * 	6. 모든 자원 반납 -> close()
		 */
		
		// OracleDatabase에 접속하기 위한 설정
		this.ods = new OracleDataSource();
		this.ods.setURL(DB_URL);
		this.ods.setConnectionProperties(this.info);
	}
	
	public void connection() throws SQLException {
		// OracleDatabase에 접속
		this.conn = (OracleConnection) ods.getConnection();
	}
	
	public ResultSet sendQuery(String query) throws SQLException {
		// OracleDatabase에 접속 후 Query 전송
		this.stat = this.conn.createStatement();
		return this.stat.executeQuery(query);	// 실행 결과로 ResultSet을 받아온다.;
	}
	
	public void close() throws SQLException {
		// 모든 작업을 완료 후에는 자원을 반납 하기위해 close();
		this.stat.close();
	}
	
	public void connectionClose() throws SQLException {
		// 모든 작업을 완료한 후에는 연결을 끊기 위해 close();
		this.conn.close();
	}
	
	public static void main(String[] args) {
		try {
			OracleCloudConnect occ = new OracleCloudConnect();

			occ.connection();
			
			ResultSet res = occ.sendQuery(
					"SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES");
			while(res.next()) {
				System.out.println(res.getInt(1) + " | " + res.getString(2));
			}
			
			res.close();
			occ.close();
			occ.connectionClose();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}