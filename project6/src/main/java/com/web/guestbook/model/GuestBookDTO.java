package com.web.guestbook.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestBookDTO {

	//데이터베이스 테이블 형태로 작성
	private int id;
	private String ipaddr;
	private String context = "";
	private Date date; //sql Date 불러오기
	
	//생성자
	
	public GuestBookDTO() {}
	
	public GuestBookDTO(String ipaddr, String context) {
		this.ipaddr = ipaddr;
		this.context = context;
	}
	
	//get,set 만들기
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	 public void setId(String id) {
	    	this.id = Integer.parseInt(id);
	    }
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setResultSet(ResultSet res) throws SQLException {
    	this.id = res.getInt("G_ID");
    	this.context = res.getString("G_CONTEXT");
    	this.ipaddr = res.getString("G_IPADDR");
    	this.date = res.getDate("G_DATE");
    }
}
