package com.kh.exam1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.db.conn.OracleCloudConnect;

class DeptCount {
	private String name;
	private int count;
	
	public DeptCount(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DeptCount [name=" + name + ", count=" + count + "]";
	}
	
}

public class Sample2 {

	public static void main(String[] args) {
		OracleCloudConnect occ;
		try {
			occ = new OracleCloudConnect();
			occ.connection();
			
			// EMPLOYEES 테이블을 사용하여 부서별 인원수를 구하여 본다.
			String query = ""
					+ "SELECT B.DEPARTMENT_NAME"
					+ "     , COUNT(A.EMPLOYEE_ID)"
					+ "  FROM EMPLOYEES A JOIN DEPARTMENTS B"
					+ "    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID"
					+ " WHERE A.DEPARTMENT_ID IS NOT NULL"
					+ " GROUP BY B.DEPARTMENT_NAME"
					+ " ORDER BY B.DEPARTMENT_NAME";
			ResultSet res = occ.sendQuery(query);
			
			// Set 컬렉션에 조회 데이터를 담아본다.
			Set<DeptCount> deptSet = new HashSet<DeptCount>();
			while(res.next()) {
				System.out.println(res.getString(1) + "|" + res.getInt(2));
				deptSet.add(new DeptCount(res.getString(1), res.getInt(2)));
			}
			System.out.println(deptSet);
			
			// EMPLOYEES 테이블을 사용하여 급여기 8000 이상인 사원을 조회 후
			// Set 컬렉션에 담아본다. (사원명, 급여액, 연봉)
			
			res.close();
			occ.close();
			occ.connectionClose();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
