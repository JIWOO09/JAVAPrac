package com.web.account.model;

import com.jspweb.dbconn.*;
import java.sql.*;

import org.apache.ibatis.session.SqlSession;

public class JoinDAO {
    private OracleCloudConnect occ = null;
    private MybatisConnect mc = null;
    private SqlSession sess = null;
    private final String DB = "ACCOUNTS";
    
    public JoinDAO() {
        this.occ = new OracleCloudConnect(true);
        this.mc = new MybatisConnect();
        this.sess = mc.getSession();
    }
    
    // 테이블에 데이터 추가
    public int createAccount(JoinDTO dto) {
    	int res = 0;
    	String q = "INSERT INTO " + DB + " VALUES("
    			+ DB + "_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE)";
    								
    	PreparedStatement st = occ.getPstat(q);
    	try {
    					//물음표 채우기
			st.setString(1, dto.getUsername());
			st.setString(2, dto.getPassword());
			st.setString(3, dto.getEmail());
			//정수는 setInt() , 날짜setDate() -> TO_DATE안해도 됨
			
			res = occ.insert(st);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return res;
    }
    
    // 테이블에서 데이터 검색(계정명으로)
    public JoinDTO findAccount(String username) {
    	
    	JoinDTO res = null;
    	
    	String query = "SELECT * FROM " + DB
    			+ " WHERE USERNAME = ?";
    	
    	PreparedStatement st = occ.getPstat(query);
    	try {
			st.setString(1, username);
			ResultSet rs = occ.select(st);
			if(rs.next()) {
				res = new JoinDTO();
				res.setId(rs.getInt("ID"));
				res.setUsername(rs.getString("USERNAME"));
				res.setPassword(rs.getString("PASSWORD"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return res;
    }
    
    // 테이블에서 데이터 검색(식별값으로)
    public JoinDTO findAccount(int id) {
    	JoinDTO data = this.sess.selectOne("AccountMapper.selectAccount", id);//맵핑 정보 넣기
    	
    	return data;
    	
    }
//    	JoinDTO res = null;
//    	
//    	String query = "SELECT * FROM " + DB
//    			+ " WHERE ID = ?";
//    	
//    	PreparedStatement st = occ.getPstat(query);
//    	try {
//    		st.setInt(1, id);
//    		ResultSet rs = occ.select(st);
//			if(rs.next()) {
//				res = new JoinDTO();
//				res.setId(rs.getInt("ID"));
//				res.setUsername(rs.getString("USERNAME"));
//				res.setPassword(rs.getString("PASSWORD"));
//			}
//			rs.close();
//			st.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//    	
//    	
//    	return res;
    
    
    public int countAccount(JoinDTO dto) {
    	int res = 0;
    	
    	String query = "SELECT COUNT(*) FROM " + DB
    			+ " WHERE USERNAME = ?";
    	PreparedStatement st = occ.getPstat(query);
    	try {
			st.setString(1, dto.getUsername());
			ResultSet rs = occ.select(st);
			if(rs.next()) {
				res = rs.getInt(1);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return res;
    }
    
    // 데이터 수정
    public int updateAccount(JoinDTO dto) {
    	int res = 0;
    	
    	String query = "UPDATE " + DB + " SET"
    			+ " PASSWORD = ?,"
    			+ " EMAIL = ?"
    			+ " WHERE ID = ?";
    	
    	PreparedStatement st = occ.getPstat(query);
    	try {
			st.setString(1, dto.getPassword());
			st.setString(2, dto.getEmail());
			st.setInt(3, dto.getId());
			res = occ.update(st);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
    	
    	return res;
    }
    
    // 로그인 일자를 현재 일자로 수정
    public int updateLoginDate(JoinDTO dto) {
		int res = 0;
		
		String query = "UPDATE " + DB + " SET"
				+ " LOGINDATE = SYSDATE"
				+ " WHERE USERNAME = ?";
		PreparedStatement st = occ.getPstat(query);
		try {
			System.out.println("DAO : " + dto.getUsername());
			st.setString(1, dto.getUsername());
			res = occ.update(st);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
    
    // 데이터 삭제
    public int removeAccount(JoinDTO dto) {
    	int res = 0;
    	String query = "DELETE FROM " + DB
    			+ " WHERE USERNAME = ?"
    			+ " AND ID = ?";
    	
    	PreparedStatement st = occ.getPstat(query);
    	try {
			st.setString(1, dto.getUsername());
			st.setInt(2, dto.getId());
			res = occ.delete(st);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return res;
    }
    
    public void commit() {
    	occ.commit();
    	mc.commit();
    }
    
    public void rollback() {
    	occ.rollback();
    	mc.rollback();
    }
    
    public void close() {
    	occ.close();
    	mc.close();
    }

}