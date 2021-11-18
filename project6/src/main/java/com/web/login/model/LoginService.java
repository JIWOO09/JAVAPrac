package com.web.login.model;

public class LoginService {
	private LoginDTO dto = null;
	
	public LoginService(LoginDTO dto) {
		this.dto = dto;
	}

	public boolean isExisted() {
		LoginDAO dao = new LoginDAO();
		LoginDTO data = dao.select(dto.getUsername());
		dao.close();
		//데이터 있?없?
		//if(data != null) {
			//return true;
		//}else {
			//return false;
		return data != null ? true : false; 
		
	}

	public boolean confirmPassword() {
		LoginDAO dao = new LoginDAO();
		LoginDTO data = dao.select(dto.getUsername());
		dao.close();
	
		//비밀번호 맞?
	if(data != null) {
		if(data.getPassword().equals(this.dto.getPassword())) {
			return true;
			}
		}
	return false;
	
	}
}
