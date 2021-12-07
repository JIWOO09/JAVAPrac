package com.web.board.model;


import java.sql.Date;

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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
}
