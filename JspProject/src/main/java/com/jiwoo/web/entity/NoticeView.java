package com.jiwoo.web.entity;

import java.util.Date;

public class NoticeView extends Notice {

	
	private int cmtCount;
	
	public int getCmtCount() {
		return cmtCount;
	}
	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}
	public NoticeView() {
	}
	public NoticeView(int id, String title, Date regdate, String writerid, String hit, String files, boolean pub, int cmtCount) {
		super(id, title, regdate, writerid, hit, files, "", pub);
		this.cmtCount = cmtCount;
	}

	

}
