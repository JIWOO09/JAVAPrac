package com.web.guestbook.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCloudConnect;


public class GuestBookDAO {
	//데이터베이스연결
    OracleCloudConnect occ = null;
    
    public GuestBookDAO() {
        try {
			this.occ = new OracleCloudConnect();
			this.occ.connection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public List<GuestBookDTO> select() {
    	List<GuestBookDTO> datas = new ArrayList<GuestBookDTO>();
    	
    	String query = "SELECT * FROM GUESTBOOK ORDER BY G_DATE DESC";
    	ResultSet res;
		try {
			res = occ.sendQuery(query);
			while(res.next()) {
				GuestBookDTO dto = new GuestBookDTO();
				dto.setId(res.getInt("g_id"));//인덱스 또는 컬럼명으로 지정
				dto.setIpaddr(res.getString("g_ipaddr"));
				dto.setContext(res.getString("g_context"));
				dto.setDate(res.getDate("g_date"));
				datas.add(dto);
			}
			
			res.close();
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return datas;
    }
    
    public GuestBookDTO select(int id) {
    	GuestBookDTO dto = new GuestBookDTO();
    	String query = "SELECT * FROM GUESTBOOK"
    			+ " WHERE G_ID = " + id;
    	
    	try {
			ResultSet res = occ.sendQuery(query);
			res.next();
			dto.setResultSet(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return dto;
    }
    
    public boolean insert(GuestBookDTO dto) {
        String query = "INSERT INTO GUESTBOOK VALUES("
                + "GUESTBOOK_SEQ.NEXTVAL, "
                + "'" + dto.getIpaddr() + "', "
                + "'" + dto.getContext() + "', "
                + "SYSDATE"
                + ")";
        
        int res = 0;        
		try {
			res = occ.insertQuery(query);
			occ.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return res == 1 ? true : false;
    }
    
    public boolean update(GuestBookDTO dto) {
    	String query = "UPDATE GUESTBOOK"
    			+ "  SET"
    			+ "    G_CONTEXT = '" + dto.getContext() + "'"
    			+ "  WHERE G_ID = " + dto.getId() + "";
   
    	int res = 0;
    	try {
    		res = occ.insertQuery(query);
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
   
    	
    	return res == 1 ? true : false;
    }
    
    public boolean delete(GuestBookDTO dto) {
    	String query = "DELETE FROM GUESTBOOK"
    			+ " WHERE G_ID = " + dto.getId() + "";
    	int res = 0;
    	try {
			res = occ.deleteQuery(query);
			occ.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
    	
    	return res == 1 ? true : false;
    }
    
    public void commit() {
        try {
			occ.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void rollback() {
        try {
			occ.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void close() {
    	try {
			occ.connectionClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
