package com.kh.exam1;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleCloudConnect;

class StudentAvg {
	private String stdNo;
	private String stdName;
	private double stdPoint;
	
	public StudentAvg(String stdNo, String stdName, double stdPoint) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdPoint = stdPoint;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public double getStdPoint() {
		return stdPoint;
	}

	public void setStdPoint(double stdPoint) {
		this.stdPoint = stdPoint;
	}

	@Override
	public String toString() {
		return "StudentAvg [번호=\"" + stdNo + "\", 이름=\"" + stdName
				+ "\", 평균학점=" + stdPoint + "]";
	}
	
	
}

class DeptInfo {
	private String deptNo;
	private String deptName;
	private int stdCount;
	private int proCount;
	
	public DeptInfo(String deptNo, String deptName, int stdCount, int proCount) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.stdCount = stdCount;
		this.proCount = proCount;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getStdCount() {
		return stdCount;
	}

	public void setStdCount(int stdCount) {
		this.stdCount = stdCount;
	}

	public int getProCount() {
		return proCount;
	}

	public void setProCount(int proCount) {
		this.proCount = proCount;
	}

	@Override
	public String toString() {
		return "DeptInfo [학과코드=\"" + deptNo + "\", 학과명=\"" + deptName
				+ "\", 학생수=" + stdCount + ", 교수인원="
				+ proCount + "]";
	}
	
}

public class Sample7 {

	public static void main(String[] args) {
		OracleCloudConnect occ;
		try {
			occ = new OracleCloudConnect();
			occ.connection();
			
			/*
			3. 1, 2번에서 생성한 테이블을 사용하여 Java OJDBC 로 조회하여 출력하는 코드를 만든다.
				- [StudentAvg [번호="A000000", 이름="홍길동", 평균학점=3.7], StudentAvg [ ... ], ...]
				- [DeptInfo [학과코드="001", 학과명="XXXX학과", 학생수=25, 교수인원=5], DeptInfo [ ... ], ...]
		    */
			String query = "SELECT * FROM STD_AVG_POINT";
			ResultSet res = occ.sendQuery(query);
			
			List<StudentAvg> sList = new ArrayList<StudentAvg>();
			
			while(res.next()) {
				sList.add(new StudentAvg(
						res.getString(2),
						res.getString(3),
						res.getDouble(4)
					));
			}
			
			System.out.println(sList);
			
			query = "SELECT * FROM DEPT_STD_PRO_COUNT";
			res = occ.sendQuery(query);
			
			List<DeptInfo> dList = new ArrayList<DeptInfo>();
			
			while(res.next()) {
				dList.add(new DeptInfo(
						res.getString(1),
						res.getString(2),
						res.getInt(3),
						res.getInt(4)
					));
			}
			
			System.out.println(dList);
			
			res.close();
			occ.close();
			occ.connectionClose();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}