package com.jiwoo.web.service;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jiwoo.web.entity.Notice;
import com.jiwoo.web.entity.NoticeView;

public class NoticeService {

	//�Լ��޼ҵ�� �� ��ȯ Ÿ��, �ƴϸ� void
	//Ŭ������ ĸ��ȭ, �����Ǵ� ���񽺴� public
	
	//�����ڰ� �� �� �ִ� �޼ҵ� 
	//�ϰ� ���� ��� ���̵�ϱ� �迭�� ���
	public int removeNoticeAll(int[] ids){
		return 0;
	}
	//�ϰ� ����
	public int pubNoticeAll(int[] ids){
		return 0;
	}
	//�� ���					Notice ��ü�� ���� �޴´�
	public int insertNotice(Notice notice){
		return 0;
	}

	//�� ����
	public int deleteNotice(int id){
		return 0;
	}
	//�� ��������
	public int updateNotice(Notice notice){
		return 0;
	}
	//�ֽ� ��������
	List<Notice> getNoticeNewesList(){
		return null;
	}
	
		//List�÷����� �̿��� Notice�� ��ȯ�Ѵ�
	//�������� ù������
	public List<NoticeView> getNoticeList() {
		return getNoticeList("title", "", 1);
	}						//field, query,�⺻ ����page
	
	//������ ��ȣ ������ ��				������ ���� �ޱ�
	public List<NoticeView> getNoticeList(int page) {
		return getNoticeList("title", "", page);
							//field, query,page
	}
	
	//�޼ҵ� �̸��� ���� ��� �ߺ��Ǵϱ� -> ���ڰ� ���� �޼ҵ常 ����� ����
	//����, �̸�, ������ �˻����� ��
	public List<NoticeView> getNoticeList
		(String field/*TITLE, WRITER_ID*/, String query/*A*/, int page) {
		
		//controller�� �ִ� �ڵ� ��������
		//notice ��ü�� ������ �ʿ��ϱ� ������ 
		List<NoticeView> list = new ArrayList<>();
		
		//SQL������ �̰� �����̴�
		String sql = "SELECT * FROM (" +
				"	SELECT ROWNUM NUM, N. *" +		//TITLE	  //qeury���Ϻ�
				"	FROM (SELECT * FROM NOTICE_VIEW_ WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N"+
				"	) " +
				"	WHERE NUM BETWEEN ? AND ? ";
				//1, 11, 21,31 ..->an = 1+(page-1)*10
				//10, 20, 30..->page*10
		
				String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
				
				try {
					//�� 4���� ��ü�� �����ؾ��Ѵ�(new�� ��ü �������� ����) -> ���� �ٲ��� ���� 
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//ù��° �ε� ��ü ����
					//�޸𸮻� ����̹��� �ö�
					Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
					//�ι�° ���� ��ü ����
					//���� �Ǹ� ��ü ����
					//Statement st = con.createStatement();
					//con���� �̾� �޾� ����° ���� ��ü ����
					//����ڷκ��� �䱸 ���� ���� ����
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, "%"+query+"%");
					st.setInt(2, 1+(page-1)*10);
					st.setInt(3, page*10);
					
					ResultSet rs = st.executeQuery();


									
					while(rs.next()) {
						int id = rs.getInt("ID");
						String title = rs.getString("TITLE");
						Date regdate = rs.getDate("REGDATE");
						String writerid = rs.getString("WRITER_ID");
						String hit = rs.getString("HIT");
						String files = rs.getString("FILES");
						//String content = rs.getString("CONTENT"); �信�� ����
						int cmtCount = rs.getInt("CMT_COUNT");
						
						//notice��ü�׸��� ������(�Ӽ���)���, �����ڿ� ���� �����ϰ�
						NoticeView notice = new NoticeView(
											id,
											title,
											regdate,
											writerid,
											hit,
											files,
											//content,
											cmtCount
											);
						list.add(notice);
					
						}
				    	rs.close();
				    	st.close();
				        con.close();
				        
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
				return list;
		
	}
	
	//���� ������ �˷��ִ� ���� 1/5 page �̷���
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	//���� ������ �˷��ִ� ���� 1/5 page �̷���
	public int getNoticeCount(String field, String query) {
		
		//�⺻�� ����
		int count = 0;
		
		//SQL������ �̰� �����̴�
		String sql = "SELECT COUNT(ID) COUNT FROM (" +
				"	SELECT ROWNUM NUM, N. *" +
				"	FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N"+
				"	) ";
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			//�� 4���� ��ü�� �����ؾ��Ѵ�(new�� ��ü �������� ����) -> ���� �ٲ��� ���� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ù��° �ε� ��ü ����
			//�޸𸮻� ����̹��� �ö�
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//�ι�° ���� ��ü ����
			//���� �Ǹ� ��ü ����
			//Statement st = con.createStatement();
			//con���� �̾� �޾� ����° ���� ��ü ����
			//����ڷκ��� �䱸 ���� ���� ����
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			
			ResultSet rs = st.executeQuery();

			if(rs.next())
				//����� �ƴ� ���� ī��Ʈ��
				count = rs.getInt("count");				
			
		    	rs.close();
		    	st.close();
		        con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//���û��� �ڼ��� ������ -> ID�� �ޱ�
	public Notice getNotice(int id) {
		
		Notice notice = null;
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			//�� 4���� ��ü�� �����ؾ��Ѵ�(new�� ��ü �������� ����) -> ���� �ٲ��� ���� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ù��° �ε� ��ü ����
			//�޸𸮻� ����̹��� �ö�
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//�ι�° ���� ��ü ����
			//���� �Ǹ� ��ü ����
			//Statement st = con.createStatement();
			//con���� �̾� �޾� ����° ���� ��ü ����
			//����ڷκ��� �䱸 ���� ���� ����
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			
			
			ResultSet rs = st.executeQuery();


							
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerid = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				//notice��ü�׸��� ������(�Ӽ���)���, �����ڿ� ���� �����ϰ�
				notice = new Notice(
									nid,
									title,
									regdate,
									writerid,
									hit,
									files,
									content
									);
				
				}
		    	rs.close();
		    	st.close();
		        con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return notice;
	}
	
	//������ -> ID�� �ޱ� : ������ ���� �˾ƾ��Ѵ�
	//ID�� 3�� ����ۿ��� ������ �������� , 
	//����� ����ؼ� �����Ǳ� ������ ��¥�� ���� ��Ƽ�  -> ���纸�� ū ��¥�� ROWNUM1�� ������ 
	public Notice getNextNotice(int id) {
		Notice notice = null;
		String sql = "SELECT * FROM NOTICE WHERE ID = (" +
			    "	SELECT ID FROM NOTICE " +
			    "	WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID =?) " +
			    "	AND ROWNUM = 1 " +
			    "	)";
String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			//�� 4���� ��ü�� �����ؾ��Ѵ�(new�� ��ü �������� ����) -> ���� �ٲ��� ���� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ù��° �ε� ��ü ����
			//�޸𸮻� ����̹��� �ö�
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//�ι�° ���� ��ü ����
			//���� �Ǹ� ��ü ����
			//Statement st = con.createStatement();
			//con���� �̾� �޾� ����° ���� ��ü ����
			//����ڷκ��� �䱸 ���� ���� ����
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			
			
			ResultSet rs = st.executeQuery();


							
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerid = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				//notice��ü�׸��� ������(�Ӽ���)���, �����ڿ� ���� �����ϰ�
				notice = new Notice(
									nid,
									title,
									regdate,
									writerid,
									hit,
									files,
									content
									);
				
				}
		    	rs.close();
		    	st.close();
		        con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return notice;
	}
	//������ -> ID�� �ޱ� : ������ ���� �˾ƾ��Ѵ�
	public Notice gePrevtNotice(int id) {
		Notice notice = null;
		String sql = "SELECT * FROM NOTICE WHERE ID = (" +
				"	SELECT ID FROM NOTICE" +  
			    "	WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID =?)"+
			    "	AND ROWNUM = 1";
		
String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			//�� 4���� ��ü�� �����ؾ��Ѵ�(new�� ��ü �������� ����) -> ���� �ٲ��� ���� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ù��° �ε� ��ü ����
			//�޸𸮻� ����̹��� �ö�
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//�ι�° ���� ��ü ����
			//���� �Ǹ� ��ü ����
			//Statement st = con.createStatement();
			//con���� �̾� �޾� ����° ���� ��ü ����
			//����ڷκ��� �䱸 ���� ���� ����
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			
			
			ResultSet rs = st.executeQuery();


							
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerid = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				//notice��ü�׸��� ������(�Ӽ���)���, �����ڿ� ���� �����ϰ�
				notice = new Notice(
									nid,
									title,
									regdate,
									writerid,
									hit,
									files,
									content
									);
				
				}
		    	rs.close();
		    	st.close();
		        con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return notice;
	}

	public int deleteNoticeAll(int[] ids) {

		//� ���� �ߴ���
		int result = 0;
		String params = "";
				//ids ������ŭ �ݺ�
		for(int i = 0; i<ids.length; i++) {
			params += ids[i];
			if(i < ids.length-1)//�������� ������ �ȵ�
				params += ",";//������
		}								//id ���������� in
		String sql = "SELETE NOTICE WHERE ID IN("+params+")";
		
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			//�� 4���� ��ü�� �����ؾ��Ѵ�(new�� ��ü �������� ����) -> ���� �ٲ��� ���� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ù��° �ε� ��ü ����
			//�޸𸮻� ����̹��� �ö�
			Connection con = DriverManager.getConnection(url,"NEWJDBC","1234");
			//�ι�° ���� ��ü ����
			//���� �Ǹ� ��ü ����
			Statement st = con.createStatement();
			//con���� �̾� �޾� ����° ���� ��ü ����
			//����ڷκ��� �䱸 ���� ���� ����
			//PreparedStatement st = con.prepareStatement(sql);
			
			//ResultSet rs = st.executeQuery();
			result = st.executeUpdate(sql);

		    st.close();
		    con.close();
		        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
