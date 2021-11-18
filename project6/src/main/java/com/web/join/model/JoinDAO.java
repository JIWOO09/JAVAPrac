package com.web.join.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspweb.dbconn.OracleCRUD;



public class JoinDAO extends OracleCRUD {

	
	
	public JoinDTO select(String username) {
		String query = "SELECT * FROM MEMBERS"
				+ " WHERE USERNAME = '" + username + "'"; //작은 따옴표 -> SQL '' 넣으려고
		
		JoinDTO data = null;
		try {
			ResultSet res = this.occ.sendQuery(query);
			if(res.next()) {
				data = new JoinDTO( //처음엔 null 데이터 입력시 값 저장
						res.getInt("ID"),
						res.getString("USERNAME"),
						res.getString("PASSWORD"),
						res.getString("EMAIL"));
			} 
			res.close();
			occ.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO select 메서드 동작에 에러 발생");
		}
		return data;
	}
	
	public void close() {
		try {
			occ.connectionClose();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO close 메서드 동작에 에러 발생");
		}
	}

	public boolean insert(JoinDTO dto) {
		String query = "INSERT INTO MEMBERS VALUES("
				+ "MEMBERS_SEQ.NEXTVAL,"
				+ "'" + dto.getUsername() + "',"
				+ "'" + dto.getPassword() + "',"
				+ "'" + dto.getEmail() + "')";
		
		int res = 0;
		
		try {
			res = occ.insertQuery(query);
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO insert 메서드 동작에 에러 발생");
		}
		
		return res == 1 ? true : false;
	}

	public void commit() {
		try {
			occ.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO commit 메서드 동작에 에러 발생");
		}
	}

	public void rollback() {
		try {
			occ.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO rollback 메서드 동작에 에러 발생");
		}
	}

}