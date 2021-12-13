package com.jspweb.dbconn;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 자바 오브젝트와 SQL사이의 자동 매핑 기능을 지원하는 ORM(Object relational Mapping)프레임워크
public class MybatisConnect {
	private SqlSession sess = null;
	
	public MybatisConnect() {
		this.connect();
	}

	private void connect () {
		String resource = "resources/mybatis-config.xml";
	try {	
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactoryBuilder builder = new  SqlSessionFactoryBuilder();
		this.sess = builder.build(is).openSession(false); // AutoCommit 비활성
	} catch (IOException e) {
		e.printStackTrace();
		}	
	
	}
	
	public SqlSession getSession() {
		if(this.sess == null) {
			this.connect();
		}
		return this.sess;
	}
	
	public void commit() {
		this.sess.commit();
	}
	public void rollback() {
		this.sess.rollback();
	}
	public void close() {
		this.sess.close();
	}
}