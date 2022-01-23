package com.jiwoo.web.entity;

import java.util.Date;

//공지사항의 속성들이 담긴 클래스
public class Notice {
	private int id;
	private String title;
	private Date regdate;
	private String writerid;
	private String hit;
	private String files;
	private String content;
	
	//파라미터가 없는 기본생성자
	public Notice() {
	}
	
	//생성자
	public Notice(int id, String title, Date regdate, String writerid, String hit, String files, String content) {
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.writerid = writerid;
		this.hit = hit;
		this.files = files;
		this.content = content;
	}

	
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getWriterid() {
		return writerid;
	}

	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//값 출력
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", regdate=" + regdate + ", writerid=" + writerid + ", hit="
				+ hit + ", files=" + files + ", content=" + content + "]";
	}
	
	


	
}
