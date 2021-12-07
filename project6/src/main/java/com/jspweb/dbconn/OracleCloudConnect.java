package com.jspweb.dbconn;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleCloudConnect {
	
								
	//private final String USERNAME = "USER1";
	//private final String PASSWORD = "KHpass123456789";
	//private OracleDataSource ods = null;
	//private Statement stat = null;
				//DB 접속 문자열
	private String url = "";
	private Properties info = new Properties();
	private OracleConnection conn = null;
	private PreparedStatement pstat = null;
	
	
	public OracleCloudConnect() {
		this(false);
	}
			
		
	public OracleCloudConnect(boolean wallet) {
				
				String userHome = System.getProperty("user.home");
				// 사용자 홈 디렉터리 경로를 알아낸다. -> c드라이브 -> 사용자 -> HP
				try {
					info.load(new FileReader(userHome + "/oracle_connect.prop"));
					//info.load(new FileReader("oracle_connect.prop")); 이건 해당 프로젝트 파일안에 있을 때
					
				} catch (FileNotFoundException e) { //파일을 찾을 수 없다는 에러가 발생하면 예외처리
					System.out.println("oracle_connect.prop 파일을 찾을 수 없습니다.");
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();
				}
					
				if(wallet) {
					url = "jdbc:oracle:thin:@mydb_medium?TNS_ADMIN=c:\\Users\\HP\\Wallet_myDB";
					this.walletConnect();
				} else {
					url = "jdbc:oracle:thic:@localhost:1521:xe";
					this.connect();
				}
					
		}	
//					System.out.println("기본 연결 계정을 사용합니다.");
//					info.setProperty("user", "user");
//					info.setProperty("password", "password");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			
			
	private void connect() {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					this.conn = (OracleConnection) DriverManager.getConnection(
							this.url,
							this.info.getProperty("user"),
							this.info.getProperty("password"));
					this.connectSetting();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
	private void walletConnect() {
				try {
					OracleDataSource ods = new OracleDataSource();
					ods.setURL(this.url);
					ods.setConnectionProperties(this.info);
						this.conn = (OracleConnection) ods.getConnection();
						this.connectSetting();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			
	private void connectSetting() {
				try {
					this.conn.setAutoCommit(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			//쿼리문 받아서 
	public ResultSet select(String query) {
				ResultSet rs = null;
				try {
					Statement stat = this.conn.createStatement();
						rs = stat.executeQuery(query);
						stat.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}
				return rs;
		}
			//쿼리문을 ps에 내장시켜서
	public ResultSet select(PreparedStatement ps) {
				ResultSet rs = null;
				try {
					rs = ps.executeQuery();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return rs;
		}
			// PreparedStatement 객체 생성방법
	public PreparedStatement getPstat(String query) {
				try {
					this.pstat = this.conn.prepareStatement(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return this.pstat;
			}
			
	public int insert(String query) {
			int rs = 0;
			try {
				Statement stat = this.conn.createStatement();
					rs = stat.executeUpdate(query);
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rs;
	}
	
	public int insert(PreparedStatement ps) {
			int rs = 0;
			try {
				rs = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rs;
	}
	
	public int update(String query) {
		return this.insert(query);
	}
	
	public int update(PreparedStatement ps) {
		return this.insert(ps);
	}

	
	public int delete(String query) {
		return this.insert(query);
	}
	
	public int delete(PreparedStatement ps) {
		return this.insert(ps);
	}
	
	public void commit() {
			try {
				this.conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void rollback() {
			try {
				this.conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(this.pstat != null) {
				this.pstat.close();
			}
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}

	
//	public OracleCloudConnect () throws SQLException {
//		
//		/* JDBC 사용하여 Oracle Database 연결 하기위한 과정
//		 * 	1. 데이터베이스 연결 구성 정보 생성
//		 * 	2. 연결 구성 정보로 데이터베이스 연결
//		 * 	3. Statement 생성
//		 * 	4. Query 전송
//		 * 	5. 결과 받기
//		 * 	6. 모든 자원 반납 -> close()
//		 */
//		
//		//오라클db에 접속하기 위한 설정
//		//this.info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, USERNAME);
//		//this.info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, PASSWORD);
//		this.ods = new OracleDataSource();
//		this.ods.setURL(DB_URL);
//		this.ods.setConnectionProperties(this.info);
//	}
//	
//	//메서드
//	
//	public void connection() throws SQLException {
//		// OracleDatabase에 접속
//		this.conn = (OracleConnection) ods.getConnection();
//		this.conn.setAutoCommit(false);
//	}
//	
//	public ResultSet sendQuery(String query) throws SQLException {
//		//오라클DB에 접속 후 Query 전송
//		this.stat = this.conn.createStatement();
//		//Statement -> 단한번만 사용하는 정적인 쿼리문을 처리 
//		//Create, Alter, Drop 같은 DDL의 용도로 사용할 경우 
//		//매번 컴파일을 수행해야한다.
//		//쿼리에 인사를 부여 할 수 없다. 쿼리문에 값이 미리 입력 되어있다.
//		return this.stat.executeQuery(query);	// 실행 결과로 ResultSet을 받아온다.;
//	}
//	
//	public int insertQuery(String query) throws SQLException {
//		this.stat = this.conn.createStatement();
//		return this.stat.executeUpdate(query);
//	}
//	
//	public int updateQuery(String query) throws SQLException {
//		return this.insertQuery(query);
//	}
//	
//	public int deleteQuery(String query) throws SQLException {
//		return this.insertQuery(query);
//	}
//	public void close() throws SQLException {
//		//모든 작업 완료 후에는 자원을 반납하기 위해
//		this.stat.close();
//	}
//	
//	public void connectionClose() throws SQLException {
//		//모든 작업 완료 후 연결 끊기 위해
//		this.conn.close();
//	}
//	
//	public void commit() throws SQLException {
//		this.conn.commit();
//	}
//	
//	public void rollback() throws SQLException {
//		this.conn.rollback();
//	}
//	
