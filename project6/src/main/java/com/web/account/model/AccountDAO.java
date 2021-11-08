package com.web.account.model;

import com.jspweb.dbconn.*;
import java.sql.*;

public class AccountDAO {
    OracleCloudConnect occ = null;
    
    public AccountDAO() throws SQLException {
        this.occ = new OracleCloudConnect();
        this.occ.connection();
    }
    
    public int createAccount(AccountDTO dto) throws SQLException {
        int res = occ.insertQuery(
            "INSERT INTO ACCOUNTS VALUES(ACCOUNTS_SEQ.NEXTVAL, '"
                + dto.getUsername() +"', '"+ dto.getPassword() + "')"
        );
        
        if(res == 1) {
        	commit();
        } else {
        	rollback();
        }
        
        occ.close();
        return res;
    }
    
    private void commit() throws SQLException {
    	occ.commit();
    }
    
    private void rollback() throws SQLException {
    	occ.rollback();
    }
}
