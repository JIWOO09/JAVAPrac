package com.web.login.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.jspweb.dbconn.OracleCRUD;


public class LoginDAO extends OracleCRUD {


	
	public LoginDTO select(String username) {
		String query = "SELECT * FROM MEMBERS"
				+ " WHERE USERNAME = '" + username + "'"; //작은 따옴표 -> SQL '' 넣으려고
		
		LoginDTO data = null;
		try {
			ResultSet res = this.occ.sendQuery(query);
			
			if(res.next()) {
				data = new LoginDTO( //처음엔 null 데이터 입력시 값 저장
	
						res.getString("USERNAME"),
						res.getString("PASSWORD"));
			}
			res.close();
			occ.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return data;
	}
	
}
