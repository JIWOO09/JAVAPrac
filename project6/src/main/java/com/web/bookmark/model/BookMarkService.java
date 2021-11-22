package com.web.bookmark.model;

import java.util.List;

public class BookMarkService {
	
	private BookMarkDAO dao;
	
	public BookMarkService() {
		this.dao = new BookMarkDAO();
	}
	
	public boolean isValid(BookMarkDTO dto) {
		return true;
	}
	
	public List<BookMarkDTO> getBookMarkList() {
		dao.select();
		dao.close();
		return null;
	}
	
	public boolean save(BookMarkDTO dto) {
		dao.insert(dto);
		return true;
	}
}

