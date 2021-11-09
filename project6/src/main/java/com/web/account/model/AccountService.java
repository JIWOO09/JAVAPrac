package com.web.account.model;

import java.sql.SQLException;

public class AccountService {
   private AccountDTO dto;
   
   public AccountService(AccountDTO dto) {
      //초기 생성자 패스
      this.dto = dto;
   }
   
   public boolean join() throws SQLException {
	   if(this.dto == null) {
		   return false;
	   }
	   AccountDAO dao = new AccountDAO();
	   int res = dao.createAccount(this.dto);
	   if(res == 1) {
		   return true;
	   }
	   return false;
   }
   
   //boolean형 리턴
   // isValid 안에서 전부 검사하는 걸로
   //return값은 true or false 
   public boolean isValid() {
      
      //검사하다 혹시 모르니깐
      if (this.dto == null) {
         return false;
      }
      if(!usernameValid() || !passwordValid()) {
         return false;
      }
       return true;
   }
      private boolean usernameValid() {
      boolean isUsernameValid = true;
       if(this.dto.getUsername().length() >= 4 
             && this.dto.getUsername().length() <= 16) {
             for(int i = 0; i < this.dto.getUsername().length(); i++) {
                System.out.println(isUsernameValid);
                   if(this.dto.getUsername().charAt(i) >= 'a' && this.dto.getUsername().charAt(i) <= 'z') {
                      isUsernameValid = true;
                   } else if(this.dto.getUsername().charAt(i) >= '0' && this.dto.getUsername().charAt(i) <= '9') {
                      isUsernameValid = true;
                   } else if(this.dto.getUsername().charAt(i) == '_') {
                      isUsernameValid = true;
                   } else {
                      isUsernameValid = false;
                   }
                   System.out.println(isUsernameValid + "|" + this.dto.getUsername().charAt(i));
                   if(!isUsernameValid) {
                      break;
                   }
             }
             return isUsernameValid;
         }
       return false;
   }
      private boolean passwordValid() {
         boolean ispasswordValid = true;
          if(this.dto.getPassword().length() >= 4 
                && this.dto.getPassword().length() <= 16) {
                for(int i = 0; i < this.dto.getPassword().length(); i++) {
                   System.out.println(ispasswordValid);
                      if(this.dto.getPassword().charAt(i) >= 'a' && this.dto.getPassword().charAt(i) <= 'z') {
                         ispasswordValid = true;
                      } else if(this.dto.getPassword().charAt(i) >= '0' && this.dto.getPassword().charAt(i) <= '9') {
                         ispasswordValid = true;
                      } else if(this.dto.getPassword().charAt(i) == '_') {
                         ispasswordValid = true;
                      } else {
                         ispasswordValid = false;
                      }
                      System.out.println(ispasswordValid + "|" + this.dto.getPassword().charAt(i));
                      if(!ispasswordValid) {
                         break;
                      }
                }
                return ispasswordValid;
            }
          return false;
   }
}