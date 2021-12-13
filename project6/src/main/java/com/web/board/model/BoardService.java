package com.web.board.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
	
	public boolean create(BoardDTO dto) {
		boolean res = false;
		BoardDAO dao = new BoardDAO();
		
		if(dto.getId() != 0) {
			switch(dao.update(dto)) {
				case 1:
					res = true; break;
			}
		} else {
			int seq = dao.getSeq();
			dto.setId(seq);
			switch(dao.insert(dto)) {
				case 1:
					res = true; break;
			}
		}
		
		if(res) {
			dao.commit();
		} else {
			dao.rollback();
		}
		
		dao.close();
		return res;
	}
	
	public boolean update(BoardDTO dto) {
		boolean res = false;
		BoardDAO dao = new BoardDAO();
		
		switch(dao.update(dto)) {
			case 1:
				res = true; break;
		}
		
		if(res) {
			dao.commit();
		} else {
			dao.rollback();
		}
		
		dao.close();
		
		return res;
	}

	public List<BoardDTO> getList() {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> datas = dao.select();
		dao.close();
		return datas;
	}
	
	public List<BoardDTO> getList(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(dto.getCid() > 0) {
			paramMap.put("", "");
		}
		if(dto.getTitle() != null) {
			paramMap.put("", "");
		}
		
		List<BoardDTO> datas = dao.selectCategoryType(dto.getCid());
		dao.close();
		return datas;
	}

	public List<BoardCategoryDTO> getCategory() {
		BoardDAO dao = new BoardDAO();
		List<BoardCategoryDTO> datas = dao.selectCategory();
		dao.close();
		return datas;
	}
	
	public BoardDTO getData(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		BoardDTO data = dao.selectOne(dto);
		dao.close();
		
		return data;
	}


}