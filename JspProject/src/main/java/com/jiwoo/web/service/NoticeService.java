package com.jiwoo.web.service;

import java.util.List;

import com.jiwoo.web.entity.Notice;

public class NoticeService {

	//�Լ��޼ҵ�� �� ��ȯ Ÿ��, �ƴϸ� void
	//Ŭ������ ĸ��ȭ, �����Ǵ� ���񽺴� public
	
		//List�÷����� �̿��� Notice�� ��ȯ�Ѵ�
	//�������� ù������
	public List<Notice> getNoticeList() {
		return getNoticeList("title", "", 1);
	}						//field, query,�⺻ ����page
	
	//������ ��ȣ ������ ��				������ ���� �ޱ�
	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title", "", page);
							//field, query,page
	}
	
	//�޼ҵ� �̸��� ���� ��� �ߺ��Ǵϱ� -> ���ڰ� ���� �޼ҵ常 ����� ����
	//����, �̸�, ������ �˻����� ��
	public List<Notice> getNoticeList(String field, String query, int page) {
		
		//SQL������ �̰� �����̴�
		String sql = "SELECT * FROM (" +
				"	SELECT ROWNUM NUM, N. *" +
				"	FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N"+
				"	) " +
				"	WHERE NUM BETWEEN 6 AND 10; ";
		
		return null;
	}
	
	//���� ������ �˷��ִ� ���� 1/5 page �̷���
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	//���� ������ �˷��ִ� ���� 1/5 page �̷���
	public int getNoticeCount(String field, String query) {
		//SQL������ �̰� �����̴�
		String sql = "SELECT * FROM (" +
				"	SELECT ROWNUM NUM, N. *" +
				"	FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N"+
				"	) " +
				"	WHERE NUM BETWEEN 6 AND 10;";
		return 0;
	}
	
	//���û��� �ڼ��� ������ -> ID�� �ޱ�
	public Notice getNotice(int id) {
		String sql = "SELECT * FROM nOTICE WHERE ID=?";
		
		return null;
	}
	
	//������ -> ID�� �ޱ� : ������ ���� �˾ƾ��Ѵ�
	//ID�� 3�� ����ۿ��� ������ �������� , 
	//����� ����ؼ� �����Ǳ� ������ ��¥�� ���� ��Ƽ�  -> ���纸�� ū ��¥�� ROWNUM1�� ������ 
	public Notice getNextNotice(int id) {
		String sql = "SELECT * FROM NOTICE WHERE ID = (" +
			    "	SELECT ID FROM NOTICE " +
			    "	WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID =13) " +
			    "	AND ROWNUM = 1 " +
			    "	)";
		return null;
	}
	//������ -> ID�� �ޱ� : ������ ���� �˾ƾ��Ѵ�
	public Notice gePrevtNotice(int id) {
		String sql = "SELECT * FROM NOTICE WHERE ID = (" +
				"	SELECT ID FROM NOTICE" +  
			    "	WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID =13)"+
			    "	AND ROWNUM = 1";
		return null;
	}
	
	
}
