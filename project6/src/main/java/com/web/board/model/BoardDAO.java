package com.web.board.model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCloudConnect;

public class BoardDAO {

	OracleCloudConnect occ = null;
	
	public BoardDAO() {
		this.occ = new OracleCloudConnect(true);
	}
	
	public List<BoardDTO> select() {
		List<BoardDTO> datas = new ArrayList<BoardDTO>();
		String query = "SELECT * FROM BOARDS ORDER BY CREATE_DATE, ID";
		try {
			PreparedStatement st = occ.getPstat(query);
			ResultSet rs = occ.select(st);
			while(rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setId(rs.getInt("ID"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				data.setContent(rs.getString("CONTENT"));
				data.setCreateDate(rs.getDate("CREATE_DATE"));
				data.setUpdateDate(rs.getDate("UPDATE_DATE"));
				data.setViewCount(rs.getInt("VIEW_COUNT"));
				data.setGoodCount(rs.getInt("GOOD_COUNT"));
				data.setBadCount(rs.getInt("BAD_COUNT"));
				datas.add(data);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datas;
	}
	
	public List<BoardCategoryDTO> selectCategory() {
		List<BoardCategoryDTO> datas = null;
		
		//조회
		String query = "SELECT * FROM BOARDS_CAT";
		//쿼리 담을 ps 변수선언
		PreparedStatement ps = occ.getPstat(query);
		try {
			ResultSet rs = ps.executeQuery();
			datas = new ArrayList<BoardCategoryDTO>();
			while(rs.next()) {
				BoardCategoryDTO data = new BoardCategoryDTO();
				data.setId(rs.getInt("ID"));
				data.setName(rs.getString("NAME"));
				data.setDisabled(rs.getString("DISABLED").charAt(0));
				datas.add(data);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public void commit() {
		occ.commit();
	}
	
	public void rollback() {
		occ.rollback();
	}
	
	public void close() {
		occ.close();
	}

}