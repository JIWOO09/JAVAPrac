package com.web.join.model;

public class JoinService {
	JoinDTO dto = null;

	public JoinService() {}
	
	public JoinService(JoinDTO dto) {
		this.dto = dto;
	}
	public int isValid() {
		if(this.dto.getUsername() == null) {
			return -1;
		} else if(this.dto.getPassword() == null) {
			return -2;
		} else if (this.dto.getEmail() == null) {
			return -3;
		}
		
		return 0;
	}
	
	public boolean equalPassword(String password_check) {
		return this.dto.getPassword().equals(password_check);
	}
	
	public boolean isDuplicated() {
		//DAO를 통해 중복체크 
		JoinDAO dao = new JoinDAO();
		JoinDTO data = dao.select(this.dto.getUsername());
		dao.close();
		
		if(data == null) {
			return false; //중복 안됐다.
		} 
			return true; //중복 됐다.
		}
	
	public boolean createJoin() {
		JoinDAO dao = new JoinDAO();
		boolean res = dao.insert(this.dto);
		
		if(res) {
			dao.commit(); //계정생성
		}else {
			dao.rollback();//안되면 롤백
		}
		dao.close();
		
		return res;
	}
	
	
}