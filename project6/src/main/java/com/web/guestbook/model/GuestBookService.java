package com.web.guestbook.model;

import java.sql.SQLException;
import java.util.List;


public class GuestBookService {
	private GuestBookDAO dao = null;
	
		//필요한 기능 넣기
		//메소드 작성
	public GuestBookService() {
		this.dao = new GuestBookDAO();
	}
	
	
	public boolean add(GuestBookDTO dto) {
		//방명록 추가 데이터 필요
		
		boolean res = dao.insert(dto);
        if(res) {
            dao.commit();
        } else {
            dao.rollback();
        }
        dao.close();
        return res;
    }
	public List<GuestBookDTO> getList() {
    	List<GuestBookDTO> datas = dao.select();
    	dao.close();
        return datas;
    }
    
    public boolean modify(GuestBookDTO dto) {
    	// 1. 기존에 저장된 데이터를 조회해야 한다.
    	// 2. 조회한 데이터에 수정된 데이터로 교체한다.
    	// 3. 교체된 데이터로 저장.
    	GuestBookDTO data = getData(dto.getId());
    	data.setContext(dto.getContext());
    	return update(data);
    }
    
    public boolean delete(GuestBookDTO dto) {
    	//1. 기존에 저장된 데이터를 조회한다.
    	//2. 조회된 데이터를 확인 후 삭제
    	GuestBookDTO data = getData(dto.getId());
    	dao = new GuestBookDAO();
    	boolean res = false;
    	if(data.getId() != 0) { //데이터가 0이 아닐때 
    		res = dao.delete(data);
    	}
    	if(res) {
    		dao.commit();
    	} else {
    		dao.rollback();
    	}
    	dao.close();
    	return res;
    }
    
    public GuestBookDTO getData(int id) {
    	dao = new GuestBookDAO();
    	GuestBookDTO data = dao.select(id);
    	dao.close();
    	return data;
    }
    
    private boolean update(GuestBookDTO dto) {
    	dao = new GuestBookDAO();
    	boolean res = dao.update(dto);
    	 
    	if(res) {
    		dao.commit();
    	} else {
    		dao.rollback();
    	}
    	
    	dao.close();
    	return res;
    }


	
}
