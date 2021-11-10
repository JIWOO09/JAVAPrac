package com.web.guestbook.model;

import java.sql.SQLException;
import java.util.List;

public class GuestBookService {
	
	//필요한 기능 넣기
	//메소드 작성
	public boolean add(GuestBookDTO dto) {
		//방명록 추가 데이터 필요
		
		GuestBookDAO dao = null;
		try {
			dao = new GuestBookDAO();
			if(dao.insert(dto)) {
				dao.commit();
				return true;
		} else {
			dao.rollback();
			return false;

		}
	} catch (SQLException e){
			e.printStackTrace();
			
		}
		return false;
	}
	
	public List<GuestBookDTO> getList() {
		//조회 목록 뽑아내고 결과 돌려주기
		return null;
	}
	
	

}
