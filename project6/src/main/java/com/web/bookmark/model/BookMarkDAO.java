package com.web.bookmark.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCloudConnect;

public class BookMarkDAO {
	private OracleCloudConnect occ;
	
	public BookMarkDAO() {
		try {
			this.occ = new OracleCloudConnect();
			this.occ.connection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<BookMarkDTO> select() {
		List<BookMarkDTO> datas = new ArrayList<BookMarkDTO>();
		
		String query = "SELECT * FROM BOOKMARK ORDER BY B_ID";
		ResultSet res;
		try {
			res = occ.sendQuery(query);
			while(res.next()) {
				BookMarkDTO dto = new BookMarkDTO();
				dto.setName(res.getString("B_NAME"));
				dto.setUrl(res.getString("B_URL"));
				datas.add(dto);
			}
			res.close();
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datas;
	}
	
	public boolean insert(BookMarkDTO dto) {
		String query = "INSERT INTO BOOKMARK VALUES("
				+ "BOOKMARK_SEQ.NEXTVAL, "
				+ "'" + dto.getName() + "', "
				+ "'" + dto.getUrl() + "')";
		
		int res = 0;
		try {
			res = occ.insertQuery(query);
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res == 1 ? true : false;
	}
	
	public void commit() {
		try {
			occ.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollback() {
		try {
			occ.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			occ.connectionClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
