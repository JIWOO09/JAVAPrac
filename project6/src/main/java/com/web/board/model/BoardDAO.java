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
	
	public int insert(BoardDTO dto) {
		int res = 0;
		String query = "INSERT INTO BOARDS VALUES("
				+ "?, 1, ?, 'user1', ?, "
				+ "SYSDATE, SYSDATE, 0, 0, 0)";
		PreparedStatement ps = occ.getPstat(query);
		try {
			ps.setInt(1, dto.getId());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			res = occ.insert(ps);
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int update(BoardDTO dto) {
		int res = 0;
		String query = "UPDATE BOARDS SET"
				+ " TITLE = ?,"
				+ " CONTENT = ?"
				+ " WHERE ID = ?";
		PreparedStatement ps = occ.getPstat(query);
		try {
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setInt(3, dto.getId());
			res = occ.update(ps);
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public List<BoardDTO> select() {
		List<BoardDTO> datas = new ArrayList<BoardDTO>();
		String query = "SELECT * FROM BOARDS ORDER BY CREATE_DATE DESC, ID DESC";
		try {
			PreparedStatement st = occ.getPstat(query);
			ResultSet rs = occ.select(st);
			while(rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setResultSet(rs);
				datas.add(data);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datas;
	}

	public BoardDTO selectOne(BoardDTO dto) {
		BoardDTO data = null;
		String query = "SELECT * FROM BOARDS WHERE ID = ?";
		try {
			PreparedStatement st = occ.getPstat(query);
			st.setInt(1, dto.getId());
			
			ResultSet rs = occ.select(st);
			if(rs.next()) {
				data = new BoardDTO();
				data.setResultSet(rs);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public List<BoardDTO> selectCategoryType(int type) {
		List<BoardDTO> datas = new ArrayList<BoardDTO>();
		String query = "SELECT * FROM BOARDS"
				+ " WHERE CID = ?"
				+ " ORDER BY CREATE_DATE DESC, ID DESC";
		try {
			PreparedStatement st = occ.getPstat(query);
			st.setInt(1, type);
			ResultSet rs = occ.select(st);
			while(rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setResultSet(rs);
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
		String query = "SELECT * FROM BOARDS_CAT";
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
	
	public int getSeq() {
		int res = 0;
		String query = "SELECT BOARDS_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement ps = occ.getPstat(query);
		ResultSet rs = occ.select(ps);
		try {
			if(rs.next()) {
				res = rs.getInt(1);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
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