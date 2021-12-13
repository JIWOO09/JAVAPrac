package com.web.board.model;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDTO {
	private int id;
	private String title;
	private String writer;
	private String content;
	private Date createDate;
	private Date updateDate;
	private int viewCount;
	private int goodCount;
	private int badCount;
	private int cid;
	
	public BoardDTO() {}
	
	public BoardDTO(int id) {
		this.id = id;
	}
	
	public BoardDTO(String title) {
		this.title = title;
		this.content = " ";
	}
	
	public BoardDTO(String id, String title) {
		this.id = Integer.parseInt(id);
		this.title = title;
		this.content = " ";
	}
	
	public BoardDTO(String bid, String title, String content) {
		this.id = Integer.parseInt(bid);
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public int getViewCount() {
		return viewCount;
	}
	
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	public int getGoodCount() {
		return goodCount;
	}
	
	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}
	
	public int getBadCount() {
		return badCount;
	}
	
	public void setBadCount(int badCount) {
		this.badCount = badCount;
	}

	public void setCid(String type) {
		this.cid = Integer.parseInt(type);
	}
	
	public void setCid(int type) {
		this.cid = type;
	}
	
	public int getCid() {
		return this.cid;
	}
	
	public void setResultSet(ResultSet rs) throws SQLException {
		this.id = rs.getInt("ID");
		this.cid = rs.getInt("CID");
		this.title = rs.getString("TITLE");
		this.writer = rs.getString("WRITER");
		this.content = rs.getString("CONTENT");
		this.createDate = rs.getDate("CREATE_DATE");
		this.updateDate = rs.getDate("UPDATE_DATE");
		this.viewCount = rs.getInt("VIEW_COUNT");
		this.goodCount = rs.getInt("GOOD_COUNT");
		this.badCount = rs.getInt("BAD_COUNT");
	}
}