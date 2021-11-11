package com.web.guestbook.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCloudConnect;


public class GuestBookDAO {
	
	//데이터베이스연결
	OracleCloudConnect occ = null;
	
	public GuestBookDAO() throws SQLException {
        this.occ = new OracleCloudConnect();
        this.occ.connection();
	}
	
	public List<GuestBookDTO> select() throws SQLException{
		List<GuestBookDTO> datas = new ArrayList<GuestBookDTO>();
		
		String query = "SELECT * FROM GUESTBOOK ORDER BY G_DATE DESC";
		ResultSet res = occ.sendQuery(query);
		
		while(res.next()) {
			GuestBookDTO dto = new GuestBookDTO();
			dto.setId(res.getInt("g_id")); //인덱스 또는 컬럼명으로 지정
			dto.setIpaddr(res.getString("g_ipaddr"));
			dto.setContext(res.getString("g_context"));
			dto.setDate(res.getDate("g_date"));
			datas.add(dto);
		}
		res.close();
		occ.close();
		return datas;
	}
	
	public boolean insert(GuestBookDTO dto) throws SQLException {
		String query = "INSERT INTO GUESTBOOK VALUES(" + "GUESTBOOK_SEQ.NEXTVAL, " 
													   + "'" + dto.getIpaddr() + "', " 
													   + "'" + dto.getContext() + "', "
													   + "SYSDATE" 
													   + ")";
		int res = occ.insertQuery(query);
		occ.close();
		if(res == 1) {
			return true;
		}
		return false;
	}
	
	public void commit() throws SQLException {
    	occ.commit();
    }
    
    public void rollback() throws SQLException {
    	occ.rollback();
    }
	
}
