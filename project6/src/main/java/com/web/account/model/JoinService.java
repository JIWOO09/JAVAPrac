package com.web.account.model;

import java.util.regex.*;

import java.security.*;

public class JoinService {
    private JoinDTO dto;
    
    public JoinService(JoinDTO dto) {
        this.dto = dto;
    }
    
    // 회원가입
    public boolean join() {
    	if(this.dto == null) {
    		return false;
    	}
    	
    	JoinDAO dao = new JoinDAO();
    	int res = dao.createAccount(this.dto);
    	if(res == 1) {
    		dao.commit();
    		dao.close();
    		return true;
    	}
    	dao.rollback();
    	dao.close();
    	return false;
    }
    
    public int login() {
    	JoinDAO dao = new JoinDAO();
    	JoinDTO data = null;
    	
    	// 계정 존재 유무 확인
    	if(isExisted()) {
    		if(checkPassword()) {
    			// 로그인 시간 업데이트
    			dao.updateLoginDate(this.dto);
    			
    			// 계정 정보 불러오기
    			data = dao.findAccount(this.dto.getUsername());
    			
    			// 계정 정보를 DTO 에 담기
    			dto.setId(data.getId());
    			dto.setPassword("");
    			dto.setEmail(data.getEmail());
    			dto.setJoinDate(data.getJoinDate());
    			dto.setLoginDate(data.getLoginDate());
    			
    			dao.commit();
    			dao.close();
    			return 0;
    		}
    		dao.close();
    		return -2;
    	}
    	dao.close();
    	return -1;
    }
    
    private boolean isExisted() {
    	JoinDAO dao = new JoinDAO();
    	int res = dao.countAccount(this.dto);
    	dao.close();
    	
    	return res == 1 ? true : false;
    }
    
    private boolean checkPassword() {
    	JoinDAO dao = new JoinDAO();
    	JoinDTO data = dao.findAccount(dto.getUsername());
    	dao.close();
    	
    	String dbasePass = data.getPassword();
    	String inputPass = this.dto.getPassword();
    	
    	return dbasePass.equals(inputPass);
    }
    
    // 회원정보 변경
    public boolean change() {
    	
    	return false;
    }
    
    // 회원가입 정보 유효성 확인
    public boolean isValid() {
    	if(this.dto == null) {
    		return false;
    	}
    	
    	if(!usernameValid() || !passwordValid()) {
    		return false;
    	}
    	
    	return true;
    }
    
    // 계정명 유효성 체크
    private boolean usernameValid() {
    	String regex = "^[A-Za-z0-9]{4,12}$";
    	boolean res = Pattern.matches(regex, this.dto.getUsername());
        return res;
    }
    
    // 패스워드 유효성 체크
    private boolean passwordValid() {
    	String regex = "^[A-Za-z0-9]{4,12}$";
    	boolean res = Pattern.matches(regex, this.dto.getPassword());
        return res;
    }
}